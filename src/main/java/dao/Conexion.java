package dao;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {

    private Conexion() {

    }

    private static Connection conexion;

    private static Conexion instancia;

    //Creamos las variables para poder conectarnos a la Base de Datos
    private final String URL = "jdbc:mysql://localhost:3306/bd_alumnos";
    private final String USERNAME = "root";
    private final String PASSWORD = "Java@2023";

    //Creamos el metodo para conectarnos a la base de datos    
    public Connection conectar() {
        //Manejo de excepciones mediante Try-Catch
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return conexion;
    }
    
    //Metodo para poder cerrar la conexion
    public void cerrarConexion() throws SQLException {
        try {
            conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        } finally {
            conexion.close();
        }

    }
    
    //Metodo para crear una unica instancia de la clase conexion
    public static Conexion getInstance() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

}
