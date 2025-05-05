
package gui;
import aplicacion.Zonas;
import aplicacion.Bar;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author david
 */
public class ModeloTablaZonas extends AbstractTableModel{
    private java.util.List<Zonas> zonas;
    private java.util.List<Integer> numerosDeEmpleados;
    
    public ModeloTablaZonas(){
        this.zonas=new java.util.ArrayList<>();
    }
    
    @Override
    public int getColumnCount (){
        return 3;
    }
    
    @Override
    public int getRowCount() {
        return zonas.size();
    }
    
    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Nombre"; break;
            case 1: nombre= "Nº de empleados"; break;
            case 2: nombre= "Tipo"; break;
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.Integer.class; break;
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
            case 0: resultado=zonas.get(row).getNombre(); break;
            case 1: resultado=numerosDeEmpleados.get(row); break;
            case 2: if(zonas.get(row) instanceof Bar){
                        resultado="Bar";
                    }
                    else{
                        resultado="Normal";
                    }
                    break;
            }
        
        return resultado;
    }
    
    public void setFilas(java.util.List<Zonas> zonas,java.util.List<Integer> numerosDeEmpleados){
        this.zonas=zonas;
        this.numerosDeEmpleados=numerosDeEmpleados;
        fireTableDataChanged();
    }

    public Zonas obtenerZona(int i){
        return this.zonas.get(i);
    }
}
