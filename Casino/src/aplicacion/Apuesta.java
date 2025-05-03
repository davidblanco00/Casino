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
public class Apuesta {
    private int id;
    private float dinero;
    private boolean resultado;

    public Apuesta (int id, float dinero, boolean resultado){
        this.id=id;
        this.dinero=dinero;
        this.resultado=resultado;
   }

   public int getId(){
       return this.id;
   }

   public float getDinero(){
       return this.dinero;
   }

   public boolean getResultado(){
       return this.resultado;
   }

}
