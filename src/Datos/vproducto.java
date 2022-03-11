package Datos;

import Domain.Productos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class vproducto {

    private final conexion mysql = new conexion(); //instancia para la conexion
    private Connection cn = mysql.conectar();
    
    private  String SQL_SELECT = "";
    private  String SQL_INSERT = "";
    private  String SQL_UPDATE = "";
    private  String SQL_DELETE = "";

    public List<Productos> listar() {
        PreparedStatement consultaPreparada = null;
        SQL_SELECT = "select * from productos";
        ResultSet resultado = null;
        List<Productos> producto = new ArrayList<>();
        Productos productos;

        try {
            consultaPreparada = cn.prepareStatement(SQL_SELECT);
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

     public List<Productos> mostrar(String buscar) {  // Mostrar los registros de la tabla producto
        PreparedStatement consultaPreparada = null;
        ResultSet resultado = null;
        List<Productos> producto = new ArrayList<>();
        Productos productos;

        int registros = 0;
   

        SQL_SELECT = "select *from productos where Nombre like '%" + buscar + "%' order by Id_Producto desc "; //Consulta para obtener los registros de la tabla

        try { //declaracion de errores 
            consultaPreparada = cn.prepareStatement(SQL_SELECT);
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
    
    
     
    public int insertar(Productos productos) {

        PreparedStatement consultaPreparada = null;
        SQL_INSERT = "insert into productos (Nombre,Precio,Existencias) values (?,?,?)";
        int registros = 0;

        try {

            consultaPreparada = cn.prepareStatement(SQL_INSERT);

            consultaPreparada.setString(1, productos.getNombre());
            consultaPreparada.setDouble(2, productos.getPrecio());
            consultaPreparada.setInt(3, productos.getExistencias());
            registros = consultaPreparada.executeUpdate();
               

        } catch (SQLException error) {
            System.out.println(error);

        }  
        return registros;
    }

    public int modificar(Productos productos, String buscar) {
   
        PreparedStatement consultaPreparada = null;
        SQL_UPDATE = "update productos set Nombre = ?,Precio=?,Existencias =? where Nombre like '%" + buscar;
        
        int registros = 0;

        try {

            consultaPreparada = cn.prepareStatement(SQL_UPDATE);

            consultaPreparada.setString(1, productos.getNombre());
            consultaPreparada.setDouble(2, productos.getPrecio());
            consultaPreparada.setInt(3, productos.getExistencias());
            consultaPreparada.setInt(4, productos.getId_Producto());
            
            registros = consultaPreparada.executeUpdate();
            
        } catch (SQLException error) {
            
            System.out.println(error);
        } 
        return registros;
    }

    public boolean eliminar(Productos buscar) {
         PreparedStatement consultaPreparada = null;
        
        SQL_DELETE = "delete from productos where Nombre =?";  // Borra los registros de los productos en el ID indicado

        try {
            consultaPreparada = cn.prepareStatement(SQL_DELETE);
           consultaPreparada.setString(1, buscar.getNombre());//
           int n = consultaPreparada.executeUpdate();
           
         if (n != 0) {   //Revisa si esta vacio
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e); //lanza el mesaje de error
            return false;
        }   
    }

}
