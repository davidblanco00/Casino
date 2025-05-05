
package baseDatos;


import aplicacion.Decoracion;
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
public class DAODecoraciones extends AbstractDAO {
    
    public DAODecoraciones (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public List<Decoracion> buscarDecoraciones(String id,String tipo,String modelo,String ordenarPor){
        List<Decoracion> resultado=new ArrayList<Decoracion>();
        Decoracion decoracionActual;
        Connection con;
        PreparedStatement stmDecoraciones=null;
        ResultSet rsDecoraciones;

        con=this.getConexion();
        
        String consulta = "select id,tipo,modelo,estado,nombre_zona " +
                                         "from Decoracion "+
                                         "where tipo like ? "
                                         + "and modelo like ? ";
        if(!id.equals("")){
            consulta=consulta+"and id=? ";
        }
        if(ordenarPor.equals("Orden alfabético del modelo (ascendente)")){
            consulta=consulta+"order by modelo asc ";
        }
        if(ordenarPor.equals("Orden alfabético del modelo (descendente)")){
            consulta=consulta+"order by modelo desc ";
        }
        if(ordenarPor.equals("Id (ascendente)")){
            consulta=consulta+"order by id asc ";
        }
        if(ordenarPor.equals("Id (descendente)")){
            consulta=consulta+"order by id desc ";
        }
        try  {
         stmDecoraciones=con.prepareStatement(consulta);
         stmDecoraciones.setString(1, "%"+tipo+"%");
         stmDecoraciones.setString(2, "%"+modelo+"%");
         if(!id.equals("")){
             stmDecoraciones.setInt(3, Integer.valueOf(id));
         }
         rsDecoraciones=stmDecoraciones.executeQuery();
        while (rsDecoraciones.next())
        {
            decoracionActual=new Decoracion(rsDecoraciones.getInt(1),rsDecoraciones.getString(2),rsDecoraciones.getString(3),rsDecoraciones.getString(4), rsDecoraciones.getString(5));
            resultado.add(decoracionActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmDecoraciones.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public void borrarDecoracion(Decoracion d){
        Connection con;
        PreparedStatement stmDecoracion=null;

        con=super.getConexion();

        try {
        stmDecoracion=con.prepareStatement("delete from Decoracion where id = ?");
        stmDecoracion.setInt(1, d.getId());
        stmDecoracion.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmDecoracion.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public void modificarDecoracion(Decoracion d, String zona){
        Connection con;
        PreparedStatement stmDecoracion=null;
        String query;
        

        con=super.getConexion();
        
        try {
        stmDecoracion=con.prepareStatement("update Decoracion "+
                                    "set tipo=?, "
                                    + "modelo=?, "
                                    + "estado=? "
                                    + "nombre_zona=? "+
                                    "where id=?");
        stmDecoracion.setString(1, d.getTipo());
        stmDecoracion.setString(2, d.getModelo());
        stmDecoracion.setString(3, d.getEstado());
        stmDecoracion.setString(4, zona);
        stmDecoracion.setInt(5, d.getId());
        stmDecoracion.executeUpdate();


        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmDecoracion.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public void anhadirDecoracion(Decoracion d, String zona){
        Connection con;
        PreparedStatement stmDecoracion=null;
        String query;
        

        con=super.getConexion();
        
        try {
        stmDecoracion=con.prepareStatement("insert into Decoracion(tipo,modelo,estado,nombre_zona) "+
                                    "values(?,?,?,?) ");
        stmDecoracion.setString(1, d.getTipo());
        stmDecoracion.setString(2, d.getModelo());
        stmDecoracion.setString(3, d.getEstado());
        stmDecoracion.setString(4, zona);
        stmDecoracion.executeUpdate();


        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmDecoracion.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
}
