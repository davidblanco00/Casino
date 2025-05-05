
package gui;
import aplicacion.Receta;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author david
 */
public class ModeloTablaRecetas extends AbstractTableModel{
    private java.util.List<Receta> recetas;
    
    public ModeloTablaRecetas(){
        this.recetas=new java.util.ArrayList<>();
    }
    
    @Override
    public int getColumnCount (){
        return 2;
    }
    
    @Override
    public int getRowCount() {
        return recetas.size();
    }
    
    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Nombre"; break;
            case 1: nombre= "Precio"; break;
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
        return false;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object resultado=null;

        switch (col){
            case 0: resultado=recetas.get(row).getNombre(); break;
            case 1: resultado=recetas.get(row).getPrecio_venta(); break;
        }
        
        return resultado;
    }
    
    public void setFilas(java.util.List<Receta> recetas){
        this.recetas=recetas;
        fireTableDataChanged();
    }

    public Receta obteneReceta(int i){
        return this.recetas.get(i);
    }
}
