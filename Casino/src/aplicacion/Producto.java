
package aplicacion;

/**
 *
 * @author david
 */
public class Producto {
    private String nombre;
    private float existencias;
    private float precio_compra;

    public Producto(String nombre, float existencias, float precio_compra) {
        this.nombre = nombre;
        this.existencias = existencias;
        this.precio_compra = precio_compra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }
}
