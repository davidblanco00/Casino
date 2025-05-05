/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import aplicacion.Zonas;
import aplicacion.Bar;
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
public class DAOZonas extends AbstractDAO {
    
    public DAOZonas (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public List<Zonas> buscarZonas(){
        List<Zonas> resultado=new ArrayList<Zonas>();
        Connection con;
        String query;
        PreparedStatement stmZonas=null;
        ResultSet rsZonas;

        con=this.getConexion();
        
        query = "select Zonas.nombre "+
                "from  Zonas "+
                "where not Zonas.nombre in ( "
                + "select Bar.nombre_zona "
                + "from Bar "
                + ") ";

        try {
        stmZonas=con.prepareStatement(query);
        
        rsZonas=stmZonas.executeQuery();
        while (rsZonas.next())
        {
            resultado.add(new Zonas(rsZonas.getString("Zonas.nombre")));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmZonas.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        query = "select Bar.nombre_zona "+
                "from  Bar ";

        try {
        stmZonas=con.prepareStatement(query);
        
        rsZonas=stmZonas.executeQuery();
        while (rsZonas.next())
        {
            resultado.add(new Bar(rsZonas.getString("Bar.nombre_zona")));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmZonas.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    public Integer calcularEmpleadosZona(Zonas z){
        Integer resultado=0;
        Connection con;
        String query;
        PreparedStatement stmZonas=null;
        ResultSet rsZonas;
        con=this.getConexion();
        
        query = "select count(*) "+
                "from  zonas_empleados "+
                "where zona= ? ";

        try {
        stmZonas=con.prepareStatement(query);
        stmZonas.setString(1, z.getNombre());
        rsZonas=stmZonas.executeQuery();
        if (rsZonas.next())
        {
            resultado=rsZonas.getInt(1);

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmZonas.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
}
