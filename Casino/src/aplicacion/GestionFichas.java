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
class GestionFichas {
    FachadaGui fgui;
    FachadaBaseDatos fbd;


    public GestionFichas(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    } 
    
    public ArrayList<Ficha> buscarFichas(String color){
        return fbd.buscarFichas(color);
    }
    
    public void editarFichas(String color, float precio, int total_sin_reservar){
        fbd.editarFichas(color, precio, total_sin_reservar);
    }
    
    public void anhadirFichas(String color, float precio, int total_sin_reservar){
        fbd.editarFichas(color, precio, total_sin_reservar);
    }
    
    public void borrarFichas(String color){
        fbd.borrarFichas(color);
    }
    
    public ArrayList<FichasDeUsuario> buscarFichasDeUsuario(String dni){
        return fbd.buscarFichasDeUsuario(dni);
    }
    
    public FichasDeUsuario buscarMasaDeFichas(String dni, String color){
        return fbd.buscarMasaDeFichas(dni, color);
    }
    
    public void editarFichasDeUsuario(String dni, String color, int cantidad){
        fbd.editarFichasDeUsuario(dni, color, cantidad);
    }
    
    public void anhadirFichasDeUsuario(String dni, String color, int cantidad){
        fbd.anhadirFichasDeUsuario(dni, color, cantidad);
    }
    
    public void borrarFichasDeUsuario(String dni, String color){
        fbd.borrarFichasDeUsuario(dni, color);
    }
}
