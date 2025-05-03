/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author basesdatos
 */
public class DAOEmpleados extends AbstractDAO{
   
    public DAOEmpleados (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Empleado validarAdministrador(String nombre, String contrasenha){
        Empleado resultado=null;
        Connection con;
        String query;
        PreparedStatement stmUsuario=null;
        ResultSet rsUsuario;

        con=this.getConexion();
        
        query = "select dni, nombre, rol, contrasenha "+
                "from empleado "+
                "where nombre = '"+nombre+"' and contrasenha = '"+contrasenha+"' ";

        try {
        stmUsuario=con.prepareStatement(query);
        
        rsUsuario=stmUsuario.executeQuery();
        if (rsUsuario.next())
        {
            resultado = new Empleado(rsUsuario.getString("dni"), 
                                    rsUsuario.getString("nombre"),
                                    rsUsuario.getString("rol"),
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
   
   
}
