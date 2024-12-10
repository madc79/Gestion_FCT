package aed.gestion_fct.model;

import aed.gestion_fct.ConnectionPool;
import aed.gestion_fct.data.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmpresaCRUD {
    
    /**
     * Crea un nuevo registro en la tabla "empresa". Solicita al usuario
     * ingresar los datos necesarios: nombre, dirección, teléfono y correo.
     * Valida los datos antes de insertarlos en la base de datos.
     */
    public static void crearEmpresa(String nombre, String correo, String direccion, String telefono, int plazas) {
        
        String insertQuery = "INSERT INTO empresa (nombre, correo, direccion, telefono, plazas) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, correo);
            preparedStatement.setString(3, direccion);
            preparedStatement.setString(4, telefono);
            preparedStatement.setInt(5, plazas);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Empresa creada. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear empresa: " + e.getMessage());
        }
    }
    
    /**
     * Lee todos los registros de la tabla "empresa". Muestra el ID, nombre,
     * dirección, teléfono y correo de cada empresa en la base de datos.
     */
    public static ObservableList leerEmpresa() {
        String query = "SELECT * FROM empresa";
        ObservableList<Empresa> listaEmpresas = FXCollections.observableArrayList();

        try (Connection connection = ConnectionPool.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Empresa empresa = new Empresa(resultSet.getInt("id_empresa"), resultSet.getString("nombre"), resultSet.getString("correo"),
                    resultSet.getString("direccion"), resultSet.getString("telefono"), resultSet.getInt("plazas"));
                
                listaEmpresas.add(empresa);
            }

        } catch (SQLException e) {
            System.err.println("Error al leer las empresas: " + e.getMessage());
        }
        
        return listaEmpresas;
    }
    
    /**
     * Actualiza los datos de una empresa en la base de datos. Permite modificar
     * el nombre, la dirección, el teléfono y el correo de la empresa.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
    public static void modificarEmpresa(int id_empresa, String nombre, String correo, String direccion, String telefono, int plazas) {

        String updateQuery = "UPDATE empresa SET nombre = ?, correo = ?, direccion = ?, telefono = ?, plazas = ? WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, correo);
            preparedStatement.setString(3, direccion);
            preparedStatement.setString(4, telefono);
            preparedStatement.setInt(5, plazas);
            preparedStatement.setInt(6, id_empresa);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Empresa actualizada. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar la empresa: " + e.getMessage());
        }
    }
    
    /**
     * Elimina una empresa de la base de datos.
     * <p>
     * Este método solicita al usuario el ID de la empresa a eliminar y lo
     * utiliza para ejecutar una consulta DELETE en la base de datos, eliminando
     * el registro correspondiente.
     * </p>
     *
     * @throws SQLException Si ocurre un error al intentar eliminar la empresa
     * de la base de datos.
     */
    public static void borrarEmpresa(int id) {
        String deleteQuery = "DELETE FROM empresa WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Empresa eliminada. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar la empresa: " + e.getMessage());
        }
    }
    
    /**
     * Lee el ID de una empresa proporcionado por el usuario, verificando que
     * sea válido.
     * <p>
     * Este método solicita al usuario el ID de una empresa y verifica que el ID
     * ingresado sea numérico y que exista en la base de datos. Si el ID no es
     * válido, se solicitará un nuevo ingreso.
     * </p>
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar el ID.
     * @return El ID de la empresa ingresado por el usuario.
     */
    public int leerIdEmpresa(String mensaje) {
        
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();  // Leer como String para validar
            if (entrada.matches("^[0-9]+$")) {  // Verificar que solo contenga números
                int id = Integer.parseInt(entrada);  // Convertir a entero
                if (existeEmpresa(id)) {
                    return id;  // Si el ID es válido, retornamos
                } else {
                    System.out.println("El ID ingresado no corresponde a ninguna empresa. Intenta nuevamente.");
                }
            } else {
                System.out.println("Por favor, ingresa un ID válido (solo números).");
            }
        }
    }
    
    /**
     * Verifica si una empresa con el ID dado existe en la base de datos.
     * <p>
     * Este método realiza una consulta en la base de datos para verificar si
     * existe un registro de empresa con el ID proporcionado.
     * </p>
     *
     * @param id_empresa El ID de la empresa a verificar.
     * @return true si la empresa con el ID existe, false en caso contrario.
     */
    public boolean existeEmpresa(int id_empresa) {
        String query = "SELECT COUNT(*) FROM empresa WHERE id_empresa = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id_empresa);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;

        } catch (SQLException e) {
            System.err.println("Error al verificar el ID de la empresa: " + e.getMessage());
            return false;
        }
    }
    
}
