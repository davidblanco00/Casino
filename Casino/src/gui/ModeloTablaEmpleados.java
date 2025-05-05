
package gui;
import aplicacion.Empleado;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author david
 */
public class ModeloTablaEmpleados extends AbstractTableModel{
    private java.util.List<Empleado> empleados;
    
    public ModeloTablaEmpleados(){
        this.empleados=new java.util.ArrayList<>();
    }
    
    @Override
    public int getColumnCount (){
        return 3;
    }
    
    @Override
    public int getRowCount() {
        return empleados.size();
    }
    
    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "DNI"; break;
            case 1: nombre= "Nombre"; break;
            case 2: nombre= "Rol"; break;
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
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
            case 0: resultado=empleados.get(row).getDni(); break;
            case 1: resultado=empleados.get(row).getNombre(); break;
            case 2: resultado=empleados.get(row).getRol(); break;
        }
        
        return resultado;
    }
    
    public void setFilas(java.util.List<Empleado> empleados){
        this.empleados=empleados;
        fireTableDataChanged();
    }

    public Empleado obtenerEmpleado(int i){
        return this.empleados.get(i);
    }
}
