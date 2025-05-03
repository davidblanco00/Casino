
package aplicacion;

/**
 *
 * @author david
 */
public class Decoracion {
    private int id;
    private String tipo;
    private String modelo;
    private String estado;

    public Decoracion(int id, String tipo, String modelo, String estado) {
        this.id = id;
        this.tipo = tipo;
        this.modelo = modelo;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
