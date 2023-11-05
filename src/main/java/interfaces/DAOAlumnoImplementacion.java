package interfaces;

import alumnos.Alumno;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOAlumnoImplementacion implements DAOAlumno {

    Conexion conexion = Conexion.getInstance();

    @Override
    public void registrar(Alumno alumno) {
        try {

            Connection conectar = conexion.conectar();
            PreparedStatement insertar = conectar.prepareStatement("insert into alumnos values(?,?)");

            insertar.setInt(1, alumno.getId());
            insertar.setString(2, alumno.getNombre());
            insertar.executeUpdate();

            conexion.cerrarConexion();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    @Override
    public void modificar(Alumno alumno) {
        try {
            Connection conectar = conexion.conectar();
            PreparedStatement modificar = conectar.prepareStatement("update alumnos set nombre = ? where id = ?");

            modificar.setString(1, alumno.getNombre());
            modificar.setInt(2, alumno.getId());
            modificar.executeUpdate();

            conexion.cerrarConexion();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void eliminar(Alumno alumno) {
        try {
            Connection conectar = conexion.conectar();
            PreparedStatement eliminar = conectar.prepareStatement("delete from alumnos where id = ? ");

            eliminar.setInt(1, alumno.getId());
            eliminar.executeUpdate();

            conexion.cerrarConexion();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    @Override
    public void buscar(Alumno alumno) {
        try {

            Connection conectar = conexion.conectar();
            PreparedStatement buscar = conectar.prepareStatement("select *from alumnos where id = ? ");

            buscar.setInt(1, alumno.getId());
            ResultSet consulta = buscar.executeQuery();

            if (consulta.next()) {
                alumno.setId(Integer.parseInt(consulta.getString("id")));
                alumno.setNombre(consulta.getString("nombre"));

            }

            conexion.cerrarConexion();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
