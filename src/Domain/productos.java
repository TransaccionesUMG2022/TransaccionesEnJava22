
package Domain;

public class productos {
    private int id_producto;       //declaracion de las variables producto
    private String nombre;
    private Double precio;
    private int existencias;

    public productos(int id_producto) {
        this.id_producto = id_producto;
    }

    public productos(String nombre, Double precio, int existencias) {
        this.nombre = nombre;
        this.precio = precio;
        this.existencias = existencias;
    }

    public productos(int id_producto, String nombre, Double precio, int existencias) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.existencias = existencias;
    }

    public productos() {
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    @Override
    public String toString() {
        return "productos{" + "id_producto=" + id_producto + ", nombre=" + nombre + ", precio=" + precio + ", existencias=" + existencias + '}';
    }
  
}
