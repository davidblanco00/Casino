
package gui;
import aplicacion.Producto;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author david
 */
public class ModeloTablaProductos extends AbstractTableModel{
    private java.util.List<Producto> productos;
    
    public ModeloTablaProductos(){
        this.productos=new java.util.ArrayList<>();
    }
    
    @Override
    public int getColumnCount (){
        return 3;
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
            case 1: nombre= "Stock"; break;
            case 2: nombre= "Precio"; break;
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.Float.class; break;
            case 2: clase= java.lang.Float.class; break;
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
            case 0: resultado=productos.get(row).getNombre(); break;
            case 1: resultado=productos.get(row).getExistencias(); break;
            case 2: resultado=productos.get(row).getPrecio_compra(); break;
        }
        
        return resultado;
    }
    
    public void setFilas(java.util.List<Producto> productos){
        this.productos=productos;
        fireTableDataChanged();
    }

    public Producto obtenerProducto(int i){
        return this.productos.get(i);
    }
}
