
package baseDatos;


import aplicacion.Producto;
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
public class DAOProductos extends AbstractDAO {
    
    public DAOProductos (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public List<Producto> buscarProductos(String nombre,Float precio,String ordenarPor){
        List<Producto> resultado=new ArrayList<Producto>();
        Producto productoActual;
        Connection con;
        PreparedStatement stmProductos=null;
        ResultSet rsProductos;

        con=this.getConexion();
        
        String consulta = "select nombre,precio_compra,existencias " +
                                         "from Producto "+
                                         "where nombre like ? ";
        if(precio!=null){
            consulta=consulta+"and precio_compra=? ";
        }
        if(ordenarPor.equals("Orden alfabético (ascendente)")){
            consulta=consulta+"order by nombre asc ";
        }
        if(ordenarPor.equals("Orden alfabético (descendente)")){
            consulta=consulta+"order by nombre desc ";
        }
        if(ordenarPor.equals("Precio (ascendente)")){
            consulta=consulta+"order by precio_compra asc ";
        }
        if(ordenarPor.equals("Precio (descendente)")){
            consulta=consulta+"order by precio_compra desc ";
        }
        try  {
         stmProductos=con.prepareStatement(consulta);
         stmProductos.setString(1, "%"+nombre+"%");
         if(precio!=null){
             stmProductos.setFloat(2, precio);
         }
         rsProductos=stmProductos.executeQuery();
        while (rsProductos.next())
        {
            productoActual=new Producto(rsProductos.getString(1),rsProductos.getFloat(3),rsProductos.getFloat(2));
            resultado.add(productoActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmProductos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public void borrarProducto(Producto p){
        Connection con;
        PreparedStatement stmProducto=null;

        con=super.getConexion();

        try {
        stmProducto=con.prepareStatement("delete from Productos where nombre = ?");
        stmProducto.setString(1, p.getNombre());
        stmProducto.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmProducto.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public void modificarProducto(Producto p){
        Connection con;
        PreparedStatement stmProducto=null;
        String query;
        

        con=super.getConexion();
        
        try {
        stmProducto=con.prepareStatement("update Producto "+
                                    "set existencias=?, "
                                    + "precio=?, "+
                                    "where nombre=?");
        stmProducto.setFloat(1, p.getExistencias());
        stmProducto.setFloat(2, p.getPrecio_compra());
        stmProducto.setString(3, p.getNombre());
        stmProducto.executeUpdate();


        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmProducto.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public void anhadirProducto(Producto p){
        Connection con;
        PreparedStatement stmProducto=null;
        String query;
        

        con=super.getConexion();
        
        try {
        stmProducto=con.prepareStatement("insert into Producto(existencias,precio,nombre) "+
                                    "values(?,?,?) ");
        stmProducto.setFloat(1, p.getExistencias());
        stmProducto.setFloat(2, p.getPrecio_compra());
        stmProducto.setString(3, p.getNombre());
        stmProducto.executeUpdate();


        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmProducto.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
}
