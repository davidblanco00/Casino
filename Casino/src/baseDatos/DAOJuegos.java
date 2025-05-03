/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Competitivo;
import aplicacion.Juego;
import aplicacion.Mecanico;
import aplicacion.TipoJuego;
import aplicacion.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author basesdatos
 */
public class DAOJuegos extends AbstractDAO{
   
    public DAOJuegos (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public ArrayList<Competitivo> buscarCompetitivos(int id){
        ArrayList<Competitivo> resultado=null;
        Connection con;
        String query;
        PreparedStatement stmCompetitivo=null;
        ResultSet rsCompetitivo;

        con=this.getConexion();
        
        query = "select id, nombre, fecha_inicio, fecha_final, tipo, num_jugadores "+
                "from competitivos "+
                "where id="+id+" ";

        try {
        stmCompetitivo=con.prepareStatement(query);
        
        rsCompetitivo=stmCompetitivo.executeQuery();
        if (rsCompetitivo.next())
        {
            resultado.add( new Competitivo(rsCompetitivo.getInt("id"), 
                                           rsCompetitivo.getString("nombre"),
                                           rsCompetitivo.getDate("fecha_inicio"),
                                           rsCompetitivo.getDate("fecha_final"),
                                           rsCompetitivo.getString("tipo"),
                                           rsCompetitivo.getInt("num_jugadores")));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCompetitivo.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    public void editarCompetitivos(int id, String nombre, Date fecha_inicio, Date fecha_final, String tipo, int num_jugadores){
        Connection con;
        String query;
        PreparedStatement stmCompetitivo=null;

        con=this.getConexion();
        
        query = "update competitivos "+
                "set id="+id+", nombre='"+nombre+"', fecha_inicio='"+fecha_inicio+"', fecha_final='"+fecha_final+"', tipo='"+tipo+"', num_jugadores="+num_jugadores+" "+
                "where id="+id+" ";

        try {
        stmCompetitivo=con.prepareStatement(query);  
        stmCompetitivo.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCompetitivo.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public void anhadirCompetitivos(int id, String nombre, Date fecha_inicio, Date fecha_final, String tipo, int num_jugadores){
        Connection con;
        String query;
        PreparedStatement stmCompetitivo=null;

        con=this.getConexion();
        
        query = "insert into competitivos "+
                "values (id="+id+", nombre='"+nombre+"', fecha_inicio='"+fecha_inicio+"', fecha_final='"+fecha_final+"', tipo='"+tipo+"', num_jugadores="+num_jugadores+") ";

        try {
        stmCompetitivo=con.prepareStatement(query);  
        stmCompetitivo.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCompetitivo.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public void borrarCompetitivos(int id){
        Connection con;
        String query;
        PreparedStatement stmCompetitivo=null;

        con=this.getConexion();
        
        query = "delete from competitivos "+
                "where id="+id+" ";

        try {
        stmCompetitivo=con.prepareStatement(query);  
        stmCompetitivo.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCompetitivo.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public ArrayList<Mecanico> buscarMecanicos(int id){
        ArrayList<Mecanico> resultado=null;
        Connection con;
        String query;
        PreparedStatement stmMecanico=null;
        ResultSet rsMecanico;

        con=this.getConexion();
        
        query = "select id, nombre, fecha_inicio, fecha_final, tipo, id_maquina "+
                "from mecanicos "+
                "where id="+id+" ";

        try {
        stmMecanico=con.prepareStatement(query);
        
        rsMecanico=stmMecanico.executeQuery();
        if (rsMecanico.next())
        {
            resultado.add(new Mecanico(rsMecanico.getInt("id"), 
                                       rsMecanico.getString("nombre"),
                                       rsMecanico.getDate("fecha_inicio"),
                                       rsMecanico.getDate("fecha_final"),
                                       rsMecanico.getString("tipo"),
                                       rsMecanico.getInt("id_maquina")));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmMecanico.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    public void editarMecanicos(int id, String nombre, Date fecha_inicio, Date fecha_final, String tipo, int id_maquina){
        Connection con;
        String query;
        PreparedStatement stmMecanico=null;

        con=this.getConexion();
        
        query = "update mecanicos "+
                "set id="+id+", nombre='"+nombre+"', fecha_inicio='"+fecha_inicio+"', fecha_final='"+fecha_final+"', tipo='"+tipo+"', id_maquina="+id_maquina+" "+
                "where id="+id+" ";

        try {
        stmMecanico=con.prepareStatement(query);  
        stmMecanico.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmMecanico.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public void anhadirMecanicos(int id, String nombre, Date fecha_inicio, Date fecha_final, String tipo, int id_maquina){
        Connection con;
        String query;
        PreparedStatement stmMecanico=null;

        con=this.getConexion();
        
        query = "insert into mecanicos "+
                "values (id="+id+", nombre='"+nombre+"', fecha_inicio='"+fecha_inicio+"', fecha_final='"+fecha_final+"', tipo='"+tipo+"', id_maquina="+id_maquina+") ";

        try {
        stmMecanico=con.prepareStatement(query);  
        stmMecanico.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmMecanico.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public void borrarMecanicos(int id){
        Connection con;
        String query;
        PreparedStatement stmMecanico=null;

        con=this.getConexion();
        
        query = "delete from mecanicos "+
                "where id="+id+" ";

        try {
        stmMecanico=con.prepareStatement(query);  
        stmMecanico.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmMecanico.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public ArrayList<Juego> totalJuegos(){
       ArrayList<Juego> resultado=null;
        Connection con;
        String query;
        PreparedStatement stmJuego=null;
        ResultSet rsJuego;

        con=this.getConexion();
        
        query = "select * "+
                "from (select id, nombre, fecha_inicio, fecha_final, tipo, num_jugadores, 'COMPETITIVO' as clasificacion "+
                "from competitivos "+
                "union "+
                "select id, nombre, fecha_inicio, fecha_final, tipo, 0 as num_jugadores, 'MECANICO' as clasificacion "+
                "from mecanicos) as datos "+
                "order by datos.nombre asc ";

        try {
        stmJuego=con.prepareStatement(query);
        
        rsJuego=stmJuego.executeQuery();
        if (rsJuego.next())
        {
            if (rsJuego.getString("clasificacion").equals("COMPETITIVO")){
                resultado.add( new Competitivo(rsJuego.getInt("id"), 
                                               rsJuego.getString("nombre"),
                                               rsJuego.getDate("fecha_inicio"),
                                               rsJuego.getDate("fecha_final"),
                                               rsJuego.getString("tipo"),
                                               rsJuego.getInt("num_jugadores")));
            }else{
                resultado.add( new Mecanico(rsJuego.getInt("id"), 
                                            rsJuego.getString("nombre"),
                                            rsJuego.getDate("fecha_inicio"),
                                            rsJuego.getDate("fecha_final"),
                                            rsJuego.getString("tipo"),
                                            0));
            }

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmJuego.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
       
   }
   
   
   public ArrayList<TipoJuego> buscarTiposJuego(String tipo){
        ArrayList<TipoJuego> resultado=null;
        Connection con;
        String query;
        PreparedStatement stmTipoJuego=null;
        ResultSet rsTipoJuego;

        con=this.getConexion();
        
        query = "select tipo, reglas_basicas "+
                "from Tipo_juego "+
                "where tipo='"+tipo+"' ";

        try {
        stmTipoJuego=con.prepareStatement(query);
        
        rsTipoJuego=stmTipoJuego.executeQuery();
        if (rsTipoJuego.next())
        {
            resultado.add( new TipoJuego(rsTipoJuego.getString("tipo"), 
                                           rsTipoJuego.getString("reglas_basicas")));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmTipoJuego.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    public void editarTiposJuego(String tipo, String reglas_basicas){
        Connection con;
        String query;
        PreparedStatement stmTipoJuego=null;

        con=this.getConexion();
        
        query = "update Tipo_juego "+
                "set tipo='"+tipo+"', reglas_basicas='"+reglas_basicas+"' "+
                "where tipo='"+tipo+"' ";

        try {
        stmTipoJuego=con.prepareStatement(query);  
        stmTipoJuego.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmTipoJuego.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public void anhadirTiposJuego(String tipo, String reglas_basicas){
        Connection con;
        String query;
        PreparedStatement stmTipoJuego=null;

        con=this.getConexion();
        
        query = "insert into Tipo_juego "+
                "values (tipo='"+tipo+"', reglas_basicas='"+reglas_basicas+"') ";

        try {
        stmTipoJuego=con.prepareStatement(query);  
        stmTipoJuego.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmTipoJuego.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
   public void borrarTiposJuego(String tipo){
        Connection con;
        String query;
        PreparedStatement stmTipoJuego=null;

        con=this.getConexion();
        
        query = "delete from Tipo_juego "+
                "where tipo='"+tipo+"' ";

        try {
        stmTipoJuego=con.prepareStatement(query);  
        stmTipoJuego.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmTipoJuego.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

}
