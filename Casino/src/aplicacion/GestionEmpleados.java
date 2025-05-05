
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

/**
 *
 * @author david
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
