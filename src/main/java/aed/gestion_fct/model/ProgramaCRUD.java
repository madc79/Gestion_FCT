package aed.gestion_fct.model;

import aed.gestion_fct.ConnectionPool;
import aed.gestion_fct.data.Programa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProgramaCRUD {
    
    /**
     * Crea un nuevo registro en la tabla "programa". Solicita al usuario
     * ingresar el nombre del programa. Valida los datos antes de insertarlos en
     * la base de datos.
     */
    public static void crearPrograma(String nombre) {
        String insertQuery = "INSERT INTO programa (nombre) VALUES (?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, nombre);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Programa creado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear programa: " + e.getMessage());
        }
    }
    
    /**
     * Lee todos los registros de la tabla "programa". Muestra el ID y nombre de
     * cada programa en la base de datos.
     */
    public static ObservableList leerPrograma() {
        String query = "SELECT * FROM programa";
        ObservableList<Programa> listaProgramas = FXCollections.observableArrayList();

        try (Connection connection = ConnectionPool.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Programa programa = new Programa(resultSet.getInt("id"), resultSet.getString("nombre"));
                
                listaProgramas.add(programa);
            }

        } catch (SQLException e) {
            System.err.println("Error al leer los programas: " + e.getMessage());
        }
        
        return listaProgramas;
    }
    
    /**
     * Actualiza los datos de un programa en la base de datos. Permite modificar
     * el nombre del programa.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
    public static void modificarPrograma(int id, String nombre) {
        
        String updateQuery = "UPDATE programa SET nombre = ? WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setInt(2, id);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Programa actualizado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar el programa: " + e.getMessage());
        }
    }
    
    /**
     * Elimina un programa de la base de datos.
     * <p>
     * Este método solicita al usuario el ID del programa a eliminar y lo
     * utiliza para ejecutar una consulta DELETE en la base de datos, eliminando
     * el registro correspondiente.
     * </p>
     *
     * @throws SQLException Si ocurre un error al intentar eliminar el programa
     * de la base de datos.
     */
    public static void borrarPrograma(int id) {
        String deleteQuery = "DELETE FROM programa WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Programa eliminado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar el programa: " + e.getMessage());
        }
    }
    
    /**
     * Lee el ID de un programa proporcionado por el usuario, verificando que
     * sea válido.
     * <p>
     * Este método solicita al usuario el ID de un programa y verifica que el ID
     * ingresado sea numérico y que exista en la base de datos. Si el ID no es
     * válido, se solicitará un nuevo ingreso.
     * </p>
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar el ID.
     * @return El ID del programa ingresado por el usuario.
     */
    public int leerIdPrograma(String mensaje) {
        
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();  // Leer como String para validar
            if (entrada.matches("^[0-9]+$")) {  // Verificar que solo contenga números
                int id = Integer.parseInt(entrada);  // Convertir a entero
                if (existePrograma(id)) {
                    return id;  // Si el ID es válido, retornamos
                } else {
                    System.out.println("El ID ingresado no corresponde a ningún programa existente. Intenta nuevamente.");
                }
            } else {
                System.out.println("Por favor, ingresa un ID válido (solo números).");
            }
        }
    }
    
    /**
     * Verifica si un programa con el ID dado existe en la base de datos.
     * <p>
     * Este método realiza una consulta en la base de datos para verificar si
     * existe un registro de programa con el ID proporcionado.
     * </p>
     *
     * @param id_programa El ID del programa a verificar.
     * @return true si el programa con el ID existe, false en caso contrario.
     */
    public boolean existePrograma(int id_programa) {
        String query = "SELECT COUNT(*) FROM programa WHERE id_programa = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id_programa);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;

        } catch (SQLException e) {
            System.err.println("Error al verificar el ID del programa: " + e.getMessage());
            return false;
        }
    }
    
}
