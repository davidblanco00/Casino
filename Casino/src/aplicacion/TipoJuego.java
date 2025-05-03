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
public class TipoJuego {
    private String tipo;
    private String reglas_basicas;

    public TipoJuego (String tipo, String reglas_basicas){
        this.tipo=tipo;
        this.reglas_basicas=reglas_basicas;
   }

   public String getTipo(){
       return this.tipo;
   }

   public String getReglas_basicas(){
       return this.reglas_basicas;
   }

}
