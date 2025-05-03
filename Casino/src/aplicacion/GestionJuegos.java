/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;
import java.util.ArrayList;

/**
 *
 * @author alumnogreibd
 */
class GestionJuegos {
    FachadaGui fgui;
    FachadaBaseDatos fbd;


    public GestionJuegos(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    } 
    
    public ArrayList<Competitivo> buscarCompetitivos(int id){
        return fbd.buscarCompetitivos(id);
    }
    
    public void editarCompetitivos(int id, String nombre, java.util.Date fecha_inicio, java.util.Date fecha_final, String tipo, int num_jugadores){
        fbd.editarCompetitivos(id, nombre, fecha_inicio, fecha_final, tipo, num_jugadores);
    }
   
   public void anhadirCompetitivos(int id, String nombre, java.util.Date fecha_inicio, java.util.Date fecha_final, String tipo, int num_jugadores){
        fbd.anhadirCompetitivos(id, nombre, fecha_inicio, fecha_final, tipo, num_jugadores);
    }
   
   public void borrarCompetitivos(int id){
        fbd.borrarCompetitivos(id);
    }
   
   public ArrayList<Mecanico> buscarMecanicos(int id){
        return fbd.buscarMecanicos(id);
    }
    
    public void editarMecanicos(int id, String nombre, java.util.Date fecha_inicio, java.util.Date fecha_final, String tipo, int id_maquina){
        fbd.editarMecanicos(id, nombre, fecha_inicio, fecha_final, tipo, id_maquina);
    }
   
   public void anhadirMecanicos(int id, String nombre, java.util.Date fecha_inicio, java.util.Date fecha_final, String tipo, int id_maquina){
        fbd.anhadirMecanicos(id, nombre, fecha_inicio, fecha_final, tipo, id_maquina);
    }
   
   public void borrarMecanicos(int id){
       fbd.borrarMecanicos(id);
    }
   
   public ArrayList<Juego> totalJuegos(){
       return fbd.totalJuegos();
   }
   
   public ArrayList<TipoJuego> buscarTiposJuego(String tipo){
        return fbd.buscarTiposJuego(tipo);
    }
    
    public void editarTiposJuego(String tipo, String reglas_basicas){
        fbd.editarTiposJuego(tipo, reglas_basicas);
    }
   
   public void anhadirTiposJuego(String tipo, String reglas_basicas){
        fbd.anhadirTiposJuego(tipo, reglas_basicas);
    }
   
   public void borrarTiposJuego(String tipo){
        fbd.borrarTiposJuego(tipo);
    }

}
