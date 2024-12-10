package aed.gestion_fct.model;

import aed.gestion_fct.ConnectionPool;
import aed.gestion_fct.data.TutorEmpresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TutorEmpresaCRUD {
    
    /**
     * Crea un nuevo registro en la tabla "tutorempresa". Solicita al usuario
     * ingresar el nombre, teléfono y correo. Valida los datos antes de
     * insertarlos en la base de datos.
     */
    public static void crearTutorEmpresa(String nombre, String apellidos, String telefono, String correo, int id_empresa) {
        String insertQuery = "INSERT INTO tutorempresa (nombre, apellidos, telefono, correo, id_empresa) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellidos);
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, correo);
            preparedStatement.setInt(5, id_empresa);
            

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
    public static ObservableList leerTutorEmpresa() {
        String query = "SELECT * FROM tutorempresa";
        ObservableList<TutorEmpresa> listaTutoresEmpresa = FXCollections.observableArrayList();

        try (Connection connection = ConnectionPool.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                TutorEmpresa tutorEmpresa = new TutorEmpresa(resultSet.getInt("id"), resultSet.getString("nombre"), resultSet.getString("apellidos"),
                resultSet.getString("telefono"), resultSet.getString("correo"), resultSet.getInt("id_empresa"));
                
                listaTutoresEmpresa.add(tutorEmpresa);
            }

        } catch (SQLException e) {
            System.err.println("Error al leer los tutores de empresa: " + e.getMessage());
        }
        
        return listaTutoresEmpresa;
    }
    
    /**
     * Actualiza los datos de un tutor de empresa en la base de datos. Permite
     * modificar el nombre, el teléfono y el correo del tutor de empresa.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
    public static void modificarTutorEmpresa(int id, String nombre, String apellidos, String telefono, String correo, int id_empresa) {
        String updateQuery = "UPDATE tutorempresa SET nombre = ?, apellidos = ?, telefono = ?, correo = ?, id_empresa = ? WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellidos);
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, correo);
            preparedStatement.setInt(5, id_empresa);

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
    public static void borrarTutorEmpresa(int id) {
        String deleteQuery = "DELETE FROM tutorempresa WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id);
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
        
        Scanner sc = new Scanner(System.in);
        
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
