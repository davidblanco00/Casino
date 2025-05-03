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
class GestionMaquinas {
    FachadaGui fgui;
    FachadaBaseDatos fbd;


    public GestionMaquinas(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    } 
    
    public ArrayList<Maquina> buscarMaquinas(int id){
        return fbd.buscarMaquinas(id);
    }
    
    public void editarMaquinas(int id, String nombre, int anho_compra){
        fbd.editarMaquinas(id, nombre, anho_compra);
    }
    
    public void anhadirMaquinas(int id, String nombre, int anho_compra){
        fbd.anhadirMaquinas(id, nombre, anho_compra);
    }
    
    public void borrarMaquinas(int id){
        fbd.borrarMaquinas(id);
    }
    
    public ArrayList<Parte> buscarPartes(int id, String nombre){
        return fbd.buscarPartes(id, nombre);
    }
    
    public void editarPartes(int id, String nombre, String modelo, String productora, String estado){
        fbd.editarPartes(id, nombre, modelo, productora, estado);
    }
    
    public void anhadirPartes(int id, String nombre, String modelo, String productora, String estado){
        fbd.anhadirPartes(id, nombre, modelo, productora, estado);
    }
    
    public void borrarPartes(int id, String nombre){
        fbd.borrarPartes(id, nombre);
    }

}
