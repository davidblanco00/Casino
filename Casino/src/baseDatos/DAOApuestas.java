/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Apuesta;
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
public class DAOApuestas extends AbstractDAO{
   
    public DAOApuestas (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public ArrayList<Apuesta> buscarApuestas(int id){
        ArrayList<Apuesta> resultado=null;
        Connection con;
        String query;
        PreparedStatement stmApuesta=null;
        ResultSet rsApuesta;

        con=this.getConexion();
        
        query = "select id, dinero, resultado "+
                "from apuestas "+
                "where id="+id+" ";

        try {
        stmApuesta=con.prepareStatement(query);
        
        rsApuesta=stmApuesta.executeQuery();
        if (rsApuesta.next())
        {
            resultado.add( new Apuesta(rsApuesta.getInt("id"), 
                                    rsApuesta.getFloat("dinero"),
                                    rsApuesta.getBoolean("resultado")));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmApuesta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    public void editarApuestas(int id, float dinero, boolean resultado){
        Connection con;
        String query;
        PreparedStatement stmApuesta=null;

        con=this.getConexion();
        
        query = "update apuestas "+
                "set id="+id+", dinero="+dinero+", resultado="+resultado+" "+
                "where id="+id+" ";

        try {
        stmApuesta=con.prepareStatement(query);  
        stmApuesta.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmApuesta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public void anhadirApuestas(int id, float dinero, boolean resultado){
        Connection con;
        String query;
        PreparedStatement stmApuesta=null;

        con=this.getConexion();
        
        query = "insert into apuestas "+
                "values (id="+id+", precio="+dinero+", total_sin_reservar="+resultado+") ";

        try {
        stmApuesta=con.prepareStatement(query);  
        stmApuesta.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmApuesta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public void borrarApuestas(int id){
        Connection con;
        String query;
        PreparedStatement stmApuesta=null;

        con=this.getConexion();
        
        query = "delete from apuestas "+
                "where id="+id+" ";

        try {
        stmApuesta=con.prepareStatement(query);  
        stmApuesta.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmApuesta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

}
