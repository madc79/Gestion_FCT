package aed.gestion_fct.model;

import aed.gestion_fct.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TutorDocenteCRUD {
    
    /**
     * Crea un nuevo registro en la tabla "tutordocente". Solicita al usuario
     * ingresar el nombre, teléfono y correo. Valida los datos antes de
     * insertarlos en la base de datos.
     */
    public void crearTutorDocente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        String telefono = leerEntrada("Teléfono (Solo números): ", "^[0-9 ]+$",
                "El teléfono solo puede contener números y espacios.");
        String correo = leerEntrada("Correo (Debe contener @): ", ".*@.*",
                "El correo debe contener un '@'.");

        String insertQuery = "INSERT INTO tutordocente (nombre, telefono, correo) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, telefono);
            preparedStatement.setString(3, correo);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Tutor Docente creado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear Tutor Docente: " + e.getMessage());
        }
    }
    
    /**
     * Lee todos los registros de la tabla "tutordocente". Muestra el ID,
     * nombre, teléfono y correo de cada tutor docente en la base de datos.
     */
    public void leerTutorDocente() {
        String query = "SELECT * FROM tutordocente";

        try (Connection connection = ConnectionPool.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_tutor_docente"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Teléfono: " + resultSet.getString("telefono"));
                System.out.println("Correo: " + resultSet.getString("correo"));
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error al leer los Tutores Docentes: " + e.getMessage());
        }
    }
    
    /**
     * Actualiza los datos de un tutor docente en la base de datos. Permite
     * modificar el nombre, el teléfono y el correo del tutor docente.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
    public void modificarTutorDocente() {
        int id_tutor_docente = leerIdTutorDocente("ID del Tutor Docente a modificar: ");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        String telefono = leerEntrada("Teléfono (Solo números): ", "^[0-9 ]+$",
                "El teléfono solo puede contener números y espacios.");
        String correo = leerEntrada("Correo (Debe contener @): ", ".*@.*",
                "El correo debe contener un '@'.");

        String updateQuery = "UPDATE tutordocente SET nombre = ?, telefono = ?, correo = ? WHERE id_tutor_docente = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, telefono);
            preparedStatement.setString(3, correo);
            preparedStatement.setInt(4, id_tutor_docente);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Tutor Docente actualizado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar el Tutor Docente: " + e.getMessage());
        }
    }
    
    /**
     * Elimina un tutor docente de la base de datos.
     * <p>
     * Este método solicita al usuario el ID del tutor docente a eliminar y lo
     * utiliza para ejecutar una consulta DELETE en la base de datos, eliminando
     * el registro correspondiente.
     * </p>
     *
     * @throws SQLException Si ocurre un error al intentar eliminar el tutor
     * docente de la base de datos.
     */
    public void borrarTutorDocente() {
        int id_tutor_docente = leerIdTutorDocente("ID del Tutor Docente a borrar: ");
        String deleteQuery = "DELETE FROM tutordocente WHERE id_tutor_docente = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id_tutor_docente);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Tutor Docente eliminado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar el Tutor Docente: " + e.getMessage());
        }
    }
    
    /**
     * Lee el ID de un tutor docente proporcionado por el usuario, verificando
     * que sea válido.
     * <p>
     * Este método solicita al usuario el ID de un tutor docente y verifica que
     * el ID ingresado sea numérico y que exista en la base de datos. Si el ID
     * no es válido, se solicitará un nuevo ingreso.
     * </p>
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar el ID.
     * @return El ID del tutor docente ingresado por el usuario.
     */
    public int leerIdTutorDocente(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();
            if (entrada.matches("^[0-9]+$")) {
                int id = Integer.parseInt(entrada);
                if (existeTutorDocente(id)) {
                    return id;
                } else {
                    System.out.println("El ID ingresado no corresponde a ningún Tutor Docente. Intenta nuevamente.");
                }
            } else {
                System.out.println("Por favor, ingresa un ID válido (solo números).");
            }
        }
    }
    
    /**
     * Verifica si un tutor docente con el ID dado existe en la base de datos.
     * <p>
     * Este método realiza una consulta en la base de datos para verificar si
     * existe un registro de tutor docente con el ID proporcionado.
     * </p>
     *
     * @param id_tutor_docente El ID del tutor docente a verificar.
     * @return true si el tutor docente con el ID existe, false en caso
     * contrario.
     */
    public boolean existeTutorDocente(int id_tutor_docente) {
        String query = "SELECT COUNT(*) FROM tutordocente WHERE id_tutor_docente = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id_tutor_docente);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;

        } catch (SQLException e) {
            System.err.println("Error al verificar el ID del Tutor Docente: " + e.getMessage());
            return false;
        }
    }
    
}
