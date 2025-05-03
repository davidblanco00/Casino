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
public class Mecanico extends Juego{
    private int id_maquina;

    public Mecanico (int id, String nombre, Date fecha_inicio, Date fecha_final, String tipo, int id_maquina){
        super(id, nombre, fecha_inicio, fecha_final, tipo);
        this.id_maquina=id_maquina;
   }
    
    public int getId_maquina(){
       return this.id_maquina;
   }

}
