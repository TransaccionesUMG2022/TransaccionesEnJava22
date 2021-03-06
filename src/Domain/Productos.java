package Domain;

public class Productos {
    private int Id_Producto;       //declaracion de las variables producto
    private String Nombre;
    private Double Precio;
    private int Existencias;

    public Productos(int Id_Producto) {
        this.Id_Producto = Id_Producto;
    }

    public Productos(String Nombre, Double Precio, int Existencias) {
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Existencias = Existencias;
    }

    public Productos(int Id_Producto, String Nombre, Double Precio, int Existencias) {
        this.Id_Producto = Id_Producto;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Existencias = Existencias;
    }


    public Productos() {
    }

    public int getId_Producto() {
        return Id_Producto;
    }

    public void setId_Producto(int Id_Producto) {
        this.Id_Producto = Id_Producto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public int getExistencias() {
        return Existencias;
    }

    public void setExistencias(int Existencias) {
        this.Existencias = Existencias;
    }

   
    @Override
    public String toString() {
        return "\n"+"\n"+"Id_Producto = " + Id_Producto +"\n"+ "Nombre = " + Nombre +"\n"+ " Precio = " + Precio +"\n"+ " Existencias " + Existencias ;
    }
  
}