package aed.gestion_fct;

import java.sql.Connection;
import java.sql.SQLException;

public class PruebaPool {

    public static void main(String[] args) {
        try (Connection connection = ConnectionPool.getConnection()) {
            System.out.println("Conexión establecida con éxito");
            // Realiza tus operaciones con la base de datos
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.close();
        }
    }
}
