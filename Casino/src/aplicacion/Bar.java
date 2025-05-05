
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Bar extends Zonas{
    private Integer id;
    public Bar(String nombre){
        super(nombre);
    }
    public Bar(String nombre,Integer id){
        super(nombre);
        this.id=id;
    }
    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id=id;
    }

}
