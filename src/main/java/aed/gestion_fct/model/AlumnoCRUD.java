
package aed.gestion_fct.model;

import aed.gestion_fct.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlumnoCRUD {
    
    /**
     * Crea un nuevo registro en la tabla "alumno". Solicita al usuario ingresar
     * los datos necesarios: nombre, teléfono, correo e ID del programa. Valida
     * los datos antes de insertarlos en la base de datos.
     */
    public void crearAlumno() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.println();
        System.out.println("Programas disponibles:");
        System.out.println();

        leerPrograma(); // Muestra los programas disponibles
        int id_programa = leerIdPrograma("ID del programa: "); // Verifica la validez del ID

        String telefono = leerEntrada("Teléfono (Solo números): ", "^[0-9 ]+$",
                "El teléfono solo puede contener números y espacios.");
        String correo = leerEntrada("Correo (Debe contener @): ", ".*@.*",
                "El correo debe contener un '@'.");

        String insertQuery = "INSERT INTO alumno (nombre, id_programa, telefono, correo) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setInt(2, id_programa); // Inserta el ID del programa
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, correo);

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
    public void leerAlumno() {
        String query = "SELECT * FROM alumno";

        try (Connection connection = ConnectionPool.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_alumno"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Programa: " + resultSet.getString("id_programa"));
                System.out.println("Teléfono: " + resultSet.getString("telefono"));
                System.out.println("Correo: " + resultSet.getString("correo"));
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error al leer los alumnos: " + e.getMessage());
        }
    }
    
    /**
     * Actualiza los datos de un alumno en la base de datos. Permite modificar
     * el nombre, el programa asociado, el teléfono y el correo del alumno.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
    public void modificarAlumno() {
        int id_alumno = leerIdAlumno("ID del alumno a modificar: ");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.println();
        System.out.println("Programas disponibles:");
        System.out.println();

        leerPrograma();
        int id_programa = leerIdPrograma("Nuevo ID del programa: ");

        String telefono = leerEntrada("Teléfono (Solo números): ", "^[0-9 ]+$",
                "El teléfono solo puede contener números y espacios.");
        String correo = leerEntrada("Correo (Debe contener @): ", ".*@.*",
                "El correo debe contener un '@'.");

        String updateQuery = "UPDATE alumno SET nombre = ?, id_programa = ?, telefono = ?, correo = ? WHERE id_alumno = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setInt(2, id_programa);
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, correo);
            preparedStatement.setInt(5, id_alumno);

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
    public void borrarAlumno() {
        int id_alumno = leerIdAlumno("ID del alumno a borrar: ");
        String deleteQuery = "DELETE FROM alumno WHERE id_alumno = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id_alumno);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Alumno eliminado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar el alumno: " + e.getMessage());
        }
    }
    
    /**
     * Lee el ID de un alumno proporcionado por el usuario, verificando que sea
     * válido.
     * <p>
     * Este método solicita al usuario el ID de un alumno y verifica que el ID
     * ingresado sea numérico y que exista en la base de datos. Si el ID no es
     * válido, se solicitará un nuevo ingreso.
     * </p>
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar el ID.
     * @return El ID del alumno ingresado por el usuario.
     */
    public int leerIdAlumno(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();  // Leer como String para validar
            if (entrada.matches("^[0-9]+$")) {  // Verificar que solo contenga números
                int id = Integer.parseInt(entrada);  // Convertir a entero
                if (existeAlumno(id)) {
                    return id;  // Si el ID es válido, retornamos
                } else {
                    System.out.println("El ID ingresado no corresponde a ningún alumno. Intenta nuevamente.");
                }
            } else {
                System.out.println("Por favor, ingresa un ID válido (solo números).");
            }
        }
    }
    
    /**
     * Verifica si un alumno con el ID dado existe en la base de datos.
     * <p>
     * Este método realiza una consulta en la base de datos para verificar si
     * existe un registro de alumno con el ID proporcionado.
     * </p>
     *
     * @param id_alumno El ID del alumno a verificar.
     * @return true si el alumno con el ID existe, false en caso contrario.
     */
    public boolean existeAlumno(int id_alumno) {
        String query = "SELECT COUNT(*) FROM alumno WHERE id_alumno = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id_alumno);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;

        } catch (SQLException e) {
            System.err.println("Error al verificar el ID del alumno: " + e.getMessage());
            return false;
        }
    }
    
}
