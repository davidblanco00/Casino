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
class GestionEmpleados {
    FachadaGui fgui;
    FachadaBaseDatos fbd;


    public GestionEmpleados(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    } 
    
    public Empleado validarAdministrador(String nombre, String contrasenha){
        return fbd.validarAdministrador(nombre, contrasenha);
    }
}
