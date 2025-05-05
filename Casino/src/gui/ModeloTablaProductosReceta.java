
package gui;

import aplicacion.Producto;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author david
 */
public class ModeloTablaProductosReceta extends AbstractTableModel{
    private java.util.List<Producto> productos;
    private java.util.List<Float> cantidades;
    
    public ModeloTablaProductosReceta(){
        this.productos=new java.util.ArrayList<>();
        this.cantidades=new java.util.ArrayList<>();
    }
    
    @Override
    public int getColumnCount (){
        return 2;
    }
    
    @Override
    public int getRowCount() {
        return productos.size();
    }
    
    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Nombre"; break;
            case 1: nombre= "Cantidad"; break;
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.Float.class; break;
        }
        return clase;
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        if(col==1){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object resultado=null;

        switch (col){
            case 0: resultado=productos.get(row).getNombre(); break;
            case 1: resultado=cantidades.get(row); break;
        }
        
        return resultado;
    }
    
    public void setFilas(java.util.List<Producto> productos,java.util.List<Float> cantidades){
        this.productos=productos;
        this.cantidades=cantidades;
        fireTableDataChanged();
    }

    public Producto obtenerProducto(int i){
        return this.productos.get(i);
    }
    
    public List<Producto> getProductos(){
        return this.productos;
    }
    
    public List<Float> getCantidades(){
        return this.cantidades;
    }
}
