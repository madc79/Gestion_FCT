package aed.gestion_fct.model;

import aed.gestion_fct.ConnectionPool;
import aed.gestion_fct.data.Practica;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PracticaCRUD {
    
    /**
     * Crea un nuevo registro en la tabla "practica". Solicita al usuario
     * ingresar las fechas, estado y las relaciones con otras tablas mediante
     * IDs. Valida los datos antes de insertarlos en la base de datos.
     */
    public static void crearPractica(Date fecha_inicio, Date fecha_fin, String estado, int id_alumno) {

        String insertQuery = "INSERT INTO practica (fecha_inicio, fecha_fin, estado, id_alumno) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setDate(1, fecha_inicio);
            preparedStatement.setDate(2, fecha_fin);
            preparedStatement.setString(3, estado);
            preparedStatement.setInt(4, id_alumno);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Práctica creada. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear práctica: " + e.getMessage());
        }
    }
    
    /**
     * Lee todos los registros de la tabla "practica". Muestra información
     * detallada de cada práctica, incluyendo fechas, estado y claves foráneas
     * asociadas.
     */
    public static ObservableList leerPractica() {
        String query = "SELECT * FROM practica";
        ObservableList<Practica> listaPracticas = FXCollections.observableArrayList();

        try (Connection connection = ConnectionPool.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            
            while (resultSet.next()) {
                Practica practica = new Practica(resultSet.getInt("id"), resultSet.getDate("fecha_inicio"),
                          resultSet.getDate("fecha_fin"), resultSet.getString("estado"), resultSet.getInt("id_alumno"));
                
                listaPracticas.add(practica);
            }

        } catch (SQLException e) {
            System.err.println("Error al leer las practicas: " + e.getMessage());
        }
        
        return listaPracticas;
        
    }
    
    /**
     * Actualiza los datos de una práctica en la base de datos. Permite
     * modificar las fechas, el estado, y las claves foráneas asociadas a la
     * práctica.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
    public static void modificarPractica(int id, Date fecha_inicio, Date fecha_fin, String estado, int id_alumno) {

        String updateQuery = "UPDATE practica SET fecha_inicio = ?, fecha_fin = ?, estado = ?, id_alumno = ? WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setInt(1, id);
            preparedStatement.setDate(2, fecha_inicio);
            preparedStatement.setDate(3, fecha_fin);
            preparedStatement.setString(4, estado);
            preparedStatement.setInt(5, id_alumno);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Práctica actualizada. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar práctica: " + e.getMessage());
        }
    }
    
    /**
     * Elimina una práctica de la base de datos.
     * <p>
     * Este método solicita al usuario el ID de la práctica a eliminar y lo
     * utiliza para ejecutar una consulta DELETE en la base de datos, eliminando
     * el registro correspondiente.
     * </p>
     *
     * @throws SQLException Si ocurre un error al intentar eliminar la práctica
     * de la base de datos.
     */
    public static void borrarPractica(int id) {
        String deleteQuery = "DELETE FROM practica WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Práctica eliminada. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar la práctica: " + e.getMessage());
        }
    }
    
    /**
     * Verifica si una práctica con el ID dado existe en la base de datos.
     * <p>
     * Este método realiza una consulta en la base de datos para verificar si
     * existe un registro de práctica con el ID proporcionado.
     * </p>
     *
     * @param id_asignacion El ID de la asignación de práctica a verificar.
     * @return true si la práctica con el ID existe, false en caso contrario.
     */
//    public boolean existePractica(int id_asignacion) {
//        String query = "SELECT COUNT(*) FROM practica WHERE id_asignacion = ?";
//        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setInt(1, id_asignacion);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            resultSet.next();
//            return resultSet.getInt(1) > 0;
//
//        } catch (SQLException e) {
//            System.err.println("Error al verificar el ID de la práctica: " + e.getMessage());
//            return false;
//        }
//    }
    
    /**
     * Lee el ID de una asignación de práctica proporcionado por el usuario,
     * verificando que sea válido.
     * <p>
     * Este método solicita al usuario el ID de una asignación de práctica y
     * verifica que el ID ingresado sea numérico y que exista en la base de
     * datos. Si el ID no es válido, se solicitará un nuevo ingreso.
     * </p>
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar el ID.
     * @return El ID de la asignación de práctica ingresado por el usuario.
     */
//    public int leerIdAsignacion(String mensaje) {
//        while (true) {
//            System.out.print(mensaje);
//            String entrada = sc.nextLine();  // Leer como String para validar
//            if (entrada.matches("^[0-9]+$")) {  // Verificar que solo contenga números
//                int id = Integer.parseInt(entrada);  // Convertir a entero
//                if (existePractica(id)) {
//                    return id;  // Si el ID es válido, retornamos
//                } else {
//                    System.out.println("El ID ingresado no corresponde a ninguna práctica. Intenta nuevamente.");
//                }
//            } else {
//                System.out.println("Por favor, ingresa un ID válido (solo números).");
//            }
//        }
//    }
    
}
