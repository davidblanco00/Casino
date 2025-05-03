/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Ficha {
    private String color;
    private float precio;
    private int total_sin_reservar;

    public Ficha (String color, float precio, int total_sin_reservar){
    this.color=color;
    this.precio=precio;
    this.total_sin_reservar=total_sin_reservar;
   }

   public String getColor(){

       return this.color;
   }

   public float getPrecio(){

       return this.precio;
   }

   public int getTotal_sin_reservar(){

       return this.total_sin_reservar;
   }

}
