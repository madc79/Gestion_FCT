package aed.gestion_fct;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Esta clase gestiona un pool de conexiones utilizando HikariCP para manejar conexiones 
 * a la base de datos MySQL de manera eficiente.
 * 
 * El pool de conexiones permite reutilizar conexiones a la base de datos en lugar de 
 * crear una nueva conexión cada vez que se necesita, lo que mejora el rendimiento y 
 * reduce la carga sobre la base de datos.
 */
public class ConnectionPool {
    // Variable estática que mantiene la fuente de datos del pool
    private static HikariDataSource dataSource;

    /**
     * Bloque estático que inicializa la configuración del pool de conexiones.
     * Configura el JDBC URL, el usuario, la contraseña, y otros parámetros del pool.
     */
    static {
        // Configuración de HikariCP
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/fct_gestion"); // URL de la base de datos
        config.setUsername("root"); // Nombre de usuario para la base de datos
        config.setPassword(""); // Contraseña para la base de datos
        config.setMaximumPoolSize(10); // Tamaño máximo del pool de conexiones
        config.setMinimumIdle(2); // Número mínimo de conexiones inactivas que deben mantenerse
        config.setConnectionTimeout(30000); // Tiempo máximo de espera para obtener una conexión (30 segundos)
        config.setIdleTimeout(600000); // Tiempo máximo de inactividad de una conexión (10 minutos)
        config.setMaxLifetime(1800000); // Vida útil máxima de una conexión (30 minutos)

        // Inicialización del pool de conexiones
        dataSource = new HikariDataSource(config);
    }

    /**
     * Obtiene una conexión del pool de conexiones.
     * 
     * @return una conexión a la base de datos.
     * @throws SQLException si ocurre un error al obtener la conexión.
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * Cierra el pool de conexiones y libera todos los recursos asociados.
     * Este método debería ser llamado al final de la aplicación para liberar los recursos
     * de manera adecuada.
     */
    public static void close() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}
