package Datos;

import Domain.Productos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
public class vproducto {

    conexion instanciaMysql = conexion.getInstance();
    private static final String SQL_SELECT = "select * from productos";
    private static final String SQL_INSERT = "insert into productos (Nombre,Precio,Existencias) values (?,?,?)";
    private static final String SQL_UPDATE = "update productos set Nombre = ?,Precio=?,Existencias =? where Id_Producto = ?";
    private static final String SQL_DELETE = "delete from productos where Id_Producto =?";

    public List<Productos> listar() {
        Connection conexion = null;
        PreparedStatement consultaPreparada = null;
        ResultSet resultado = null;
        List<Productos> producto = new ArrayList<>();
        Productos productos;

        try {
            conexion = instanciaMysql.conectar();
            consultaPreparada = conexion.prepareStatement(SQL_SELECT);
            resultado = consultaPreparada.executeQuery();

            while (resultado.next()) {
                int Id_Producto = resultado.getInt("Id_Producto");
                String Nombre = resultado.getString("Nombre");
                double Precio = resultado.getDouble("Precio");
                int Existencias = resultado.getInt("Existencias");

                productos = new Productos(Id_Producto, Nombre, Precio, Existencias);
                producto.add(productos);

            }
        } catch (SQLException error) {
            System.out.println(error);
        }
        return producto;

    }

}
