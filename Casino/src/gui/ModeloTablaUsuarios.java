/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui;
import aplicacion.Usuario;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaUsuarios extends AbstractTableModel{
    private java.util.List<Usuario> usuarios;
    
    public ModeloTablaUsuarios(){
        this.usuarios=new java.util.ArrayList<Usuario>();
    }
    
    public int getColumnCount (){
        return 4;
    }
    
    public int getRowCount() {
        return usuarios.size();
    }
    
    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "DNI"; break;
            case 1: nombre= "Nickname"; break;
            case 2: nombre="Saldo"; break;
            case 3: nombre="Contraseña"; break;
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.String.class; break;
            case 2: clase=java.lang.String.class; break;
            case 3: clase=java.lang.String.class; break;
        }
        return clase;
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }

    public Object getValueAt(int row, int col) {
        Object resultado=null;

        switch (col){
            case 0: resultado=usuarios.get(row).getDni(); break;
            case 1: resultado=usuarios.get(row).getNickname(); break;
            case 2: resultado=usuarios.get(row).getSaldo();break;
            case 3: resultado=usuarios.get(row).getContrasenha(); break;
        }
        return resultado;
    }
    
    public void setFilas(java.util.List<Usuario> usuarios){
        this.usuarios=usuarios;
        fireTableDataChanged();
    }

    public Usuario obtenerUsuario(int i){
        return this.usuarios.get(i);
    }
}
