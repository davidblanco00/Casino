/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Ficha;
import aplicacion.FichasDeUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author basesdatos
 */
public class DAOFichas extends AbstractDAO{
   
    public DAOFichas (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public ArrayList<Ficha> buscarFichas(String color){
        ArrayList<Ficha> resultado=null;
        Connection con;
        String query;
        PreparedStatement stmFicha=null;
        ResultSet rsFicha;

        con=this.getConexion();
        
        query = "select color, precio, tener_sin_reservar "+
                "from fichas "+
                "where color like '"+color+"' ";

        try {
        stmFicha=con.prepareStatement(query);
        
        rsFicha=stmFicha.executeQuery();
        if (rsFicha.next())
        {
            resultado.add( new Ficha(rsFicha.getString("color"), 
                                    rsFicha.getFloat("precio"),
                                    rsFicha.getInt("tener_sin_reservar")));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmFicha.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    public void editarFichas(String color, float precio, int total_sin_reservar){
        Connection con;
        String query;
        PreparedStatement stmFicha=null;

        con=this.getConexion();
        
        query = "update fichas "+
                "set color='"+color+"', precio="+precio+", total_sin_reservar="+total_sin_reservar+" "+
                "where color='"+color+"' ";

        try {
        stmFicha=con.prepareStatement(query);  
        stmFicha.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmFicha.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public void anhadirFichas(String color, float precio, int total_sin_reservar){
        Connection con;
        String query;
        PreparedStatement stmFicha=null;

        con=this.getConexion();
        
        query = "insert into fichas "+
                "values (color='"+color+"', precio="+precio+", total_sin_reservar="+total_sin_reservar+") ";

        try {
        stmFicha=con.prepareStatement(query);  
        stmFicha.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmFicha.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public void borrarFichas(String color){
        Connection con;
        String query;
        PreparedStatement stmFicha=null;

        con=this.getConexion();
        
        query = "delete from fichas "+
                "where color='"+color+"' ";

        try {
        stmFicha=con.prepareStatement(query);  
        stmFicha.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmFicha.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public ArrayList<FichasDeUsuario> buscarFichasDeUsuario(String dni){
        ArrayList<FichasDeUsuario> resultado=null;
        Connection con;
        String query;
        PreparedStatement stmFichaDeUsuario=null;
        ResultSet rsFichaDeUsuario;

        con=this.getConexion();
        
        query = "select dni, color_ficha, cantidad "+
                "from tener_fichas "+
                "where dni = '"+dni+"' ";

        try {
        stmFichaDeUsuario=con.prepareStatement(query);
        
        rsFichaDeUsuario=stmFichaDeUsuario.executeQuery();
        if (rsFichaDeUsuario.next())
        {
            resultado.add(new FichasDeUsuario(rsFichaDeUsuario.getString("dni"), 
                                    rsFichaDeUsuario.getString("color_ficha"),
                                    rsFichaDeUsuario.getInt("cantidad")));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmFichaDeUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    public FichasDeUsuario buscarMasaDeFichas(String dni, String color){
        FichasDeUsuario resultado=null;
        Connection con;
        String query;
        PreparedStatement stmFichaDeUsuario=null;
        ResultSet rsFichaDeUsuario;

        con=this.getConexion();
        
        query = "select dni, color_ficha, cantidad "+
                "from tener_fichas "+
                "where dni = '"+dni+"' and color = '"+color+"' ";

        try {
        stmFichaDeUsuario=con.prepareStatement(query);
        
        rsFichaDeUsuario=stmFichaDeUsuario.executeQuery();
        if (rsFichaDeUsuario.next())
        {
            resultado = new FichasDeUsuario(rsFichaDeUsuario.getString("dni"), 
                                    rsFichaDeUsuario.getString("color_ficha"),
                                    rsFichaDeUsuario.getInt("cantidad"));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmFichaDeUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    public void editarFichasDeUsuario(String dni, String color, int cantidad){
        Connection con;
        String query;
        PreparedStatement stmFichaDeUsuario=null;

        con=this.getConexion();
        
        query = "update tener_fichas "+
                "set dni='"+dni+"', color='"+color+"', cantidad="+cantidad+" "+
                "where dni='"+dni+"' and color='"+color+"' ";

        try {
        stmFichaDeUsuario=con.prepareStatement(query);  
        stmFichaDeUsuario.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmFichaDeUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public void anhadirFichasDeUsuario(String dni, String color, int cantidad){
        Connection con;
        String query;
        PreparedStatement stmFichaDeUsuario=null;

        con=this.getConexion();
        
        query = "insert into fichas "+
                "values (dni='"+dni+"', color="+color+", cantidad="+cantidad+") ";

        try {
        stmFichaDeUsuario=con.prepareStatement(query);  
        stmFichaDeUsuario.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmFichaDeUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public void borrarFichasDeUsuario(String dni, String color){
        Connection con;
        String query;
        PreparedStatement stmFichaDeUsuario=null;

        con=this.getConexion();
        
        query = "delete from fichas "+
                "where dni='"+dni+"' and color='"+color+"' ";

        try {
        stmFichaDeUsuario=con.prepareStatement(query);  
        stmFichaDeUsuario.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmFichaDeUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    
}
