/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import java.util.Date;

/**
 *
 * @author alumnogreibd
 */
public class Maquina {
    private int id;
    private String nombre;
    private int anho_compra;

    public Maquina (int id, String nombre, int anho_compra){
    this.id=id;
    this.nombre=nombre;
    this.anho_compra=anho_compra;
   }

   public int getId(){

       return this.id;
   }

   public String getNombre(){

       return this.nombre;
   }

   public int getAnho_compra(){

       return this.anho_compra;
   }

}
