package aed.gestion_fct.model;

import aed.gestion_fct.ConnectionPool;
import aed.gestion_fct.data.Visita;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VisitaCRUD {
    
    /**
     * Crea un nuevo registro en la tabla "visita". Solicita al usuario ingresar
     * la fecha, observaciones y el ID de asignación. Valida los datos antes de
     * insertarlos en la base de datos.
     */
    public static void crearVisita(Date fecha, String observaciones, int id_tutordocente, int id_alumno) {
        String insertQuery = "INSERT INTO visita (fecha, observaciones, id_tutordocente, id_alumno) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setDate(1, fecha);
            preparedStatement.setString(2, observaciones);
            preparedStatement.setInt(3, id_tutordocente);
            preparedStatement.setInt(4, id_alumno);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Visita creada. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear visita: " + e.getMessage());
        }
    }
    
    /**
     * Lee todos los registros de la tabla "visita". Muestra el ID, fecha,
     * observaciones y práctica asociada de cada visita en la base de datos.
     */
    public static ObservableList leerVisita() {
        String query = "SELECT * FROM visita";
        ObservableList<Visita> listaVisitas = FXCollections.observableArrayList();

        try (Connection connection = ConnectionPool.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Visita visita = new Visita(resultSet.getInt("id"), resultSet.getDate("fecha"), resultSet.getString("observaciones"),
                resultSet.getInt("id_tutordocente"), resultSet.getInt("id_alumno"));
                
                listaVisitas.add(visita);
            }

        } catch (SQLException e) {
            System.err.println("Error al leer las visitas: " + e.getMessage());
        }
        
        return listaVisitas;
    }
    
    /**
     * Actualiza los datos de una visita en la base de datos. Permite modificar
     * la fecha, las observaciones y la práctica asociada a la visita.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
    public static void modificarVisita(int id, Date fecha, String observaciones, int id_tutordocente, int id_alumno) {
        String updateQuery = "UPDATE visita SET fecha = ?, observaciones = ?, id_tutordocente, id_alumno = ? WHERE id_visita = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setDate(1, fecha);
            preparedStatement.setString(2, observaciones);
            preparedStatement.setInt(3, id_tutordocente);
            preparedStatement.setInt(4, id_alumno);
            preparedStatement.setInt(5, id);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Visita actualizada. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar visita: " + e.getMessage());
        }
    }
    
    /**
     * Elimina una visita de la base de datos.
     * <p>
     * Este método solicita al usuario el ID de la visita a eliminar y lo
     * utiliza para ejecutar una consulta DELETE en la base de datos, eliminando
     * el registro correspondiente.
     * </p>
     *
     * @throws SQLException Si ocurre un error al intentar eliminar la visita de
     * la base de datos.
     */
    public static void borrarVisita(int id) {
        String deleteQuery = "DELETE FROM visita WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Visita eliminada. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar la visita: " + e.getMessage());
        }
    }
    
    /**
     * Lee el ID de una visita proporcionado por el usuario, verificando que sea
     * válido.
     * <p>
     * Este método solicita al usuario el ID de una visita y verifica que el ID
     * ingresado sea numérico y que exista en la base de datos. Si el ID no es
     * válido, se solicitará un nuevo ingreso.
     * </p>
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar el ID.
     * @return El ID de la visita ingresado por el usuario.
     */
    public int leerIdVisita(String mensaje) {
        
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();  // Leer como String para validar
            if (entrada.matches("^[0-9]+$")) {  // Verificar que solo contenga números
                int id = Integer.parseInt(entrada);  // Convertir a entero
                if (existeVisita(id)) {
                    return id;  // Si el ID es válido, retornamos
                } else {
                    System.out.println("El ID ingresado no corresponde a ninguna visita. Intenta nuevamente.");
                }
            } else {
                System.out.println("Por favor, ingresa un ID válido (solo números).");
            }
        }
    }
    
    /**
     * Verifica si una visita con el ID dado existe en la base de datos.
     * <p>
     * Este método realiza una consulta en la base de datos para verificar si
     * existe un registro de visita con el ID proporcionado.
     * </p>
     *
     * @param id_visita El ID de la visita a verificar.
     * @return true si la visita con el ID existe, false en caso contrario.
     */
    public boolean existeVisita(int id_visita) {
        String query = "SELECT COUNT(*) FROM visita WHERE id_visita = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id_visita);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;

        } catch (SQLException e) {
            System.err.println("Error al verificar el ID de la visita: " + e.getMessage());
            return false;
        }
    }    
}
