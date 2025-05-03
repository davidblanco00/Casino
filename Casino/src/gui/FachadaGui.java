/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Usuario;


/**
 *
 * @author alumno
 */
public class FachadaGui {
    aplicacion.FachadaAplicacion fa;
    VBienvenida vbv;
    VPrincipalU vpu;
    
    public FachadaGui(aplicacion.FachadaAplicacion fa){
        this.fa=fa;
        this.vbv = new VBienvenida(fa);
    } 
    
    public void iniciaVista(){
        VAutentificacion va;

        va = new VAutentificacion(vbv, true, fa);
        vbv.setVisible(true);
        va.setVisible(true);
    }
    
    public void iniciaFachadaUsuario(Usuario usuario){
        vpu = new VPrincipalU(fa, usuario);
        vpu.setVisible(true);
    }
    
    public void muestraExcepcion(String txtExcepcion){
        VAviso va;

        va = new VAviso(vbv, true, txtExcepcion);
        va.setVisible(true);
    }
   
}
