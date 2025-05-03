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
class GestionApuestas {
    FachadaGui fgui;
    FachadaBaseDatos fbd;


    public GestionApuestas(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    } 
    
    public ArrayList<Apuesta> buscarApuestas(int id){
        return fbd.buscarApuestas(id);
    }
    
    public void editarApuestas(int id, float dinero, boolean resultado){
        fbd.editarApuestas(id, dinero, resultado);
    }
    
    public void anhadirApuestas(int id, float dinero, boolean resultado){
        fbd.anhadirApuestas(id, dinero, resultado);
    }
    
    public void borrarApuestas(int id){
        fbd.borrarApuestas(id);
    }

}
