/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;


import aplicacion.Bar;

/**
 *
 * @author basesdatos
 */
public class ModeloListaBares extends javax.swing.AbstractListModel {
    java.util.List<Bar> elementos;

    public ModeloListaBares(){
        this.elementos=new java.util.ArrayList<Bar>();
    }

    public int getSize(){
        return this.elementos.size();
    }

    public String getElementAt(int i){
        return elementos.get(i).getNombre();
    }
    
    public Bar obtenerBar(int i){
        return elementos.get(i);
    }

    public void nuevoElemento(Bar e){
        this.elementos.add(e);
        fireIntervalAdded(this, this.elementos.size()-1, this.elementos.size()-1);
    }

    public void borrarElemento(int i){
        Bar e;
        e=this.elementos.get(i);
        this.elementos.remove(i);
        fireIntervalRemoved(this,i,i);
    }

    public void setElementos(java.util.List<Bar> elementos){
        this.elementos=elementos;
        fireContentsChanged(this, 0, elementos.size()-1);
    }

    public java.util.List<Bar> getElementos(){
        return this.elementos;
    }
}
