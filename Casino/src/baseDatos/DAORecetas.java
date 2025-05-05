
package baseDatos;

import aplicacion.Bar;
import aplicacion.Producto;
import aplicacion.Receta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumnogreibd
 */
public class DAORecetas extends AbstractDAO {
    
    public DAORecetas (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public List<Receta> buscarRecetas(String nombre,Float precio,String ordenarPor){
        List<Receta> resultado=new ArrayList<Receta>();
        Receta recetaActual;
        Connection con;
        PreparedStatement stmRecetas=null;
        ResultSet rsRecetas;

        con=this.getConexion();
        
        String consulta = "select nombre,precio_venta " +
                                         "from Receta as r "+
                                         "where nombre like ? ";
        if(precio!=null){
            consulta=consulta+"and precio_venta=? ";
        }
        if(ordenarPor.equals("Orden alfabético (ascendente)")){
            consulta=consulta+"order by nombre asc ";
        }
        if(ordenarPor.equals("Orden alfabético (descendente)")){
            consulta=consulta+"order by nombre desc ";
        }
        if(ordenarPor.equals("Precio (ascendente)")){
            consulta=consulta+"order by precio_venta asc ";
        }
        if(ordenarPor.equals("Precio (descendente)")){
            consulta=consulta+"order by precio_venta desc ";
        }
        try  {
         stmRecetas=con.prepareStatement(consulta);
         stmRecetas.setString(1, "%"+nombre+"%");
         if(precio!=null){
             stmRecetas.setFloat(2, precio);
         }
         rsRecetas=stmRecetas.executeQuery();
        while (rsRecetas.next())
        {
            recetaActual=new Receta(rsRecetas.getString(1),rsRecetas.getFloat(2));
            resultado.add(recetaActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmRecetas.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public void borrarReceta(Receta r){
        Connection con;
        PreparedStatement stmReceta=null;

        con=super.getConexion();

        try {
        stmReceta=con.prepareStatement("delete from utilizar_receta where utilizar_receta.nombre_receta = ?");
        stmReceta.setString(1, r.getNombre());
        stmReceta.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmReceta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        try {
        stmReceta=con.prepareStatement("delete from Receta where Receta.nombre = ?");
        stmReceta.setString(1, r.getNombre());
        stmReceta.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmReceta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public List<Bar> baresRecetaDisponible(Receta r){
        List<Bar> resultado=new ArrayList<Bar>();
        Connection con;
        String query;
        PreparedStatement stmBares=null;
        ResultSet rsBares;

        con=this.getConexion();
        
        query = "select Bar.nombre, Bar.id "+
                "from  Bar "+
                "where Bar.id in ( "
                + "select bar_receta.bar "
                + "from bar_receta "
                + "where bar_receta.receta=? "
                + ") ";

        try {
        stmBares=con.prepareStatement(query);
        stmBares.setString(1, r.getNombre());
        rsBares=stmBares.executeQuery();
        while (rsBares.next())
        {
            resultado.add(new Bar(rsBares.getString(1),rsBares.getInt(2)));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmBares.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public List<Bar> baresRecetaNoDisponible(Receta r){
        List<Bar> resultado=new ArrayList<Bar>();
        Connection con;
        String query;
        PreparedStatement stmBares=null;
        ResultSet rsBares;

        con=this.getConexion();
        
        query = "select Bar.nombre, Bar.id "+
                "from  Bar "+
                "where not Bar.id in ( "
                + "select bar_receta.bar "
                + "from bar_receta "
                + "where bar_receta.receta=? "
                + ") ";

        try {
        stmBares=con.prepareStatement(query);
        stmBares.setString(1, r.getNombre());
        rsBares=stmBares.executeQuery();
        while (rsBares.next())
        {
            resultado.add(new Bar(rsBares.getString(1),rsBares.getInt(2)));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmBares.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public List<Producto> todosLosProductos(){
        List<Producto> resultado=new ArrayList<Producto>();
        Connection con;
        String query;
        PreparedStatement stmProductos=null;
        ResultSet rsProductos;

        con=this.getConexion();
        
        query = "select Producto.nombre, Producto.existencias, Producto.precio_compra "+
                "from  Producto ";

        try {
        stmProductos=con.prepareStatement(query);
        rsProductos=stmProductos.executeQuery();
        while (rsProductos.next())
        {
            resultado.add(new Producto(rsProductos.getString(1),rsProductos.getInt(1),rsProductos.getFloat(3)));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmProductos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public Float cantidadReceta(Receta r,Producto p){
        Float resultado=0.0f;
        Connection con;
        String query;
        PreparedStatement stmCantidad=null;
        ResultSet rsCantidad;

        con=this.getConexion();
        
        query = "select utilizar_receta.cantidad "+
                "from  utilizar_receta "
                + "where utilizar_receta.nombre_receta=? "
                + "and utilizar_receta.nombre_producto=? ";

        try {
        stmCantidad=con.prepareStatement(query);
        stmCantidad.setString(1, r.getNombre());
        stmCantidad.setString(2, p.getNombre());
        rsCantidad=stmCantidad.executeQuery();
        if (rsCantidad.next())
        {
            resultado=rsCantidad.getFloat(1);

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCantidad.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public void modificarReceta(Receta receta,List<Bar> bares,List<Producto> productos,List<Float> cantidades){
        Connection con;
        PreparedStatement stmReceta=null;
        String query;
        
        int nbares=bares.size();
        int nproductos=productos.size();
        int i;

        con=super.getConexion();

        try {
        stmReceta=con.prepareStatement("delete from bar_receta where bar_receta.receta = ?");
        stmReceta.setString(1, receta.getNombre());
        stmReceta.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmReceta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        try {
        stmReceta=con.prepareStatement("delete from utilizar_receta where utilizar_receta.nombre_receta = ?");
        stmReceta.setString(1, receta.getNombre());
        stmReceta.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmReceta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        try {
        stmReceta=con.prepareStatement("update Receta "+
                                    "set precio_venta=? "+
                                    "where nombre=?");
        stmReceta.setFloat(1, receta.getPrecio_venta());
        stmReceta.setString(2, receta.getNombre());
        stmReceta.executeUpdate();


        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmReceta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        for(i=0;i<nbares;i++){
            try{
                stmReceta=con.prepareStatement("insert into bar_receta(bar,receta) "+
                                        "values(?,?) ");
                stmReceta.setInt(1, bares.get(i).getId());
                stmReceta.setString(2, receta.getNombre());
            }catch (SQLException e){
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }finally{
                 try {stmReceta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
            }
        }
        
        for(i=0;i<nproductos;i++){
            if(cantidades.get(i)>0.0f){
                try{
                    stmReceta=con.prepareStatement("insert into utilizar_receta(nombre_producto,nombre_receta,cantidad) "+
                                            "values(?,?) ");
                    stmReceta.setString(1, productos.get(i).getNombre());
                    stmReceta.setString(2, receta.getNombre());
                    stmReceta.setFloat(3, cantidades.get(i));
                }catch (SQLException e){
                    System.out.println(e.getMessage());
                    this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                }finally{
                     try {stmReceta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
                }
            }
        }
        
    }
    
    public List<Bar> todosLosBares(){
        List<Bar> resultado=new ArrayList<Bar>();
        Connection con;
        String query;
        PreparedStatement stmBares=null;
        ResultSet rsBares;

        con=this.getConexion();
        
        query = "select Bar.nombre, Bar.id "+
                "from  Bar ";

        try {
        stmBares=con.prepareStatement(query);
        rsBares=stmBares.executeQuery();
        while (rsBares.next())
        {
            resultado.add(new Bar(rsBares.getString(1),rsBares.getInt(2)));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmBares.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public void anhadirReceta(Receta receta,List<Bar> bares,List<Producto> productos,List<Float> cantidades){
        Connection con;
        PreparedStatement stmReceta=null;
        String query;
        
        int nbares=bares.size();
        int nproductos=productos.size();
        int i;

        con=super.getConexion();

        try {
        stmReceta=con.prepareStatement("insert into Receta(precio_venta,nombre) "+
                                    "values(?,?) ");
        stmReceta.setFloat(1, receta.getPrecio_venta());
        stmReceta.setString(2, receta.getNombre());
        stmReceta.executeUpdate();


        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmReceta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        for(i=0;i<nbares;i++){
            try{
                stmReceta=con.prepareStatement("insert into bar_receta(bar,receta) "+
                                        "values(?,?) ");
                stmReceta.setInt(1, bares.get(i).getId());
                stmReceta.setString(2, receta.getNombre());
            }catch (SQLException e){
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }finally{
                 try {stmReceta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
            }
        }
        
        for(i=0;i<nproductos;i++){
            if(cantidades.get(i)>0.0f){
                try{
                    stmReceta=con.prepareStatement("insert into utilizar_receta(nombre_producto,nombre_receta,cantidad) "+
                                            "values(?,?) ");
                    stmReceta.setString(1, productos.get(i).getNombre());
                    stmReceta.setString(2, receta.getNombre());
                    stmReceta.setFloat(3, cantidades.get(i));
                }catch (SQLException e){
                    System.out.println(e.getMessage());
                    this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                }finally{
                     try {stmReceta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
                }
            }
        }
        
    }
    
}
