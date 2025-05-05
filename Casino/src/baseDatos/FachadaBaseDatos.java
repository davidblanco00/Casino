/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Bar;
import aplicacion.Decoracion;
import aplicacion.Empleado;
import aplicacion.Producto;
import aplicacion.Receta;
import aplicacion.Servicios;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import aplicacion.Zonas;

/**
 *
 * @author basesdatos
 */
public class FachadaBaseDatos {
    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOEmpleados daoEmpleados;
    private DAOZonas daoZonas;
    private DAORecetas daoRecetas;
    private DAOProductos daoProductos;
    private DAODecoraciones daoDecoraciones;
    private DAOServicios daoServicios;

    public FachadaBaseDatos (aplicacion.FachadaAplicacion fa){
        
        Properties configuracion = new Properties();
        this.fa=fa;
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();
     

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            
            System.out.println("jdbc:"+gestor+"://"+
                    configuracion.getProperty("servidor")+":"+
                    configuracion.getProperty("puerto")+"/"+
                    configuracion.getProperty("baseDatos"));
            
            System.out.println(usuario);
            
            this.conexion=java.sql.DriverManager.getConnection("jdbc:"+gestor+"://"+
                    configuracion.getProperty("servidor")+":"+
                    configuracion.getProperty("puerto")+"/"+
                    configuracion.getProperty("baseDatos"),
                    usuario);
            
            this.daoEmpleados = new DAOEmpleados(conexion, fa);
            this.daoZonas = new DAOZonas(conexion, fa);
            this.daoRecetas = new DAORecetas(conexion, fa);
            this.daoProductos = new DAOProductos(conexion, fa);
            this.daoDecoraciones = new DAODecoraciones(conexion, fa);
            this.daoServicios = new DAOServicios(conexion, fa);

        } catch (FileNotFoundException f){
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException i){
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        } 
        catch (java.sql.SQLException e){
            System.out.println(e.getMessage());
            fa.muestraExcepcion(e.getMessage());
            System.out.println("ERROR");
            System.out.flush();
        }
        
    }
    
    public Empleado validarAdministrador(String nombre, String contrasenha){
        return daoEmpleados.validarAdministrador(nombre, contrasenha);
    }
    
   public List<Zonas> buscarZonas(){
       return daoZonas.buscarZonas();
   }
   
   public Integer calcularEmpleadosZona(Zonas z){
       return daoZonas.calcularEmpleadosZona(z); 
   }
   
   public void borrarZona(Zonas z){
       daoZonas.borrarZona(z);
   }
   
   public List<Receta> buscarRecetas(String nombre,Float precio,String ordenarPor){
       return daoRecetas.buscarRecetas(nombre,precio,ordenarPor);
   }
   
   public List<Producto> buscarProductos(String nombre,Float precio,String ordenarPor){
       return daoProductos.buscarProductos(nombre,precio,ordenarPor);
   }
   
   public List<Decoracion> buscarDecoraciones(String id,String tipo,String modelo,String ordenarPor){
       return daoDecoraciones.buscarDecoraciones(id,tipo,modelo,ordenarPor);
   }
   
   public void borrarReceta(Receta r){
       daoRecetas.borrarReceta(r);
   }
   
   public void borrarEmpleado(Empleado e){
       daoEmpleados.borrarEmpleado(e);
   }
   
   public void borrarProducto(Producto p){
       daoProductos.borrarProducto(p);
   }
   
   public void borrarDecoracion(Decoracion d){
       daoDecoraciones.borrarDecoracion(d);
   }
   
   public void borrarServicio(Servicios s){
       daoServicios.borrarServicio(s);
   }
   
   public List<Bar> baresRecetaDisponible(Receta r){
       return daoRecetas.baresRecetaDisponible(r);
   }
   
   public List<Zonas> zonasTrabaja(Empleado e){
       return daoEmpleados.zonasTrabaja(e);
   }
   
   public List<Zonas> zonasDisponible(Servicios s){
       return daoServicios.zonasDisponible(s);
   }
   
   public List<Bar> baresRecetaNoDisponible(Receta r){
       return daoRecetas.baresRecetaNoDisponible(r);
   }
   
   public List<Zonas> zonasNoTrabaja(Empleado e){
       return daoEmpleados.zonasNoTrabaja(e);
   }
   
   public List<Zonas> zonasNoDisponible(Servicios s){
       return daoServicios.zonasNoDisponible(s);
   }
   
   public List<Producto> todosLosProductos(){
       return daoRecetas.todosLosProductos();
   }
   
   public Float cantidadReceta(Receta r,Producto p){
       return daoRecetas.cantidadReceta(r,p);
   }
   
   public void modificarReceta(Receta receta,List<Bar> bares,List<Producto> productos,List<Float> cantidades){
       daoRecetas.modificarReceta(receta,bares,productos,cantidades);
   }
   
   public List<Bar> todosLosBares(){
       return daoRecetas.todosLosBares();
   }
   
   public void anhadirReceta(Receta receta,List<Bar> bares,List<Producto> productos,List<Float> cantidades){
       daoRecetas.anhadirReceta(receta,bares,productos,cantidades);
   }
   
   public List<Empleado> buscarEmpleados(String dni, String nombre, String rol, String ordenarPor){
       return daoEmpleados.buscarEmpleados(dni,nombre,rol,ordenarPor);
   }
   
   public List<Servicios> buscarServicios(String nombre, String ordenarPor){
       return daoServicios.buscarServicios(nombre,ordenarPor);
   }
   
   public void modificarEmpleado(Empleado em,List<Zonas> trabaja){
       daoEmpleados.modificarEmpleado(em,trabaja);
   }
   
   public void anhadirEmpleado(Empleado em,List<Zonas> trabaja){
       daoEmpleados.anhadirEmpleado(em,trabaja);
   }
   
   public List<Zonas> todasLasZonas(){
       return daoZonas.todasLasZonas();
   }
   
   public void modificarServicio(Servicios s, List<Zonas> disponible){
       daoServicios.modificarServicio(s,disponible);
   }
   
   public void anhadirServicio(Servicios s, List<Zonas> disponible){
       daoServicios.anhadirServicio(s,disponible);
   }
   
   public void modificarDecoracion(Decoracion d, String zona){
       daoDecoraciones.modificarDecoracion(d,zona);
   }
   
   public void anhadirDecoracion(Decoracion d, String zona){
       daoDecoraciones.anhadirDecoracion(d,zona);
   }
   
   public void modificarProducto(Producto p){
       daoProductos.modificarProducto(p);
   }
   
   public void anhadirProducto(Producto p){
       daoProductos.anhadirProducto(p);
   }
   
   public void anhadirBar(Bar b){
       daoZonas.anhadirBar(b);
   }

   public void anhadirZona(Zonas z){
       daoZonas.anhadirZona(z);
   }

}
