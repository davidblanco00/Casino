

package baseDatos;

import aplicacion.Empleado;
import aplicacion.Zonas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
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
                "from empleados "+
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
   
    public List<Empleado> buscarEmpleados(String dni,String nombre,String rol,String ordenarPor){
        List<Empleado> resultado=new ArrayList<Empleado>();
        Empleado empleadoActual;
        Connection con;
        PreparedStatement stmEmpleados=null;
        ResultSet rsEmpleados;

        con=this.getConexion();
        
        String consulta = "select dni,nombre,rol,contrasenha " +
                                         "from Empleados "+
                                         "where nombre like ? "
                                         + "and dni like ? "
                                         + "and rol like ? ";
        
        if(ordenarPor.equals("Orden alfabético (ascendente)")){
            consulta=consulta+"order by nombre asc ";
        }
        if(ordenarPor.equals("Orden alfabético (descendente)")){
            consulta=consulta+"order by nombre desc ";
        }
        try  {
         stmEmpleados=con.prepareStatement(consulta);
         stmEmpleados.setString(1, "%"+nombre+"%");
         stmEmpleados.setString(2, "%"+dni+"%");
         stmEmpleados.setString(3, "%"+rol+"%");
         rsEmpleados=stmEmpleados.executeQuery();
        while (rsEmpleados.next())
        {
            empleadoActual=new Empleado(rsEmpleados.getString(1),rsEmpleados.getString(2),rsEmpleados.getString(3),rsEmpleados.getString(4));
            resultado.add(empleadoActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmEmpleados.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public void borrarEmpleado(Empleado em){
        Connection con;
        PreparedStatement stmEmpleado=null;

        con=super.getConexion();

        try {
        stmEmpleado=con.prepareStatement("delete from Empleados where dni = ?");
        stmEmpleado.setString(1, em.getDni());
        stmEmpleado.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmEmpleado.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public List<Zonas> zonasTrabaja(Empleado em){
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
                + "from zonas_empleados "
                + "where empleado=? "
                + ") ";

        try {
        stmZonas=con.prepareStatement(query);
        stmZonas.setString(1, em.getDni());
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
    
    public List<Zonas> zonasNoTrabaja(Empleado em){
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
                + "from zonas_empleados "
                + "where empleado=? "
                + ") ";

        try {
        stmZonas=con.prepareStatement(query);
        stmZonas.setString(1, em.getDni());
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
    
    public void modificarEmpleado(Empleado em,List<Zonas> trabaja){
        Connection con;
        PreparedStatement stmEmpleado=null;
        String query;
        
        int nbares=trabaja.size();
        int i;

        con=super.getConexion();

        try {
        stmEmpleado=con.prepareStatement("delete from zonas_empleados where empleado = ?");
        stmEmpleado.setString(1, em.getDni());
        stmEmpleado.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmEmpleado.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        try {
        stmEmpleado=con.prepareStatement("update Empleados "+
                                    "set nombre=?, "
                                    + "rol=?, "
                                    + "contrasenha=? "+
                                    "where dni=?");
        stmEmpleado.setString(1, em.getNombre());
        stmEmpleado.setString(2, em.getRol());
        stmEmpleado.setString(3, em.getContrasenha());
        stmEmpleado.setString(4, em.getDni());
        stmEmpleado.executeUpdate();


        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmEmpleado.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        for(i=0;i<nbares;i++){
            try{
                stmEmpleado=con.prepareStatement("insert into zonas_empleados(zona,empleado) "+
                                        "values(?,?) ");
                stmEmpleado.setString(1, trabaja.get(i).getNombre());
                stmEmpleado.setString(2, em.getDni());
            }catch (SQLException e){
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }finally{
                 try {stmEmpleado.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
            }
        }
        
        
    }
    
    public void anhadirEmpleado(Empleado em,List<Zonas> trabaja){
        Connection con;
        PreparedStatement stmEmpleado=null;
        String query;
        
        int nbares=trabaja.size();
        int i;

        con=super.getConexion();

        
        
        try {
        stmEmpleado=con.prepareStatement("insert into Empleados(dni,nombre,rol,contrasenha) "+
                                    "values(?,?,?,?) ");
        stmEmpleado.setString(1, em.getDni());
        stmEmpleado.setString(2, em.getNombre());
        stmEmpleado.setString(3, em.getRol());
        stmEmpleado.setString(4, em.getContrasenha());
        stmEmpleado.executeUpdate();


        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmEmpleado.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        for(i=0;i<nbares;i++){
            try{
                stmEmpleado=con.prepareStatement("insert into zonas_empleados(zona,empleado) "+
                                        "values(?,?) ");
                stmEmpleado.setString(1, trabaja.get(i).getNombre());
                stmEmpleado.setString(2, em.getDni());
            }catch (SQLException e){
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }finally{
                 try {stmEmpleado.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
            }
        }
        
        
    }
   
}
