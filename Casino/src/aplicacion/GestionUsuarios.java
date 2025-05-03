/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

/**
 *
 * @author alumnogreibd
 */
class GestionUsuarios {
    FachadaGui fgui;
    FachadaBaseDatos fbd;


    public GestionUsuarios(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    } 
    
    public Usuario validarUsuario(String nickname, String contrasenha){
        return fbd.validarUsuario(nickname, contrasenha);
    }
    
    public void editarUsuario(String dni, String nickname, Float saldo, String contrasenha){
        fbd.editarUsuario(dni, nickname, saldo, contrasenha);
    }
}
