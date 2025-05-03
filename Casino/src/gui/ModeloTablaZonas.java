/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui;
import aplicacion.Zonas;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author david
 */
public class ModeloTablaZonas extends AbstractTableModel{
    private java.util.List<Zonas> zonas;
    
    public ModeloTablaZonas(){
        this.zonas=new java.util.ArrayList<>();
    }
    
    @Override
    public int getColumnCount (){
        return 1;
    }
    
    @Override
    public int getRowCount() {
        return zonas.size();
    }
    
    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "NOMBRE"; break;
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
        }
        return clase;
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object resultado=null;

        switch (col){
            case 0: resultado=zonas.get(row).getNombre(); break;
        }
        return resultado;
    }
    
    public void setFilas(java.util.List<Zonas> zonas){
        this.zonas=zonas;
        fireTableDataChanged();
    }

    public Zonas obtenerZona(int i){
        return this.zonas.get(i);
    }
}
