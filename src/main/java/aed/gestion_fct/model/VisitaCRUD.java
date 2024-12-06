package aed.gestion_fct.model;

import aed.gestion_fct.ConnectionPool;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VisitaCRUD {
    
    /**
     * Crea un nuevo registro en la tabla "visita". Solicita al usuario ingresar
     * la fecha, observaciones y el ID de asignación. Valida los datos antes de
     * insertarlos en la base de datos.
     */
    public void crearVisita() {
        String fecha = leerEntrada("Fecha (dd/MM/yyyy): ",
                "\\d{2}/\\d{2}/\\d{4}",
                "La fecha debe estar en formato dd/MM/yyyy.");
        Date fechaConversa = leerFecha(fecha);

        System.out.println("Introduzca observación en caso de haberla: ");
        String observaciones = sc.nextLine();
        int id_asignacion = leerIdAsignacion("Introduzca el ID de la práctica: ");

        String insertQuery = "INSERT INTO visita (fecha, observaciones, id_asignacion) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setDate(1, fechaConversa);
            preparedStatement.setString(2, observaciones);
            preparedStatement.setInt(3, id_asignacion);

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
    public void leerVisita() {
        String query = "SELECT * FROM visita";

        try (Connection connection = ConnectionPool.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_visita"));
                System.out.println("Fecha: " + resultSet.getDate("fecha"));
                System.out.println("Observaciones: " + resultSet.getString("observaciones"));
                System.out.println("Práctica: " + resultSet.getInt("id_asignacion"));
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error al leer las visitas: " + e.getMessage());
        }
    }
    
    /**
     * Actualiza los datos de una visita en la base de datos. Permite modificar
     * la fecha, las observaciones y la práctica asociada a la visita.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
    public void modificarVisita() {
        int id_visita = leerIdVisita("ID de la visita a modificar: ");

        String fecha = leerEntrada("Fecha (dd/MM/yyyy): ", "\\d{2}/\\d{2}/\\d{4}",
                "La fecha debe estar en formato dd/MM/yyyy.");
        System.out.println("Introduzca observación en caso de haberla:");
        String observaciones = sc.nextLine();

        System.out.println("Prácticas disponibles:");
        leerPractica();
        int id_asignacion = leerIdAsignacion("ID de la práctica: ");

        Date fechaConversa = leerFecha(fecha);

        String updateQuery = "UPDATE visita SET fecha = ?, observaciones = ?, id_asignacion = ? WHERE id_visita = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setDate(1, fechaConversa);
            preparedStatement.setString(2, observaciones);
            preparedStatement.setInt(3, id_asignacion);
            preparedStatement.setInt(4, id_visita);

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
    public void borrarVisita() {
        int id_visita = leerIdVisita("ID de la visita a borrar: ");
        String deleteQuery = "DELETE FROM visita WHERE id_visita = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id_visita);
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
