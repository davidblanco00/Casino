/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Servicios;
import aplicacion.Zonas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author basesdatos
 */
public class DAOServicios extends AbstractDAO{
   
    public DAOServicios (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    
   
    public List<Servicios> buscarServicios(String nombre,String ordenarPor){
        List<Servicios> resultado=new ArrayList<>();
        Servicios servicioActual;
        Connection con;
        PreparedStatement stmServicios=null;
        ResultSet rsServicios;

        con=this.getConexion();
        
        String consulta = "select nombre,descripcion " +
                                         "from Servicios "+
                                         "where nombre like ? ";
        
        if(ordenarPor.equals("Orden alfabético (ascendente)")){
            consulta=consulta+"order by nombre asc ";
        }
        if(ordenarPor.equals("Orden alfabético (descendente)")){
            consulta=consulta+"order by nombre desc ";
        }
        try  {
         stmServicios=con.prepareStatement(consulta);
         stmServicios.setString(1, "%"+nombre+"%");
         rsServicios=stmServicios.executeQuery();
        while (rsServicios.next())
        {
            servicioActual=new Servicios(rsServicios.getString(1),rsServicios.getString(2));
            resultado.add(servicioActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmServicios.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public void borrarServicio(Servicios s){
        Connection con;
        PreparedStatement stmServicio=null;

        con=super.getConexion();

        try {
        stmServicio=con.prepareStatement("delete from Servicios where nombre = ?");
        stmServicio.setString(1, s.getNombre());
        stmServicio.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmServicio.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public List<Zonas> zonasDisponible(Servicios s){
        List<Zonas> resultado=new ArrayList<Zonas>();
        Connection con;
        String query;
        PreparedStatement stmZonas=null;
        ResultSet rsZonas;

        con=this.getConexion();
        
        query = "select Zonas.nombre "+
                "from  Zonas "+
                "where nombre in ( "
                + "select zona "
                + "from zonas_servicios "
                + "where servicio=? "
                + ") ";

        try {
        stmZonas=con.prepareStatement(query);
        stmZonas.setString(1, s.getNombre());
        rsZonas=stmZonas.executeQuery();
        while (rsZonas.next())
        {
            resultado.add(new Zonas(rsZonas.getString(1)));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmZonas.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public List<Zonas> zonasNoDisponible(Servicios s){
        List<Zonas> resultado=new ArrayList<Zonas>();
        Connection con;
        String query;
        PreparedStatement stmZonas=null;
        ResultSet rsZonas;

        con=this.getConexion();
        
        query = "select Zonas.nombre "+
                "from  Zonas "+
                "where not nombre in ( "
                + "select zona "
                + "from zonas_servicios "
                + "where servicio=? "
                + ") ";

        try {
        stmZonas=con.prepareStatement(query);
        stmZonas.setString(1, s.getNombre());
        rsZonas=stmZonas.executeQuery();
        while (rsZonas.next())
        {
            resultado.add(new Zonas(rsZonas.getString(1)));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmZonas.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public void modificarServicio(Servicios s, List<Zonas> disponible){
        Connection con;
        PreparedStatement stmEmpleado=null;
        String query;
        
        int nzonas=disponible.size();
        int i;

        con=super.getConexion();

        try {
        stmEmpleado=con.prepareStatement("delete from zonas_servicios where servicio = ?");
        stmEmpleado.setString(1, s.getNombre());
        stmEmpleado.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmEmpleado.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        try {
        stmEmpleado=con.prepareStatement("update Servicios "+
                                    "set descripcion=? "+
                                    "where nombre=?");
        stmEmpleado.setString(1, s.getDescripcion());
        stmEmpleado.setString(2, s.getNombre());
        stmEmpleado.executeUpdate();


        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmEmpleado.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        for(i=0;i<nzonas;i++){
            try{
                stmEmpleado=con.prepareStatement("insert into zonas_servicios(zona,servicio) "+
                                        "values(?,?) ");
                stmEmpleado.setString(1, disponible.get(i).getNombre());
                stmEmpleado.setString(2, s.getNombre());
            }catch (SQLException e){
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }finally{
                 try {stmEmpleado.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
            }
        }
    }
    
    public void anhadirServicio(Servicios s, List<Zonas> disponible){
        Connection con;
        PreparedStatement stmEmpleado=null;
        String query;
        
        int nzonas=disponible.size();
        int i;

        con=super.getConexion();

        
        
        try {
        stmEmpleado=con.prepareStatement("insert into Servicios(descripcion,nombre) "+
                                    "values(?,?) ");
        stmEmpleado.setString(1, s.getDescripcion());
        stmEmpleado.setString(2, s.getNombre());
        stmEmpleado.executeUpdate();


        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmEmpleado.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        for(i=0;i<nzonas;i++){
            try{
                stmEmpleado=con.prepareStatement("insert into zonas_servicios(zona,servicio) "+
                                        "values(?,?) ");
                stmEmpleado.setString(1, disponible.get(i).getNombre());
                stmEmpleado.setString(2, s.getNombre());
            }catch (SQLException e){
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }finally{
                 try {stmEmpleado.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
            }
        }
    }
    
    
   
}
