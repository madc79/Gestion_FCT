package aed.gestion_fct.model;

import aed.gestion_fct.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TutorEmpresaCRUD {
    
    /**
     * Crea un nuevo registro en la tabla "tutorempresa". Solicita al usuario
     * ingresar el nombre, teléfono y correo. Valida los datos antes de
     * insertarlos en la base de datos.
     */
    public void crearTutorEmpresa() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        String telefono = leerEntrada("Teléfono (Solo números): ", "^[0-9 ]+$",
                "El teléfono solo puede contener números y espacios.");
        String correo = leerEntrada("Correo (Debe contener @): ", ".*@.*",
                "El correo debe contener un '@'.");

        String insertQuery = "INSERT INTO tutorempresa (nombre, telefono, correo) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, telefono);
            preparedStatement.setString(3, correo);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Tutor de empresa creado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear tutor de empresa: " + e.getMessage());
        }
    }
    
    /**
     * Lee todos los registros de la tabla "tutorempresa". Muestra el ID,
     * nombre, teléfono y correo de cada tutor de empresa en la base de datos.
     */
    public void leerTutorEmpresa() {
        String query = "SELECT * FROM tutorempresa";

        try (Connection connection = ConnectionPool.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_tutor_empresa"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Teléfono: " + resultSet.getString("telefono"));
                System.out.println("Correo: " + resultSet.getString("correo"));
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error al leer los tutores de empresa: " + e.getMessage());
        }
    }
    
    /**
     * Actualiza los datos de un tutor de empresa en la base de datos. Permite
     * modificar el nombre, el teléfono y el correo del tutor de empresa.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
    public void modificarTutorEmpresa() {
        int id_tutor_empresa = leerIdTutorEmpresa("ID del tutor de empresa a modificar: ");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        String telefono = leerEntrada("Teléfono (Solo números): ", "^[0-9 ]+$",
                "El teléfono solo puede contener números y espacios.");
        String correo = leerEntrada("Correo (Debe contener @): ", ".*@.*",
                "El correo debe contener un '@'.");

        String updateQuery = "UPDATE tutorempresa SET nombre = ?, telefono = ?, correo = ? WHERE id_tutor_empresa = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, telefono);
            preparedStatement.setString(3, correo);
            preparedStatement.setInt(4, id_tutor_empresa);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Tutor de empresa actualizado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar el tutor de empresa: " + e.getMessage());
        }
    }
    
    /**
     * Elimina un tutor de empresa de la base de datos.
     * <p>
     * Este método solicita al usuario el ID del tutor de empresa a eliminar y
     * lo utiliza para ejecutar una consulta DELETE en la base de datos,
     * eliminando el registro correspondiente.
     * </p>
     *
     * @throws SQLException Si ocurre un error al intentar eliminar el tutor de
     * empresa de la base de datos.
     */
    public void borrarTutorEmpresa() {
        int id_tutor_empresa = leerIdTutorEmpresa("ID del tutor de empresa a borrar: ");
        String deleteQuery = "DELETE FROM tutorempresa WHERE id_tutor_empresa = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id_tutor_empresa);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Tutor de empresa eliminado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar el tutor de empresa: " + e.getMessage());
        }
    }
    
    /**
     * Lee el ID de un tutor de empresa proporcionado por el usuario,
     * verificando que sea válido.
     * <p>
     * Este método solicita al usuario el ID de un tutor de empresa y verifica
     * que el ID ingresado sea numérico y que exista en la base de datos. Si el
     * ID no es válido, se solicitará un nuevo ingreso.
     * </p>
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar el ID.
     * @return El ID del tutor de empresa ingresado por el usuario.
     */
    public int leerIdTutorEmpresa(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();  // Leer como String para validar
            if (entrada.matches("^[0-9]+$")) {  // Verificar que solo contenga números
                int id = Integer.parseInt(entrada);  // Convertir a entero
                if (existeTutorEmpresa(id)) {
                    return id;  // Si el ID es válido, retornamos
                } else {
                    System.out.println("El ID ingresado no corresponde a ningún tutor de empresa. Intenta nuevamente.");
                }
            } else {
                System.out.println("Por favor, ingresa un ID válido (solo números).");
            }
        }
    }
    
    /**
     * Verifica si un tutor de empresa con el ID dado existe en la base de
     * datos.
     * <p>
     * Este método realiza una consulta en la base de datos para verificar si
     * existe un registro de tutor de empresa con el ID proporcionado.
     * </p>
     *
     * @param id_tutor_empresa El ID del tutor de empresa a verificar.
     * @return true si el tutor de empresa con el ID existe, false en caso
     * contrario.
     */
    public boolean existeTutorEmpresa(int id_tutor_empresa) {
        String query = "SELECT COUNT(*) FROM tutorempresa WHERE id_tutor_empresa = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id_tutor_empresa);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;

        } catch (SQLException e) {
            System.err.println("Error al verificar el ID del tutor de empresa: " + e.getMessage());
            return false;
        }
    }
    
}
