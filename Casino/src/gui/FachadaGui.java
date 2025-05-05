
package gui;

import aplicacion.Decoracion;
import aplicacion.Empleado;
import aplicacion.Producto;
import aplicacion.Receta;
import aplicacion.Servicios;
import javax.swing.JDialog;
import javax.swing.JFrame;


/**
 *
 * @author david
 */
public class FachadaGui {
    aplicacion.FachadaAplicacion fa;
    VBienvenida vbv;
    VPrincipalE vpe;
    
    public FachadaGui(aplicacion.FachadaAplicacion fa){
        this.fa=fa;
        this.vbv = new VBienvenida(fa);
    } 
    
    public void iniciaVista(){
        VAutentificacion va;

        va = new VAutentificacion(vbv, true, fa);
        va.setVisible(true);
    }
    
    public void iniciaFachadaEmpleado(){
        vbv.setVisible(true);
    }
    
    public void iniciaPrincipalEmpleado(){
        vpe = new VPrincipalE(fa, this);
        vpe.setVisible(true);
    }
    
    public void muestraExcepcion(String txtExcepcion){
        VAviso va;

        va = new VAviso(vbv, true, txtExcepcion);
        va.setVisible(true);
    }
    
    public void visualizarModificarReceta(JFrame parent,Receta anterior){
        VModificarReceta vmr;
        vmr=new VModificarReceta(parent, true, fa, anterior);
        vmr.setVisible(true);
    }
    
    public void visualizarAnhadirReceta(JFrame parent){
        VAnhadirReceta var;
        var=new VAnhadirReceta(parent, true, fa);
        var.setVisible(true);
    }
    
    public void visualizarModificarEmpleado(JFrame parent,Empleado anterior){
        VModificarEmpleado vme;
        vme=new VModificarEmpleado(parent, true, fa, anterior);
        vme.setVisible(true);
    }
    
    public void visualizarAnhadirEmpleado(JFrame parent){
        VAnhadirEmpleado vae;
        vae=new VAnhadirEmpleado(parent, true, fa);
        vae.setVisible(true);
    }
    
    public void visualizarModificarProducto(JFrame parent,Producto anterior){
        VModificarProducto vmp;
        vmp=new VModificarProducto(parent, true, fa, anterior);
        vmp.setVisible(true);
    }
    
    public void visualizarAnhadirProducto(JFrame parent){
        VAnhadirProducto vap;
        vap=new VAnhadirProducto(parent, true, fa);
        vap.setVisible(true);
    }
    
    public void visualizarModificarDecoracion(JFrame parent,Decoracion anterior){
        VModificarDecoracion vmd;
        vmd=new VModificarDecoracion(parent, true, fa, anterior);
        vmd.setVisible(true);
    }
    
    public void visualizarAnhadirDecoracion(JFrame parent){
        VAnhadirDecoracion vad;
        vad=new VAnhadirDecoracion(parent, true, fa);
        vad.setVisible(true);
    }
    
    public void visualizarModificarServicios(JFrame parent,Servicios anterior){
        VModificarServicio vms;
        vms=new VModificarServicio(parent, true, fa, anterior);
        vms.setVisible(true);
    }
    
    public void visualizarAnhadirServicios(JFrame parent){
        VAnhadirServicio vas;
        vas=new VAnhadirServicio(parent, true, fa);
        vas.setVisible(true);
    }
   
}
