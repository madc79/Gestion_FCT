package aed.gestion_fct.model;

import aed.gestion_fct.Alumno;
import aed.gestion_fct.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AlumnoCRUD {

    /**
     * Crea un nuevo registro en la tabla "alumno". Solicita al usuario ingresar
     * los datos necesarios: nombre, teléfono, correo e ID del programa. Valida
     * los datos antes de insertarlos en la base de datos.
     */
    public static void crearAlumno(String nombre, String apellidos, String telefono,
                            String correo, int id_practica, int id_programa,
                            int id_tutordocente, int id_tutorempresa, int id_empresa) {

        String insertQuery = "INSERT INTO alumno (nombre, apellidos, telefono, correo,"
                + "id_practica, id_programa, id_tutordocente, id_tutorempresa, id_empresa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellidos); // Inserta el ID del programa
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, correo);
            preparedStatement.setInt(5, id_practica);
            preparedStatement.setInt(6, id_programa); // Inserta el ID del programa
            preparedStatement.setInt(7, id_tutordocente);
            preparedStatement.setInt(8, id_tutorempresa);
            preparedStatement.setInt(9, id_empresa);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Alumno creado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear alumno: " + e.getMessage());
        }
    }

    /**
     * Lee todos los registros de la tabla "alumno". Muestra el ID, nombre,
     * programa asociado, teléfono y correo de cada alumno en la base de datos.
     */
    public static ObservableList leerAlumno() {
        String query = "SELECT * FROM alumno";
        ObservableList<Alumno> listaAlumnos = FXCollections.observableArrayList();

        try (Connection connection = ConnectionPool.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Alumno alumno = new Alumno(resultSet.getInt("id"), resultSet.getString("nombre"),
                        resultSet.getString("apellidos"), resultSet.getString("correo"),
                        resultSet.getString("telefono"), resultSet.getInt("practica"),
                        resultSet.getInt("programa"), resultSet.getInt("tutor_docente"),
                        resultSet.getInt("tutor_empresa"), resultSet.getInt("empresa"));

                listaAlumnos.add(alumno);
            }

        } catch (SQLException e) {
            System.err.println("Error al leer los alumnos: " + e.getMessage());
        }

        return listaAlumnos;
    }

    /**
     * Actualiza los datos de un alumno en la base de datos. Permite modificar
     * el nombre, el programa asociado, el teléfono y el correo del alumno.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
    public static void modificarAlumno(int id_alumno, String nombre, String apellidos, String telefono,
                                String correo, int id_practica, int id_programa,
                            int id_tutordocente, int id_tutorempresa, int id_empresa) {

        String updateQuery = "UPDATE alumno SET nombre = ?, apellidos = ?, telefono = ?, correo = ?,"
                + "id_practica, id_programa, id_tutordocente, id_tutorempresa, id_empresa WHERE id_alumno = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellidos);
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, correo);
            preparedStatement.setInt(5, id_practica);
            preparedStatement.setInt(6, id_programa);
            preparedStatement.setInt(7, id_tutordocente);
            preparedStatement.setInt(8, id_tutorempresa);
            preparedStatement.setInt(9, id_empresa);
            preparedStatement.setInt(10, id_alumno);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Alumno actualizado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar el alumno: " + e.getMessage());
        }
    }

    /**
     * Elimina un alumno de la base de datos.
     * <p>
     * Este método solicita al usuario el ID del alumno a eliminar y lo utiliza
     * para ejecutar una consulta DELETE en la base de datos, eliminando el
     * registro correspondiente.
     * </p>
     *
     * @throws SQLException Si ocurre un error al intentar eliminar el alumno de
     * la base de datos.
     */
    public static void borrarAlumno(int id_alumno) {
        String deleteQuery = "DELETE FROM alumno WHERE id_alumno = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id_alumno);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Alumno eliminado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar el alumno: " + e.getMessage());
        }
    }
}
