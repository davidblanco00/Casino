/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Maquina;
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
public class DAOMaquinas extends AbstractDAO{
   
    public DAOMaquinas (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public ArrayList<Maquina> buscarMaquinas(int id){
        ArrayList<Maquina> resultado=null;
        Connection con;
        String query;
        PreparedStatement stmMaquina=null;
        ResultSet rsMaquina;

        con=this.getConexion();
        
        query = "select id, nombre, anho_compra "+
                "from maquinas "+
                "where id="+id+" ";

        try {
        stmMaquina=con.prepareStatement(query);
        
        rsMaquina=stmMaquina.executeQuery();
        if (rsMaquina.next())
        {
            resultado.add( new Maquina(rsMaquina.getInt("id"), 
                                    rsMaquina.getString("nombre"),
                                    rsMaquina.getInt("anho_compra")));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmMaquina.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    public void editarMaquinas(int id, String nombre, int anho_compra){
        Connection con;
        String query;
        PreparedStatement stmMaquina=null;

        con=this.getConexion();
        
        query = "update maquinas "+
                "set id="+id+", nombre='"+nombre+"', anho_compra="+anho_compra+" "+
                "where id="+id+" ";

        try {
        stmMaquina=con.prepareStatement(query);  
        stmMaquina.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmMaquina.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public void anhadirMaquinas(int id, String nombre, int anho_compra){
        Connection con;
        String query;
        PreparedStatement stmMaquina=null;

        con=this.getConexion();
        
        query = "insert into maquinas "+
                "values (id="+id+", nombre='"+nombre+"', anho_compra="+anho_compra+") ";

        try {
        stmMaquina=con.prepareStatement(query);  
        stmMaquina.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmMaquina.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public void borrarMaquinas(int id){
        Connection con;
        String query;
        PreparedStatement stmMaquina=null;

        con=this.getConexion();
        
        query = "delete from maquinas "+
                "where id="+id+" ";

        try {
        stmMaquina=con.prepareStatement(query);  
        stmMaquina.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmMaquina.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
}
