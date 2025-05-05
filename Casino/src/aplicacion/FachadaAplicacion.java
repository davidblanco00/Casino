
package aplicacion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */

/*
*Modelo vista controlador
*Nota: Aceder a la ventana de 'design' y poner nombre a los botones
*/

public class FachadaAplicacion {
    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GestionEmpleados ce;
    
    
 public FachadaAplicacion(){
   fgui=new gui.FachadaGui(this);
   fbd= new baseDatos.FachadaBaseDatos(this);
   ce =new GestionEmpleados(fgui, fbd);
 }

 public static void main(String args[]) {
     FachadaAplicacion fa;
     
     fa= new FachadaAplicacion();
     fa.iniciaInterfazUsuario();
 }
 
 public void iniciaInterfazUsuario(){
     fgui.iniciaVista();
 }
 
 public void iniciaFachadaEmpleado(){
     fgui.iniciaFachadaEmpleado();
 }

 public void muestraExcepcion(String e){
     fgui.muestraExcepcion(e);
 }
 
 
 public Empleado validarAdministrador(String nombre, String contrasenha){
        return ce.validarAdministrador(nombre, contrasenha);
 }


public List<Zonas> buscarZonas(){
    return fbd.buscarZonas();
}

public List<Integer> emparejarZonasEmpleados(List<Zonas> zonas){
    ArrayList<Integer> resultado=new ArrayList<Integer>();
    for(Zonas z:zonas){
        resultado.add(fbd.calcularEmpleadosZona(z));
    }
    return resultado;
}

public void borrarZona(Zonas z){
    fbd.borrarZona(z);
}

public List<Receta> buscarRecetas(String nombre,Float precio,String ordenarPor){
    return fbd.buscarRecetas(nombre,precio,ordenarPor);
}

public List<Producto> buscarProductos(String nombre,Float precio,String ordenarPor){
    return fbd.buscarProductos(nombre,precio,ordenarPor);
}

public List<Decoracion> buscarDecoraciones(String id,String tipo,String modelo,String ordenarPor){
    return fbd.buscarDecoraciones(id,tipo,modelo,ordenarPor);
}

public void borrarReceta(Receta r){
    fbd.borrarReceta(r);
}

public void borrarEmpleado(Empleado e){
    fbd.borrarEmpleado(e);
}

public void borrarProducto(Producto p){
    fbd.borrarProducto(p);
}

public void borrarDecoracion(Decoracion d){
    fbd.borrarDecoracion(d);
}

public void borrarServicio(Servicios s){
    fbd.borrarServicio(s);
}

public List<Bar> baresRecetaDisponible(Receta r){
    return fbd.baresRecetaDisponible(r);
}

public List<Zonas> zonasTrabaja(Empleado e){
    return fbd.zonasTrabaja(e);
}

public List<Zonas> zonasDisponible(Servicios s){
    return fbd.zonasDisponible(s);
}

public List<Bar> baresRecetaNoDisponible(Receta r){
    return fbd.baresRecetaNoDisponible(r);
}

public List<Zonas> zonasNoTrabaja(Empleado e){
    return fbd.zonasNoTrabaja(e);
}

public List<Zonas> zonasNoDisponible(Servicios s){
    return fbd.zonasNoDisponible(s);
}

public List<Bar> todosLosBares(){
    return fbd.todosLosBares();
}

public List<Producto> todosLosProductos(){
    return fbd.todosLosProductos();
}

public List<Float> emparejarCantidadesProductos(Receta r,List<Producto> productos){
    List<Float> resultado=new ArrayList<Float>();
    for(Producto p:productos){
        resultado.add(fbd.cantidadReceta(r,p));
    }
    return resultado;
}

public void modificarReceta(Receta receta,List<Bar> bares,List<Producto> productos,List<Float> cantidades){
    fbd.modificarReceta(receta,bares,productos,cantidades);
}

public void anhadirReceta(Receta receta,List<Bar> bares,List<Producto> productos,List<Float> cantidades){
    fbd.anhadirReceta(receta,bares,productos,cantidades);
}

public List<Empleado> buscarEmpleados(String dni, String nombre, String rol, String ordenarPor){
    return fbd.buscarEmpleados(dni,nombre,rol,ordenarPor);
}

public List<Servicios> buscarServicios(String nombre, String ordenarPor){
    return fbd.buscarServicios(nombre,ordenarPor);
}

public void modificarEmpleado(Empleado em,List<Zonas> trabaja){
    fbd.modificarEmpleado(em,trabaja);
}

public void anhadirEmpleado(Empleado em,List<Zonas> trabaja){
    fbd.anhadirEmpleado(em,trabaja);
}

public List<Zonas> todasLasZonas(){
    return fbd.todasLasZonas();
}

public void modificarServicio(Servicios s, List<Zonas> disponible){
    fbd.modificarServicio(s,disponible);
}

public void anhadirServicio(Servicios s, List<Zonas> disponible){
    fbd.anhadirServicio(s,disponible);
}

public void modificarDecoracion(Decoracion d, String zona){
    fbd.modificarDecoracion(d,zona);
}

public void anhadirDecoracion(Decoracion d, String zona){
    fbd.anhadirDecoracion(d,zona);
}

public void modificarProducto(Producto p){
    fbd.modificarProducto(p);
}

public void anhadirProducto(Producto p){
    fbd.anhadirProducto(p);
}

public void anhadirBar(Bar b){
    fbd.anhadirBar(b);
}

public void anhadirZona(Zonas z){
    fbd.anhadirZona(z);
}

}
