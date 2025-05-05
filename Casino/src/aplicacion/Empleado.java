
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Empleado {
    private String dni;
    private String nombre;
    private String rol;
    private String contrasenha;

    public Empleado (String dni, String nombre, String rol, String contrasenha){
    this.dni=dni;
    this.nombre=nombre;
    this.rol=rol;
    this.contrasenha=contrasenha;
   }

   public String getDni(){

       return this.dni;
   }

   public String getNombre(){

       return this.nombre;
   }

   public String getRol(){

       return this.rol;
   }

   public String getContrasenha(){

       return this.contrasenha;
   }

}
