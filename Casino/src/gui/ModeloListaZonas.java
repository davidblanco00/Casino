
package gui;


import aplicacion.Zonas;

/**
 *
 * @author david
 */
public class ModeloListaZonas extends javax.swing.AbstractListModel {
    java.util.List<Zonas> elementos;

    public ModeloListaZonas(){
        this.elementos=new java.util.ArrayList<Zonas>();
    }

    public int getSize(){
        return this.elementos.size();
    }

    public String getElementAt(int i){
        return elementos.get(i).getNombre();
    }
    
    public Zonas obtenerZona(int i){
        return elementos.get(i);
    }

    public void nuevoElemento(Zonas e){
        this.elementos.add(e);
        fireIntervalAdded(this, this.elementos.size()-1, this.elementos.size()-1);
    }

    public void borrarElemento(int i){
        Zonas e;
        e=this.elementos.get(i);
        this.elementos.remove(i);
        fireIntervalRemoved(this,i,i);
    }

    public void setElementos(java.util.List<Zonas> elementos){
        this.elementos=elementos;
        fireContentsChanged(this, 0, elementos.size()-1);
    }

    public java.util.List<Zonas> getElementos(){
        return this.elementos;
    }
}
