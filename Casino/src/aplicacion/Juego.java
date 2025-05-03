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
public class Juego {
    private int id;
    private String nombre;
    private Date fecha_inicio;
    private Date fecha_final;
    private String tipo;

    public Juego (int id, String nombre, Date fecha_inicio, Date fecha_final, String tipo){
        this.id=id;
        this.nombre=nombre;
        this.fecha_inicio=fecha_inicio;
        this.fecha_final=fecha_final;
        this.tipo=tipo;
   }

   public int getId(){

       return this.id;
   }

   public String getNombre(){

       return this.nombre;
   }

   public Date getFecha_inicio(){

       return this.fecha_inicio;
   }
   
   public Date getFecha_final(){

       return this.fecha_final;
   }
   
   public String getTipol(){

       return this.tipo;
   }

}
