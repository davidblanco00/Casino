/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Apuesta;
import aplicacion.Competitivo;
import aplicacion.Empleado;
import aplicacion.Ficha;
import aplicacion.FichasDeUsuario;
import aplicacion.Juego;
import aplicacion.Maquina;
import aplicacion.Mecanico;
import aplicacion.Parte;
import aplicacion.TipoJuego;
import aplicacion.Usuario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author basesdatos
 */
public class FachadaBaseDatos {
    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOUsuarios daoUsuarios;
    private DAOEmpleados daoEmpleados;
    private DAOFichas daoFichas;
    private DAOJuegos daoJuegos;
    private DAOApuestas daoApuestas;
    private DAOMaquinas daoMaquinas;
    private DAOPartes daoPartes;

    public FachadaBaseDatos (aplicacion.FachadaAplicacion fa){
        
        Properties configuracion = new Properties();
        this.fa=fa;
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();
     

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            
            System.out.println("jdbc:"+gestor+"://"+
                    configuracion.getProperty("servidor")+":"+
                    configuracion.getProperty("puerto")+"/"+
                    configuracion.getProperty("baseDatos"));
            
            System.out.println(usuario);
            
            this.conexion=java.sql.DriverManager.getConnection("jdbc:"+gestor+"://"+
                    configuracion.getProperty("servidor")+":"+
                    configuracion.getProperty("puerto")+"/"+
                    configuracion.getProperty("baseDatos"),
                    usuario);
            
            this.daoUsuarios = new DAOUsuarios(conexion, fa);
            this.daoEmpleados = new DAOEmpleados(conexion, fa);
            this.daoFichas = new DAOFichas(conexion, fa);
            this.daoJuegos = new DAOJuegos(conexion, fa);
            this.daoApuestas = new DAOApuestas(conexion, fa);
            this.daoMaquinas = new DAOMaquinas(conexion, fa);
            this.daoPartes = new DAOPartes(conexion, fa);

        } catch (FileNotFoundException f){
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException i){
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        } 
        catch (java.sql.SQLException e){
            System.out.println(e.getMessage());
            fa.muestraExcepcion(e.getMessage());
            System.out.println("ERROR");
            System.out.flush();
        }
        
    }

    public Usuario validarUsuario(String nickname, String contrasenha){
        return daoUsuarios.validarUsuario(nickname, contrasenha);
    }
    
    public void editarUsuario(String dni, String nickname, Float saldo, String contrasenha){
        daoUsuarios.editarUsuario(dni, nickname, saldo, contrasenha);
    }
    
    public Empleado validarAdministrador(String nombre, String contrasenha){
        return daoEmpleados.validarAdministrador(nombre, contrasenha);
    }
    
    public ArrayList<Ficha> buscarFichas(String color){
        return daoFichas.buscarFichas(color);
    }
    
    public void editarFichas(String color, float precio, int total_sin_reservar){
        daoFichas.editarFichas(color, precio, total_sin_reservar);
    }
    
    public void anhadirFichas(String color, float precio, int total_sin_reservar){
        daoFichas.editarFichas(color, precio, total_sin_reservar);
    }
    
    public void borrarFichas(String color){
        daoFichas.borrarFichas(color);
    }
    
    public ArrayList<FichasDeUsuario> buscarFichasDeUsuario(String dni){
        return daoFichas.buscarFichasDeUsuario(dni);
    }
    
    public FichasDeUsuario buscarMasaDeFichas(String dni, String color){
        return daoFichas.buscarMasaDeFichas(dni, color);
    }
    
    public void editarFichasDeUsuario(String dni, String color, int cantidad){
        daoFichas.editarFichasDeUsuario(dni, color, cantidad);
    }
    
    public void anhadirFichasDeUsuario(String dni, String color, int cantidad){
        daoFichas.anhadirFichasDeUsuario(dni, color, cantidad);
    }
    
    public void borrarFichasDeUsuario(String dni, String color){
        daoFichas.borrarFichasDeUsuario(dni, color);
    }
    
    public ArrayList<Apuesta> buscarApuestas(int id){
        return daoApuestas.buscarApuestas(id);
    }
    
    public void editarApuestas(int id, float dinero, boolean resultado){
        daoApuestas.editarApuestas(id, dinero, resultado);
    }
    
    public void anhadirApuestas(int id, float dinero, boolean resultado){
        daoApuestas.anhadirApuestas(id, dinero, resultado);
    }
    
    public void borrarApuestas(int id){
        daoApuestas.borrarApuestas(id);
    }
    
    public ArrayList<Maquina> buscarMaquinas(int id){
        return daoMaquinas.buscarMaquinas(id);
    }
    
    public void editarMaquinas(int id, String nombre, int anho_compra){
        daoMaquinas.editarMaquinas(id, nombre, anho_compra);
    }
    
    public void anhadirMaquinas(int id, String nombre, int anho_compra){
        daoMaquinas.anhadirMaquinas(id, nombre, anho_compra);
    }
    
    public void borrarMaquinas(int id){
        daoMaquinas.borrarMaquinas(id);
    }
    
    public ArrayList<Parte> buscarPartes(int id, String nombre){
        return daoPartes.buscarPartes(id, nombre);
    }
    
    public void editarPartes(int id, String nombre, String modelo, String productora, String estado){
        daoPartes.editarPartes(id, nombre, modelo, productora, estado);
    }
    
    public void anhadirPartes(int id, String nombre, String modelo, String productora, String estado){
        daoPartes.anhadirPartes(id, nombre, modelo, productora, estado);
    }
    
    public void borrarPartes(int id, String nombre){
        daoPartes.borrarPartes(id, nombre);
    }
    
    public ArrayList<Competitivo> buscarCompetitivos(int id){
        return daoJuegos.buscarCompetitivos(id);
    }
    
    public void editarCompetitivos(int id, String nombre, java.util.Date fecha_inicio, java.util.Date fecha_final, String tipo, int num_jugadores){
        daoJuegos.editarCompetitivos(id, nombre, fecha_inicio, fecha_final, tipo, num_jugadores);
    }
   
   public void anhadirCompetitivos(int id, String nombre, java.util.Date fecha_inicio, java.util.Date fecha_final, String tipo, int num_jugadores){
        daoJuegos.anhadirCompetitivos(id, nombre, fecha_inicio, fecha_final, tipo, num_jugadores);
    }
   
   public void borrarCompetitivos(int id){
        daoJuegos.borrarCompetitivos(id);
    }
   
   public ArrayList<Mecanico> buscarMecanicos(int id){
        return daoJuegos.buscarMecanicos(id);
    }
    
    public void editarMecanicos(int id, String nombre, java.util.Date fecha_inicio, java.util.Date fecha_final, String tipo, int id_maquina){
        daoJuegos.editarMecanicos(id, nombre, fecha_inicio, fecha_final, tipo, id_maquina);
    }
   
   public void anhadirMecanicos(int id, String nombre, java.util.Date fecha_inicio, java.util.Date fecha_final, String tipo, int id_maquina){
        daoJuegos.anhadirMecanicos(id, nombre, fecha_inicio, fecha_final, tipo, id_maquina);
    }
   
   public void borrarMecanicos(int id){
       daoJuegos.borrarMecanicos(id);
    }
   
   public ArrayList<Juego> totalJuegos(){
       return daoJuegos.totalJuegos();
   }
   
   public ArrayList<TipoJuego> buscarTiposJuego(String tipo){
        return daoJuegos.buscarTiposJuego(tipo);
    }
    
    public void editarTiposJuego(String tipo, String reglas_basicas){
        daoJuegos.editarTiposJuego(tipo, reglas_basicas);
    }
   
   public void anhadirTiposJuego(String tipo, String reglas_basicas){
        daoJuegos.anhadirTiposJuego(tipo, reglas_basicas);
    }
   
   public void borrarTiposJuego(String tipo){
        daoJuegos.borrarTiposJuego(tipo);
    }

}
