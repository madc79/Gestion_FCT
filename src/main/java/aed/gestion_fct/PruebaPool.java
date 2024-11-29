package aed.gestion_fct;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Clase de prueba para verificar el funcionamiento del {@link ConnectionPool}.
 * Esta clase intenta obtener una conexión a la base de datos utilizando el pool
 * de conexiones y muestra un mensaje de éxito si la conexión es exitosa.
 * 
 * <p>Este es un archivo de prueba utilizado para comprobar la conexión con la base de datos,
 * no se debe usar en un entorno de producción.</p>
 */
public class PruebaPool {

    /**
     * Método principal que prueba la obtención de una conexión a la base de datos
     * a través del {@link ConnectionPool}.
     * 
     * <p>Si la conexión se establece correctamente, se imprime un mensaje de éxito.
     * Si ocurre un error durante la conexión, se captura la excepción {@link SQLException}
     * y se imprime el detalle del error.</p>
     * 
     * @param args los argumentos pasados al programa (no utilizados en este caso).
     */
    public static void main(String[] args) {
        try (Connection connection = ConnectionPool.getConnection()) {
            System.out.println("Conexión establecida con éxito");
            // Realiza tus operaciones con la base de datos
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierra el pool de conexiones al finalizar la prueba
            ConnectionPool.close();
        }
    }
}
