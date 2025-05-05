/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Bar extends Zonas{
    private Integer id;
    public Bar(String nombre){
        super(nombre);
    }
    public Bar(String nombre,Integer id){
        super(nombre);
        this.id=id;
    }
    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id=id;
    }

}
