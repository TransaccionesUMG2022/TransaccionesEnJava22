
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

    private Conexion() {

    }

    private static final String URL = "jdbc:mysql://127.0.0.1/";
    private static final String USER = "root";
    private static final String PASSWORD = "Admin";
    private static Conexion instancia;

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void cerrarresultado(ResultSet resultado) {
        try {
            resultado.close();

        } catch (SQLException error) {
            System.out.println(error);
        }

    }

    public void desconectar(Connection Conexion) {
        try {
            Conexion.close();

        } catch (SQLException error) {
            System.out.println(error);
        }
    }

    public void cerrarStatement(PreparedStatement statement) {
        try {
            statement.close();

        } catch (SQLException error) {
            System.out.println(error);
        }
    }

    public static Conexion getInstance() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

}
