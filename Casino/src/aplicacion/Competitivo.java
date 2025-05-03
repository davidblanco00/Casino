/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alumnogreibd
 */
public class Competitivo extends Juego{
    private int num_jugadores;

    public Competitivo (int id, String nombre, Date fecha_inicio, Date fecha_final, String tipo, int num_jugadores){
        super(id, nombre, fecha_inicio, fecha_final, tipo);
        this.num_jugadores=num_jugadores;
   }
    
    public int getNum_jugadores(){
       return this.num_jugadores;
   }
    

}
