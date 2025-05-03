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
public class ApuestaJuego {
    private int id_apuesta;
    private int id_juego;
    private String dni;

    public ApuestaJuego (int id_apuesta, int id_juego, String dni){
        this.id_apuesta=id_apuesta;
        this.id_juego=id_juego;
        this.dni=dni;
   }

   public int getId_apuesta(){
       return this.id_apuesta;
   }

   public float getId_juego(){
       return this.id_juego;
   }

   public String getDni(){
       return this.dni;
   }

}
