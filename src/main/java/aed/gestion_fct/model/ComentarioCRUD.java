package aed.gestion_fct.model;

import aed.gestion_fct.data.Comentario;
import aed.gestion_fct.ConnectionPool;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ComentarioCRUD {
    
    /**
     * Crea un nuevo registro en la tabla "comentario". Solicita al usuario
     * ingresar la fecha, detalle y el ID de la empresa. Valida los datos antes
     * de insertarlos en la base de datos.
     */
    public static void crearComentario(Date fecha, String detalle, int id_tutorempresa, int id_alumno) {

        String insertQuery = "INSERT INTO comentario (fecha, detalle, id_tutorempresa, id_alumno) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setDate(1, fecha);
            preparedStatement.setString(2, detalle);
            preparedStatement.setInt(3, id_tutorempresa);
            preparedStatement.setInt(4, id_alumno);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Comentario creado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear comentario: " + e.getMessage());
        }
    }
    
    /**
     * Lee todos los registros de la tabla "comentario". Muestra el ID, fecha,
     * detalle e ID de la empresa asociada a cada comentario.
     */
    public static ObservableList leerComentario() {
        String query = "SELECT * FROM comentario";
        ObservableList<Comentario> listaComentarios = FXCollections.observableArrayList();

        try (Connection connection = ConnectionPool.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Comentario comentario = new Comentario(resultSet.getInt("id"), resultSet.getDate("fecha"),
                    resultSet.getString("detalle"), resultSet.getInt("id_tutorempresa"), resultSet.getInt("id_alumno"));                
                listaComentarios.add(comentario);
            }

        } catch (SQLException e) {
            System.err.println("Error al leer los comentarios: " + e.getMessage());
        }
        
        return listaComentarios;
                
    }
    
    /**
     * Actualiza los datos de un comentario en la base de datos. Permite
     * modificar la fecha, el detalle y la empresa asociada al comentario.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
    public static void modificarComentario(int id, Date fecha, String detalle, int id_tutorempresa, int id_alumno) {
        
        String updateQuery = "UPDATE comentario SET fecha = ?, detalle = ?, id_tutorempresa = ?, id_alumno = ? WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setDate(1, fecha);
            preparedStatement.setString(2, detalle);
            preparedStatement.setInt(3, id_tutorempresa);
            preparedStatement.setInt(4, id_alumno);
            preparedStatement.setInt(5, id);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Comentario actualizado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar el comentario: " + e.getMessage());
        }
    }
    
    /**
     * Elimina un comentario de la base de datos.
     * <p>
     * Este método solicita al usuario el ID del comentario a eliminar y lo
     * utiliza para ejecutar una consulta DELETE en la base de datos, eliminando
     * el registro correspondiente.
     * </p>
     *
     * @throws SQLException Si ocurre un error al intentar eliminar el
     * comentario de la base de datos.
     */
    public static void borrarComentario(int id) {
        String deleteQuery = "DELETE FROM comentario WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Comentario eliminado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar el comentario: " + e.getMessage());
        }
    }
    
    /**
     * Lee el ID de un comentario proporcionado por el usuario, verificando que
     * sea válido.
     * <p>
     * Este método solicita al usuario el ID de un comentario y verifica que el
     * ID ingresado sea numérico y que exista en la base de datos. Si el ID no
     * es válido, se solicitará un nuevo ingreso.
     * </p>
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar el ID.
     * @return El ID del comentario ingresado por el usuario.
     */
    public int leerIdComentario(String mensaje) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();  // Leer como String para validar
            if (entrada.matches("^[0-9]+$")) {  // Verificar que solo contenga números
                int id = Integer.parseInt(entrada);  // Convertir a entero
                if (existeComentario(id)) {
                    return id;  // Si el ID es válido, retornamos
                } else {
                    System.out.println("El ID ingresado no corresponde a ningún comentario. Intenta nuevamente.");
                }
            } else {
                System.out.println("Por favor, ingresa un ID válido (solo números).");
            }
        }
    }
    
    /**
     * Verifica si un comentario con el ID dado existe en la base de datos.
     * <p>
     * Este método realiza una consulta en la base de datos para verificar si
     * existe un registro de comentario con el ID proporcionado.
     * </p>
     *
     * @param id_comentario El ID del comentario a verificar.
     * @return true si el comentario con el ID existe, false en caso contrario.
     */
    public boolean existeComentario(int id_comentario) {
        String query = "SELECT COUNT(*) FROM comentario WHERE id_comentario = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id_comentario);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;

        } catch (SQLException e) {
            System.err.println("Error al verificar el ID del comentario: " + e.getMessage());
            return false;
        }
    }
    
}
