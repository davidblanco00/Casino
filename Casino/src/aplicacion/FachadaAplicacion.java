/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;

import gui.VPrincipalU;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author basesdatos
 */

/*
*Modelo vista controlador
*Nota: Aceder a la ventana de 'design' y poner nombre a los botones
*/

public class FachadaAplicacion {
    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GestionUsuarios cu;
    GestionEmpleados ce;
    GestionFichas cf;
    GestionJuegos cj;
    GestionApuestas ca;
    GestionMaquinas cm;
    
 public FachadaAplicacion(){
   fgui=new gui.FachadaGui(this);
   fbd= new baseDatos.FachadaBaseDatos(this);
   cu =new GestionUsuarios(fgui, fbd);
   ce =new GestionEmpleados(fgui, fbd);
   cf =new GestionFichas(fgui, fbd);
   cj=new GestionJuegos(fgui, fbd);
   ca=new GestionApuestas(fgui, fbd);
   cm=new GestionMaquinas(fgui, fbd);
 }

 public static void main(String args[]) {
     FachadaAplicacion fa;
     
     fa= new FachadaAplicacion();
     fa.iniciaInterfazUsuario();
 }
 
 public void iniciaInterfazUsuario(){
     fgui.iniciaVista();
 }
 
 public void iniciaFachadaUsuario(Usuario usuario){
     fgui.iniciaFachadaUsuario(usuario);
 }

 public void muestraExcepcion(String e){
     fgui.muestraExcepcion(e);
 }
 
 public Usuario validarUsuario(String nickname, String contrasenha){
        return cu.validarUsuario(nickname, contrasenha);
 }
 
 public void editarUsuario(String dni, String nickname, Float saldo, String contrasenha){
    cu.editarUsuario(dni, nickname, saldo, contrasenha);
}
 
 public Empleado validarAdministrador(String nombre, String contrasenha){
        return ce.validarAdministrador(nombre, contrasenha);
 }
 
 public ArrayList<Ficha> buscarFichas(String color){
        return cf.buscarFichas(color);
 }
 
 public void editarFichas(String color, float precio, int total_sin_reservar){
    cf.editarFichas(color, precio, total_sin_reservar);
}
 
 public void anhadirFichas(String color, float precio, int total_sin_reservar){
    cf.editarFichas(color, precio, total_sin_reservar);
}
 
 public void borrarFichas(String color){
    cf.borrarFichas(color);
}
 
 public ArrayList<FichasDeUsuario> buscarFichasDeUsuario(String dni){
        return cf.buscarFichasDeUsuario(dni);
 }
 
 public FichasDeUsuario buscarMasaDeFichas(String dni, String color){
    return cf.buscarMasaDeFichas(dni, color);
}
 
 public void editarFichasDeUsuario(String dni, String color, int cantidad){
    cf.editarFichasDeUsuario(dni, color, cantidad);
 }
 
 public void anhadirFichasDeUsuario(String dni, String color, int cantidad){
    cf.anhadirFichasDeUsuario(dni, color, cantidad);
}
 
 public void borrarFichasDeUsuario(String dni, String color){
    cf.borrarFichasDeUsuario(dni, color);
}
 
 public ArrayList<Apuesta> buscarApuestas(int id){
    return ca.buscarApuestas(id);
}
 
 public void editarApuestas(int id, float dinero, boolean resultado){
    ca.editarApuestas(id, dinero, resultado);
}
 
 public void anhadirApuestas(int id, float dinero, boolean resultado){
    ca.anhadirApuestas(id, dinero, resultado);
}
 
 public void borrarApuestas(int id){
    ca.borrarApuestas(id);
}
 
 public ArrayList<Maquina> buscarMaquinas(int id){
    return cm.buscarMaquinas(id);
}
 
 public void editarMaquinas(int id, String nombre, int anho_compra){
    cm.editarMaquinas(id, nombre, anho_compra);
}
 
 public void anhadirMaquinas(int id, String nombre, int anho_compra){
    cm.anhadirMaquinas(id, nombre, anho_compra);
}
 
 public void borrarMaquinas(int id){
    cm.borrarMaquinas(id);
}
 
 public ArrayList<Parte> buscarPartes(int id, String nombre){
    return cm.buscarPartes(id, nombre);
}

public void editarPartes(int id, String nombre, String modelo, String productora, String estado){
    cm.editarPartes(id, nombre, modelo, productora, estado);
}

public void anhadirPartes(int id, String nombre, String modelo, String productora, String estado){
    cm.anhadirPartes(id, nombre, modelo, productora, estado);
}

public void borrarPartes(int id, String nombre){
    cm.borrarPartes(id, nombre);
}

public ArrayList<Competitivo> buscarCompetitivos(int id){
    return cj.buscarCompetitivos(id);
}

public void editarCompetitivos(int id, String nombre, java.util.Date fecha_inicio, java.util.Date fecha_final, String tipo, int num_jugadores){
    cj.editarCompetitivos(id, nombre, fecha_inicio, fecha_final, tipo, num_jugadores);
}

public void anhadirCompetitivos(int id, String nombre, java.util.Date fecha_inicio, java.util.Date fecha_final, String tipo, int num_jugadores){
    cj.anhadirCompetitivos(id, nombre, fecha_inicio, fecha_final, tipo, num_jugadores);
}

public void borrarCompetitivos(int id){
    cj.borrarCompetitivos(id);
}

public ArrayList<Mecanico> buscarMecanicos(int id){
    return cj.buscarMecanicos(id);
}

public void editarMecanicos(int id, String nombre, java.util.Date fecha_inicio, java.util.Date fecha_final, String tipo, int id_maquina){
    cj.editarMecanicos(id, nombre, fecha_inicio, fecha_final, tipo, id_maquina);
}

public void anhadirMecanicos(int id, String nombre, java.util.Date fecha_inicio, java.util.Date fecha_final, String tipo, int id_maquina){
    cj.anhadirMecanicos(id, nombre, fecha_inicio, fecha_final, tipo, id_maquina);
}

public void borrarMecanicos(int id){
   cj.borrarMecanicos(id);
}

public ArrayList<Juego> totalJuegos(){
   return cj.totalJuegos();
}

public ArrayList<TipoJuego> buscarTiposJuego(String tipo){
    return cj.buscarTiposJuego(tipo);
}

public void editarTiposJuego(String tipo, String reglas_basicas){
    cj.editarTiposJuego(tipo, reglas_basicas);
}

public void anhadirTiposJuego(String tipo, String reglas_basicas){
    cj.anhadirTiposJuego(tipo, reglas_basicas);
}

public void borrarTiposJuego(String tipo){
    cj.borrarTiposJuego(tipo);
}

}
