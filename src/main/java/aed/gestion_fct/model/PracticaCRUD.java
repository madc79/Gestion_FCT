package aed.gestion_fct.model;

import aed.gestion_fct.ConnectionPool;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PracticaCRUD {
    
    /**
     * Crea un nuevo registro en la tabla "practica". Solicita al usuario
     * ingresar las fechas, estado y las relaciones con otras tablas mediante
     * IDs. Valida los datos antes de insertarlos en la base de datos.
     */
    public void crearPractica() {
        String fechaInicio = leerEntrada("Fecha inicio (dd/MM/yyyy): ",
                "\\d{2}/\\d{2}/\\d{4}",
                "La fecha debe estar en formato dd/MM/yyyy.");
        Date fechaInicioConversa = leerFecha(fechaInicio);
        String fechaFin = leerEntrada("Fecha fin (dd/MM/yyyy): ",
                "\\d{2}/\\d{2}/\\d{4}",
                "La fecha debe estar en formato dd/MM/yyyy.");
        Date fechaFinConversa = leerFecha(fechaFin);

        System.out.println("Estado de la práctica: ");
        String estado = sc.nextLine();

        System.out.println();
        System.out.println("Alumnos disponibles: ");
        System.out.println();

        leerAlumno();
        int id_alumno = leerIdAlumno("ID del alumno: ");

        System.out.println();
        System.out.println("Empresas disponibles:");
        System.out.println();

        leerEmpresa();
        int id_empresa = leerIdEmpresa("ID de la empresa: ");

        System.out.println();
        System.out.println("Tutores docentes disponibles:");
        System.out.println();

        leerTutorDocente();
        int id_tutor_docente = leerIdTutorDocente("ID del tutor docente: ");

        System.out.println();
        System.out.println("Tutores de empresa disponibles:");
        System.out.println();

        leerTutorEmpresa();
        int id_tutor_empresa = leerIdTutorEmpresa("ID del tutor de la empresa: ");

        String insertQuery = "INSERT INTO practica (fecha_inicio, fecha_fin, estado, id_alumno, id_empresa, id_tutor_docente, id_tutor_empresa) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setDate(1, fechaInicioConversa);
            preparedStatement.setDate(2, fechaFinConversa);
            preparedStatement.setString(3, estado);
            preparedStatement.setInt(4, id_alumno);
            preparedStatement.setInt(5, id_empresa);
            preparedStatement.setInt(6, id_tutor_docente);
            preparedStatement.setInt(7, id_tutor_empresa);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Práctica creada. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear práctica: " + e.getMessage());
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
     * Lee todos los registros de la tabla "practica". Muestra información
     * detallada de cada práctica, incluyendo fechas, estado y claves foráneas
     * asociadas.
     */
    public void leerPractica() {
        String query = "SELECT * FROM practica";

        try (Connection connection = ConnectionPool.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("ID asignacion: " + resultSet.getInt("id_asignacion"));
                System.out.println("Fecha inicio: " + resultSet.getDate("fecha_inicio"));
                System.out.println("Fecha fin: " + resultSet.getDate("fecha_fin"));
                System.out.println("Estado: " + resultSet.getString("estado"));
                System.out.println("ID del alumno: " + resultSet.getInt("id_alumno"));
                System.out.println("ID de la empresa: " + resultSet.getInt("id_empresa"));
                System.out.println("ID del tutor docente: " + resultSet.getInt("id_tutor_docente"));
                System.out.println("ID del tutor de la empresa: " + resultSet.getInt("id_tutor_empresa"));
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error al leer las practicas: " + e.getMessage());
        }
    }
    
    /**
     * Actualiza los datos de una práctica en la base de datos. Permite
     * modificar las fechas, el estado, y las claves foráneas asociadas a la
     * práctica.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
    public void modificarPractica() {
        int id_asignacion = leerIdAsignacion("ID de la práctica a modificar: ");

        String fechaInicio = leerEntrada("Fecha inicio (dd/MM/yyyy): ", "\\d{2}/\\d{2}/\\d{4}",
                "La fecha debe estar en formato dd/MM/yyyy.");
        String fechaFin = leerEntrada("Fecha fin (dd/MM/yyyy): ", "\\d{2}/\\d{2}/\\d{4}",
                "La fecha debe estar en formato dd/MM/yyyy.");

        System.out.print("Estado de la práctica: ");
        String estado = sc.nextLine();

        System.out.println("Alumnos disponibles:");
        leerAlumno();
        int id_alumno = leerIdAlumno("ID del alumno: ");

        System.out.println("Empresas disponibles:");
        leerEmpresa();
        int id_empresa = leerIdEmpresa("ID de la empresa: ");

        System.out.println("Tutores docentes disponibles:");
        leerTutorDocente();
        int id_tutor_docente = leerIdTutorDocente("ID del tutor docente: ");

        System.out.println("Tutores de empresa disponibles:");
        leerTutorEmpresa();
        int id_tutor_empresa = leerIdTutorEmpresa("ID del tutor de la empresa: ");

        Date fechaInicioConversa = leerFecha(fechaInicio);
        Date fechaFinConversa = leerFecha(fechaFin);

        String updateQuery = "UPDATE practica SET fecha_inicio = ?, fecha_fin = ?, estado = ?, id_alumno = ?, id_empresa = ?, id_tutor_docente = ?, id_tutor_empresa = ? WHERE id_asignacion = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setDate(1, fechaInicioConversa);
            preparedStatement.setDate(2, fechaFinConversa);
            preparedStatement.setString(3, estado);
            preparedStatement.setInt(4, id_alumno);
            preparedStatement.setInt(5, id_empresa);
            preparedStatement.setInt(6, id_tutor_docente);
            preparedStatement.setInt(7, id_tutor_empresa);
            preparedStatement.setInt(8, id_asignacion);

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
    public void borrarPractica() {
        int id_asignacion = leerIdAsignacion("ID de la práctica a borrar: ");
        String deleteQuery = "DELETE FROM practica WHERE id_asignacion = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id_asignacion);
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
    public boolean existePractica(int id_asignacion) {
        String query = "SELECT COUNT(*) FROM practica WHERE id_asignacion = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id_asignacion);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;

        } catch (SQLException e) {
            System.err.println("Error al verificar el ID de la práctica: " + e.getMessage());
            return false;
        }
    }
    
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
    public int leerIdAsignacion(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();  // Leer como String para validar
            if (entrada.matches("^[0-9]+$")) {  // Verificar que solo contenga números
                int id = Integer.parseInt(entrada);  // Convertir a entero
                if (existePractica(id)) {
                    return id;  // Si el ID es válido, retornamos
                } else {
                    System.out.println("El ID ingresado no corresponde a ninguna práctica. Intenta nuevamente.");
                }
            } else {
                System.out.println("Por favor, ingresa un ID válido (solo números).");
            }
        }
    }
    
}
