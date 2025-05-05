
package gui;
import aplicacion.Decoracion;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author david
 */
public class ModeloTablaDecoraciones extends AbstractTableModel{
    private java.util.List<Decoracion> decoraciones;
    
    public ModeloTablaDecoraciones(){
        this.decoraciones=new java.util.ArrayList<>();
    }
    
    @Override
    public int getColumnCount (){
        return 4;
    }
    
    @Override
    public int getRowCount() {
        return decoraciones.size();
    }
    
    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Id"; break;
            case 1: nombre= "Tipo"; break;
            case 2: nombre= "Modelo"; break;
            case 3: nombre= "Estado"; break;
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= Integer.class; break;
            case 1: clase= java.lang.String.class; break;
            case 2: clase= java.lang.String.class; break;
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
            case 0: resultado=decoraciones.get(row).getId(); break;
            case 1: resultado=decoraciones.get(row).getTipo(); break;
            case 2: resultado=decoraciones.get(row).getModelo(); break;
            case 3: resultado=decoraciones.get(row).getEstado(); break;
        }
        
        return resultado;
    }
    
    public void setFilas(java.util.List<Decoracion> decoraciones){
        this.decoraciones=decoraciones;
        fireTableDataChanged();
    }

    public Decoracion obtenerDecoracion(int i){
        return this.decoraciones.get(i);
    }
}
