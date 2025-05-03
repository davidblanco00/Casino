
package aplicacion;

/**
 *
 * @author david
 */
public class Receta {
    private String nombre;
    private float precio_venta;

    public Receta(String nombre, float precio_venta) {
        this.nombre = nombre;
        this.precio_venta = precio_venta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }
    
    
    
}
