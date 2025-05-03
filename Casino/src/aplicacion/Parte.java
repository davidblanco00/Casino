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
public class Parte {
    private int id;
    private String nombre;
    private String modelo;
    private String productora;
    private String estado;

    public Parte (int id, String nombre, String modelo, String productora, String estado){
    this.id=id;
    this.nombre=nombre;
    this.modelo=modelo;
    this.productora=productora;
    this.estado=estado;
   }

   public int getId(){
       return this.id;
   }

   public String getNombre(){

       return this.nombre;
   }

   public String getModelo(){

       return this.modelo;
   }
   
   public String getProductora(){

       return this.productora;
   }
   
   public String getEstado(){

       return this.estado;
   }

}
