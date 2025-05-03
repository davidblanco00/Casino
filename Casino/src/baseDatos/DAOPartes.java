/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Parte;
import aplicacion.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author basesdatos
 */
public class DAOPartes extends AbstractDAO{
   
    public DAOPartes (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public ArrayList<Parte> buscarPartes(int id, String nombre){
        ArrayList<Parte> resultado=null;
        Connection con;
        String query;
        PreparedStatement stmParte=null;
        ResultSet rsParte;

        con=this.getConexion();
        
        query = "select id, nombre, modelo, productora, estado "+
                "from partes "+
                "where id="+id+" and nombre='"+nombre+"' ";

        try {
        stmParte=con.prepareStatement(query);
        
        rsParte=stmParte.executeQuery();
        if (rsParte.next())
        {
            resultado.add( new Parte(rsParte.getInt("id"), 
                                     rsParte.getString("nombre"),
                                     rsParte.getString("modelo"),
                                     rsParte.getString("productora"),
                                     rsParte.getString("estado")));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmParte.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    public void editarPartes(int id, String nombre, String modelo, String productora, String estado){
        Connection con;
        String query;
        PreparedStatement stmParte=null;

        con=this.getConexion();
        
        query = "update partes "+
                "set id="+id+", nombre='"+nombre+"', modelo='"+modelo+"', productora='"+productora+"', estado='"+estado+"' "+
                "where id="+id+" and nombre='"+nombre+"' ";

        try {
        stmParte=con.prepareStatement(query);  
        stmParte.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmParte.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public void anhadirPartes(int id, String nombre, String modelo, String productora, String estado){
        Connection con;
        String query;
        PreparedStatement stmParte=null;

        con=this.getConexion();
        
        query = "insert into partes "+
                "values (id="+id+", nombre='"+nombre+"', modelo='"+modelo+"', productora='"+productora+"', estado='"+estado+"') ";

        try {
        stmParte=con.prepareStatement(query);  
        stmParte.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmParte.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public void borrarPartes(int id, String nombre){
        Connection con;
        String query;
        PreparedStatement stmParte=null;

        con=this.getConexion();
        
        query = "delete from partes "+
                "where id="+id+" and nombre='"+nombre+"' ";

        try {
        stmParte=con.prepareStatement(query);  
        stmParte.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmParte.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

}
