/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Usuario {
    private String dni;
    private String nickname;
    private float saldo;
    private String contrasenha;

    public Usuario (String dni, String nickname, float saldo, String contrasenha){
    this.dni=dni;
    this.nickname=nickname;
    this.saldo=saldo;
    this.contrasenha=contrasenha;
   }

   public String getDni(){

       return this.dni;
   }

   public String getNickname(){

       return this.nickname;
   }

   public float getSaldo(){

       return this.saldo;
   }

   public String getContrasenha(){

       return this.contrasenha;
   }

}
