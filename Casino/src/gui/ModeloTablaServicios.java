
package gui;
import aplicacion.Servicios;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author david
 */
public class ModeloTablaServicios extends AbstractTableModel{
    private java.util.List<Servicios> servicios;
    
    public ModeloTablaServicios(){
        this.servicios=new java.util.ArrayList<>();
    }
    
    @Override
    public int getColumnCount (){
        return 2;
    }
    
    @Override
    public int getRowCount() {
        return servicios.size();
    }
    
    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Nombre"; break;
            case 1: nombre= "Descripción"; break;
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.String.class; break;
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
            case 0: resultado=servicios.get(row).getNombre(); break;
            case 1: resultado=servicios.get(row).getDescripcion(); break;
        }
        
        return resultado;
    }
    
    public void setFilas(java.util.List<Servicios> servicios){
        this.servicios=servicios;
        fireTableDataChanged();
    }

    public Servicios obtenerServicio(int i){
        return this.servicios.get(i);
    }
}
