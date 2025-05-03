/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

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
public class DAOUsuarios extends AbstractDAO{
   
    public DAOUsuarios (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Usuario validarUsuario(String nickname, String contrasenha){
        Usuario resultado=null;
        Connection con;
        String query;
        PreparedStatement stmUsuario=null;
        ResultSet rsUsuario;

        con=this.getConexion();
        
        query = "select dni, nickname, saldo, contrasenha "+
                "from usuarios "+
                "where nickname = '"+nickname+"' and contrasenha = '"+contrasenha+"' ";

        try {
        stmUsuario=con.prepareStatement(query);
        
        rsUsuario=stmUsuario.executeQuery();
        if (rsUsuario.next())
        {
            resultado = new Usuario(rsUsuario.getString("dni"), 
                                    rsUsuario.getString("nickname"),
                                    rsUsuario.getFloat("saldo"),
                                    rsUsuario.getString("contrasenha"));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    public ArrayList<Usuario> buscarUsuarios(String dni, String nickname){
        ArrayList<Usuario> resultado=null;
        Connection con;
        String query;
        PreparedStatement stmUsuario=null;
        ResultSet rsUsuario;

        con=this.getConexion();
        
        query = "select dni, nickname, saldo, contrasenha "+
                "from usuarios "+
                "where nickname like '"+dni+"' and contrasenha like '"+nickname+"' ";

        try {
        stmUsuario=con.prepareStatement(query);
        
        rsUsuario=stmUsuario.executeQuery();
        if (rsUsuario.next())
        {
            resultado.add( new Usuario(rsUsuario.getString("dni"), 
                                    rsUsuario.getString("nickname"),
                                    rsUsuario.getFloat("saldo"),
                                    rsUsuario.getString("contrasenha")));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
   
   public void editarUsuario(String dni, String nickname, Float saldo, String contrasenha){
        Connection con;
        String query;
        PreparedStatement stmUsuario=null;

        con=this.getConexion();
        
        query = "update usuarios "+
                "set dni='"+dni+"', nickname='"+nickname+"', saldo="+saldo+", contrasenha='"+contrasenha+"' "+
                "where nickname='"+nickname+"' ";

        try {
        stmUsuario=con.prepareStatement(query);  
        stmUsuario.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public void anhadirUsuario(String dni, String nickname, Float saldo, String contrasenha){
        Connection con;
        String query;
        PreparedStatement stmUsuario=null;

        con=this.getConexion();
        
        query = "insert into usuarios "+
                "values (dni='"+dni+"', nickname='"+nickname+"', saldo="+saldo+", contrasenha='"+contrasenha+"') ";

        try {
        stmUsuario=con.prepareStatement(query);  
        stmUsuario.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public void borrarUsuario(String dni){
        Connection con;
        String query;
        PreparedStatement stmUsuario=null;

        con=this.getConexion();
        
        query = "delete from usuarios "+
                "where dni='"+dni+"' ";

        try {
        stmUsuario=con.prepareStatement(query);  
        stmUsuario.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
}
