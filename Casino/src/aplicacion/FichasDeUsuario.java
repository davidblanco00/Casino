/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class FichasDeUsuario {
    private String color;
    private String dni;
    private int cantidad;

    public FichasDeUsuario (String color, String dni, int cantidad){
    this.color=color;
    this.dni=dni;
    this.cantidad=cantidad;
   }

   public String getColor(){

       return this.color;
   }

   public String getDni(){

       return this.dni;
   }

   public int getCantidad(){

       return this.cantidad;
   }

}
