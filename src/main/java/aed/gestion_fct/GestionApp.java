package aed.gestion_fct;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class GestionApp {

    private final Scanner sc;

    public GestionApp() {
        this.sc = new Scanner(System.in);
    }

    public void iniciarAplicacion() {
        int opcion;
        try {
            do {
                System.out.println("Elije qué tabla quieres modificar:");
                System.out.println("1. Alumno");
                System.out.println("2. Empresa");
                System.out.println("3. Tutor Docente");
                System.out.println("4. Tutor Empresa");
                System.out.println("5. Visita");
                System.out.println("6. Programa");
                System.out.println("7. Práctica");
                System.out.println("8. Comentario");
                System.out.println("9. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = leerOpcion(1, 9); // Ajustar el rango de opciones

                switch (opcion) {
                    case 1:
                        menuAlumno();
                        break;
                    case 2:
                        menuEmpresa();
                        break;
                    case 3:
                        menuTutorDocente(); 
                        break;
                    case 4:
                        menuTutorEmpresa(); 
                        break;
                    case 5:
                        menuVisita();
                        break;
                    case 6:
                        menuPrograma();
                        break;
                    case 7:
                        menuPractica();
                        break;
                    case 8:
                        menuComentario();
                        break;
                    case 9:
                        System.out.println("Cerrando la aplicación...");
                        break;
                }
            } while (opcion != 9);
        } finally {
            ConnectionPool.close();
        }
    }

    //Menús 
    private void menuAlumno() {
        while (true) {
            System.out.println("\n--- Menú Alumno ---");
            System.out.println("1. Crear alumno");
            System.out.println("2. Leer alumnos");
            System.out.println("3. Modificar alumno");
            System.out.println("4. Borrar alumno");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = leerOpcion(1, 5);

            if (opcion == 5) {
                break;
            }

            switch (opcion) {
                case 1:
                    crearAlumno();
                    break;
                case 2:
                    leerAlumno();
                    break;
                case 3:
                    modificarAlumno();
                    break;
                case 4:
                    borrarAlumno();
                    break;
            }
        }
    }

    private void menuEmpresa() {
        while (true) {
            System.out.println("\n--- Menú Empresa ---");
            System.out.println("1. Crear empresa");
            System.out.println("2. Leer empresas");
            System.out.println("3. Modificar empresa");
            System.out.println("4. Borrar empresa");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = leerOpcion(1, 5);

            if (opcion == 5) {
                break;
            }

            switch (opcion) {
                case 1:
                    crearEmpresa();
                    break;
                case 2:
                    leerEmpresa();
                    break;
                case 3:
                    modificarEmpresa();
                    break;
                case 4:
                    borrarEmpresa();
                    break;
            }
        }
    }

    public void menuTutorDocente() {
        int opcion;
        do {
            System.out.println("Gestión de Tutor Docente:");
            System.out.println("1. Crear Tutor Docente");
            System.out.println("2. Leer Tutor Docente");
            System.out.println("3. Modificar Tutor Docente");
            System.out.println("4. Borrar Tutor Docente");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = leerOpcion(1, 5);

            switch (opcion) {
                case 1:
                    crearTutorDocente();
                    break;
                case 2:
                    leerTutorDocente();
                    break;
                case 3:
                    modificarTutorDocente();
                    break;
                case 4:
                    borrarTutorDocente();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
            }
        } while (opcion != 5);
    }

    public void menuTutorEmpresa() {
        int opcion;
        do {
            System.out.println("Gestión de Tutor Empresa:");
            System.out.println("1. Crear Tutor Empresa");
            System.out.println("2. Leer Tutor Empresa");
            System.out.println("3. Modificar Tutor Empresa");
            System.out.println("4. Borrar Tutor Empresa");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = leerOpcion(1, 5);

            switch (opcion) {
                case 1:
                    crearTutorEmpresa();
                    break;
                case 2:
                    leerTutorEmpresa();
                    break;
                case 3:
                    modificarTutorEmpresa();
                    break;
                case 4:
                    borrarTutorEmpresa();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
            }
        } while (opcion != 5);
    }
    
    public void menuVisita() {
        int opcion;
        do {
            System.out.println("Gestión de Visita:");
            System.out.println("1. Crear Visita");
            System.out.println("2. Leer Visitas");
            System.out.println("3. Modificar Visita");
            System.out.println("4. Borrar Visita");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = leerOpcion(1, 5);

            switch (opcion) {
                case 1:
                    crearVisita();
                    break;
                case 2:
                    leerVisita();
                    break;
                case 3:
                    modificarVisita();
                    break;
                case 4:
                    borrarVisita();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
            }
        } while (opcion != 5);
    }

    // Menú Comentario
    private void menuComentario() {
        while (true) {
            System.out.println("\n--- Menú Comentario ---");
            System.out.println("1. Crear Comentario");
            System.out.println("2. Leer Comentario");
            System.out.println("3. Modificar Comentario");
            System.out.println("4. Borrar Comentario");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = leerOpcion(1, 5);

            if (opcion == 5) {
                break;
            }

            switch (opcion) {
                case 1:
                    crearComentario();
                    break;
                case 2:
                    leerComentario();
                    break;
                case 3:
                    modificarComentario();
                    break;
                case 4:
                    borrarComentario();
                    break;
            }
        }
    }

    private void menuPrograma() {
        while (true) {
            System.out.println("\n--- Menú Programa ---");
            System.out.println("1. Crear programa");
            System.out.println("2. Leer programas");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = leerOpcion(1, 3);

            if (opcion == 3) {
                break;
            }

            switch (opcion) {
                case 1:
                    crearPrograma();
                    break;
                case 2:
                    leerPrograma();
                    break;
                case 3:
                    modificarPrograma();
                    break;
                case 4:
                    borrarPrograma();
                    break;
            }
        }
    }
    
    private void menuPractica() {
        int opcion;
        do {
            System.out.println("Gestión de Prácticas:");
            System.out.println("1. Crear Práctica");
            System.out.println("2. Leer Prácticas");
            System.out.println("3. Modificar Práctica");
            System.out.println("4. Borrar Práctica");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = leerOpcion(1, 5);

            switch (opcion) {
                case 1:
                    crearPractica();
                    break;
                case 2:
                    leerPractica();
                    break;
                case 3:
                    modificarPractica();
                    break;
                case 4:
                    borrarPractica();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
            }
        } while (opcion != 5);
    }

    //Crear
    private void crearAlumno() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        int id_programa = leerIdPrograma("ID del programa: ");  // Se verifica que el id_programa sea válido

        String telefono = leerEntrada("Teléfono (Solo números): ", "^[0-9 ]+$",
                "El teléfono solo puede contener números y espacios.");
        String correo = leerEntrada("Correo (Debe contener @): ", ".*@.*",
                "El correo debe contener un '@'.");

        String insertQuery = "INSERT INTO alumno (nombre, id_programa, telefono, correo) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setInt(2, id_programa);  // Insertar el id_programa en lugar de un nombre
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, correo);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Alumno creado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear alumno: " + e.getMessage());
        }
    }

    private void crearEmpresa() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Dirección: ");
        String direccion = sc.nextLine();

        String telefono = leerEntrada("Teléfono (Solo números): ", "^[0-9 ]+$",
                "El teléfono solo puede contener números y espacios.");
        String correo = leerEntrada("Correo (Debe contener @): ", ".*@.*",
                "El correo debe contener un '@'.");

        String insertQuery = "INSERT INTO empresa (nombre, direccion, telefono, correo) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, direccion);
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, correo);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Empresa creada. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear empresa: " + e.getMessage());
        }
    }

    private void crearTutorDocente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        String telefono = leerEntrada("Teléfono (Solo números): ", "^[0-9 ]+$",
                "El teléfono solo puede contener números y espacios.");
        String correo = leerEntrada("Correo (Debe contener @): ", ".*@.*",
                "El correo debe contener un '@'.");

        String insertQuery = "INSERT INTO tutordocente (nombre, telefono, correo) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, telefono);
            preparedStatement.setString(3, correo);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Tutor Docente creado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear Tutor Docente: " + e.getMessage());
        }
    }

    private void crearTutorEmpresa() {
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
    
    private void crearVisita() {
        
        String fecha = leerEntrada("Fecha (dd/MM/yyyy)", 
                "\\d{2}/\\d{2}/\\d{4}",
                "La fecha debe estar en formato dd/MM/yyyy.");
        String observaciones = sc.nextLine();
        int id_asignacion = leerIdAsignacion("ID de la práctica.");
        
        Date fechaConversa = leerFecha(fecha);

        String insertQuery = "INSERT INTO visita (fecha, observaciones, id_asignacion) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setDate(1, fechaConversa);
            preparedStatement.setString(2, observaciones);
            preparedStatement.setInt(3, id_asignacion);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Visita creada. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear visita: " + e.getMessage());
        }
    }

    private void crearComentario() {
        System.out.println("Fecha: ");
        String fechaIntroducida = sc.nextLine();

        Date fecha = leerFecha(fechaIntroducida);

        System.out.print("Detalle: ");
        String detalle = sc.nextLine();

        int id_empresa = sc.nextInt();

        String insertQuery = "INSERT INTO comentario (fecha, detalle, id_empresa) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setDate(1, fecha);
            preparedStatement.setString(2, detalle);
            preparedStatement.setInt(3, id_empresa);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Tutor de empresa creado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear tutor de empresa: " + e.getMessage());
        }
    }

    private void crearPrograma() {
        System.out.print("Nombre del programa: ");
        String nombre = sc.nextLine();

        // Aquí puedes agregar más detalles si el programa tiene más atributos.
        String insertQuery = "INSERT INTO programa (nombre_programa) VALUES (?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, nombre);  // Insertar el nombre del programa

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Programa creado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear programa: " + e.getMessage());
        }
    }
    
    private void crearPractica() {
        String fechaInicio = leerEntrada("Fecha inicio (dd/MM/yyyy)", 
                "\\d{2}/\\d{2}/\\d{4}",
                "La fecha debe estar en formato dd/MM/yyyy.");
        String fechaFin = leerEntrada("Fecha fin (dd/MM/yyyy)", 
                "\\d{2}/\\d{2}/\\d{4}",
                "La fecha debe estar en formato dd/MM/yyyy.");
        
        System.out.println("Estado de la práctica: ");
        String estado = sc.nextLine();
        
        System.out.println("ID del alumno: ");
        int id_alumno = leerIdAlumno(sc.nextLine());
        System.out.println("ID de la empresa: ");
        int id_empresa = leerIdEmpresa(sc.nextLine());
        System.out.println("ID del tutor docente: ");
        int id_tutor_docente = leerIdTutorDocente(sc.nextLine());
        System.out.println("ID del tutor de la empresa: ");
        int id_tutor_empresa = leerIdTutorEmpresa(sc.nextLine());
        
        Date fechaInicioConversa = leerFecha(fechaInicio);
        Date fechaFinConversa = leerFecha(fechaFin);

        String insertQuery = "INSERT INTO visita (fecha_inicio, fecha_fin, estado, id_alumno, id_empresa, id_tutor_docente, id_tutor_empresa) VALUES (?, ?, ?, ?, ?, ?, ?)";
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

    //Leer
    private void leerAlumno() {
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

    private void leerEmpresa() {
        String query = "SELECT * FROM empresa";

        try (Connection connection = ConnectionPool.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_empresa"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Dirección: " + resultSet.getString("direccion"));
                System.out.println("Teléfono: " + resultSet.getString("telefono"));
                System.out.println("Correo: " + resultSet.getString("correo"));
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error al leer las empresas: " + e.getMessage());
        }
    }

    private void leerTutorDocente() {
        String query = "SELECT * FROM tutordocente";

        try (Connection connection = ConnectionPool.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_tutor_docente"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Teléfono: " + resultSet.getString("telefono"));
                System.out.println("Correo: " + resultSet.getString("correo"));
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error al leer los Tutores Docentes: " + e.getMessage());
        }
    }

    private void leerTutorEmpresa() {
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
    
    private void leerVisita() {
        String query = "SELECT * FROM visita";

        try (Connection connection = ConnectionPool.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_visita"));
                System.out.println("Fecha: " + resultSet.getDate("fecha"));
                System.out.println("Teléfono: " + resultSet.getString("observaciones"));
                System.out.println("Correo: " + resultSet.getInt("id_asignacion"));
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error al leer las visitas: " + e.getMessage());
        }

    }

    private void leerComentario() {
        String query = "SELECT * FROM comentario";

        try (Connection connection = ConnectionPool.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("Fecha: " + resultSet.getDate("fecha"));
                System.out.println("Detalle: " + resultSet.getString("detalle"));
                System.out.println("ID Empresa: " + resultSet.getInt("id_empresa"));
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error al leer los comentarios: " + e.getMessage());
        }
    }

    private void leerPrograma() {
        String query = "SELECT * FROM programa";

        try (Connection connection = ConnectionPool.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("ID Programa: " + resultSet.getInt("id_programa"));
                System.out.println("Nombre: " + resultSet.getString("nombre_programa"));
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error al leer los programas: " + e.getMessage());
        }
    }
    
    private void leerPractica() {
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
                System.out.println("ID del tutor de la empresa " + resultSet.getInt("id_tutor_empresa"));
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error al leer las practicas: " + e.getMessage());
        }
    }

    //Modificar
    private void modificarAlumno() {
        int id_alumno = leerIdAlumno("ID del alumno a modificar: ");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        int id_programa = leerIdPrograma("Nuevo ID del programa: ");  // Validar ID del programa antes de modificar

        String telefono = leerEntrada("Teléfono (Solo números): ", "^[0-9 ]+$",
                "El teléfono solo puede contener números y espacios.");
        String correo = leerEntrada("Correo (Debe contener @): ", ".*@.*",
                "El correo debe contener un '@'.");

        String updateQuery = "UPDATE alumno SET nombre = ?, id_programa = ?, telefono = ?, correo = ? WHERE id_alumno = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setInt(2, id_programa);  // Actualizar con el id_programa
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, correo);
            preparedStatement.setInt(5, id_alumno);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Alumno actualizado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar el alumno: " + e.getMessage());
        }
    }

    private void modificarEmpresa() {
        int id_empresa = leerIdEmpresa("ID de la empresa a modificar: ");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Dirección: ");
        String direccion = sc.nextLine();

        String telefono = leerEntrada("Teléfono (Solo números): ", "^[0-9 ]+$",
                "El teléfono solo puede contener números y espacios.");
        String correo = leerEntrada("Correo (Debe contener @): ", ".*@.*",
                "El correo debe contener un '@'.");

        String updateQuery = "UPDATE empresa SET nombre = ?, direccion = ?, telefono = ?, correo = ? WHERE id_empresa = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, direccion);
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, correo);
            preparedStatement.setInt(5, id_empresa);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Empresa actualizada. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar la empresa: " + e.getMessage());
        }
    }

    private void modificarTutorDocente() {
        int id_tutor_docente = leerIdTutorDocente("ID del Tutor Docente a modificar: ");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        String telefono = leerEntrada("Teléfono (Solo números): ", "^[0-9 ]+$",
                "El teléfono solo puede contener números y espacios.");
        String correo = leerEntrada("Correo (Debe contener @): ", ".*@.*",
                "El correo debe contener un '@'.");

        String updateQuery = "UPDATE tutordocente SET nombre = ?, telefono = ?, correo = ? WHERE id_tutor_docente = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, telefono);
            preparedStatement.setString(3, correo);
            preparedStatement.setInt(4, id_tutor_docente);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Tutor Docente actualizado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar el Tutor Docente: " + e.getMessage());
        }
    }

    private void modificarTutorEmpresa() {
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
    
    private void modificarVisita() {
        int id_visita = leerIdVisita("ID de la visita a modificar: ");

        String fecha = leerEntrada("Fecha (dd/MM/yyyy)", 
                "\\d{2}/\\d{2}/\\d{4}",
                "La fecha debe estar en formato dd/MM/yyyy.");
        String observaciones = sc.nextLine();
        int id_asignacion = leerIdAsignacion("ID de la práctica.");
        
        
        Date fechaConversa = leerFecha(fecha);

        String updateQuery = "UPDATE visita SET fecha = ?, observaciones = ?, id_asignacion = ? WHERE id_visita = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setDate(1, fechaConversa);
            preparedStatement.setString(2, observaciones);
            preparedStatement.setInt(3, id_asignacion);
            preparedStatement.setInt(4, id_visita);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Visita actualizada. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar visita: " + e.getMessage());
        }
    }

    private void modificarComentario() {
        int id_comentario = leerIdComentario("ID del tutor de empresa a modificar: ");

        System.out.print("Fecha: ");
        String fechaIntroducida = sc.nextLine();

        Date fecha = leerFecha(fechaIntroducida);

        System.out.println("Detalle: ");
        String detalle = sc.nextLine();

        int id_empresa = sc.nextInt();

        String updateQuery = "UPDATE comentario SET fecha = ?, detalle = ?, id_empresa = ? WHERE id_comentario = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setDate(1, fecha);
            preparedStatement.setString(2, detalle);
            preparedStatement.setInt(3, id_empresa);
            preparedStatement.setInt(4, id_comentario);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Comentario actualizado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar el comentario: " + e.getMessage());
        }
    }
    
    private void modificarPrograma() {
        int id_programa = leerIdPrograma("ID del programa a modificar: ");

        System.out.print("Nombre del programa: ");
        String nombre = sc.nextLine();

        String updateQuery = "UPDATE programa SET nombre_programa = ? WHERE id_programa = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setInt(2, id_programa);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Programa actualizado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar el programa: " + e.getMessage());
        }
    }
    
    private void modificarPractica() {
        int id_asignacion = leerIdAsignacion("ID de la práctica a modificar: ");

        String fechaInicio = leerEntrada("Fecha inicio (dd/MM/yyyy)", 
                "\\d{2}/\\d{2}/\\d{4}",
                "La fecha debe estar en formato dd/MM/yyyy.");
        String fechaFin = leerEntrada("Fecha fin (dd/MM/yyyy)", 
                "\\d{2}/\\d{2}/\\d{4}",
                "La fecha debe estar en formato dd/MM/yyyy.");
        String estado = sc.nextLine();
        
        System.out.println("ID del alumno: ");
        int id_alumno = leerIdAlumno(sc.nextLine());
        System.out.println("ID de la empresa: ");
        int id_empresa = leerIdEmpresa(sc.nextLine());
        System.out.println("ID del tutor docente: ");
        int id_tutor_docente = leerIdTutorDocente(sc.nextLine());
        System.out.println("ID del tutor de la empresa: ");
        int id_tutor_empresa = leerIdTutorEmpresa(sc.nextLine());
        
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

    //Borrar
    private void borrarAlumno() {
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

    private void borrarEmpresa() {
        int id_empresa = leerIdEmpresa("ID de la empresa a borrar: ");
        String deleteQuery = "DELETE FROM empresa WHERE id_empresa = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id_empresa);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Empresa eliminada. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar la empresa: " + e.getMessage());
        }
    }

    private void borrarTutorDocente() {
        int id_tutor_docente = leerIdTutorDocente("ID del Tutor Docente a borrar: ");
        String deleteQuery = "DELETE FROM tutordocente WHERE id_tutor_docente = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id_tutor_docente);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Tutor Docente eliminado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar el Tutor Docente: " + e.getMessage());
        }
    }

    private void borrarTutorEmpresa() {
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
    
    private void borrarVisita() {
        int id_visita = leerIdVisita("ID de la visita a borrar: ");
        String deleteQuery = "DELETE FROM visita WHERE id_visita = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id_visita);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Visita eliminada. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar la visita: " + e.getMessage());
        }
    }

    private void borrarComentario() {
        int id_comentario = leerIdComentario("ID del tutor de empresa a borrar: ");
        String deleteQuery = "DELETE FROM comentario WHERE id_comentario = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id_comentario);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Comentario eliminado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar el comentario: " + e.getMessage());
        }
    }
    
    private void borrarPrograma() {
        int id_programa = leerIdPrograma("ID del programa a borrar: ");
        String deleteQuery = "DELETE FROM programa WHERE id_programa = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id_programa);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Programa eliminado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar el programa: " + e.getMessage());
        }
    }
    
    private void borrarPractica() {
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

    //Leer opción usuario
    private int leerOpcion(int min, int max) {
        while (true) {
            try {
                int opcion = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer
                if (opcion >= min && opcion <= max) {
                    return opcion;
                }
                System.out.printf("Por favor, seleccione un número entre %d y %d.%n", min, max);
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                sc.nextLine(); // Limpiar el buffer
            }
        }
    }
    
    private Date leerFecha(String fechaInput) {
        while (true) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            try {
                Date fecha = Date.valueOf(fechaInput);
                return fecha;
            } catch (Exception e) { 
                System.out.println("Fecha introducida errónea, introduzca la fecha en formato dd/MM/yyyy");
            }
        }
    }

    //Leer ID
    private int leerIdAlumno(String mensaje) {
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

    private int leerIdEmpresa(String mensaje) {
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

    private int leerIdTutorDocente(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();
            if (entrada.matches("^[0-9]+$")) {
                int id = Integer.parseInt(entrada);
                if (existeTutorDocente(id)) {
                    return id;
                } else {
                    System.out.println("El ID ingresado no corresponde a ningún Tutor Docente. Intenta nuevamente.");
                }
            } else {
                System.out.println("Por favor, ingresa un ID válido (solo números).");
            }
        }
    }

    private int leerIdTutorEmpresa(String mensaje) {
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
    
    private int leerIdVisita(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();  // Leer como String para validar
            if (entrada.matches("^[0-9]+$")) {  // Verificar que solo contenga números
                int id = Integer.parseInt(entrada);  // Convertir a entero
                if (existeVisita(id)) {
                    return id;  // Si el ID es válido, retornamos
                } else {
                    System.out.println("El ID ingresado no corresponde a ninguna visita. Intenta nuevamente.");
                }
            } else {
                System.out.println("Por favor, ingresa un ID válido (solo números).");
            }
        }
    }

    private int leerIdComentario(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();  // Leer como String para validar
            if (entrada.matches("^[0-9]+$")) {  // Verificar que solo contenga números
                int id = Integer.parseInt(entrada);  // Convertir a entero
                if (existeComentario(id)) {
                    return id;  // Si el ID es válido, retornamos
                } else {
                    System.out.println("El ID ingresado no corresponde a ningún comentario. Intenta nuevamente.");
                }
            } else {
                System.out.println("Por favor, ingresa un ID válido (solo números).");
            }
        }
    }
    
    private int leerIdAsignacion(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();
            if (entrada.matches("^[0-9]+$")) {
                int id = Integer.parseInt(entrada);
                if (existePractica(id)) {
                    return id;
                } else {
                    System.out.println("Por favor, ingresa un ID válido (solo números).");
                }
            }
        }
    }

    //Leer datos
    private int leerIdPrograma(String mensaje) {
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

    //Leer datos
    private String leerEntrada(String mensaje, String regex, String errorMensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();
            if (entrada.matches(regex)) {
                return entrada;
            }
            System.out.println(errorMensaje);
        }
    }

    //Verificar ID
    private boolean existeAlumno(int id_alumno) {
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

    private boolean existeEmpresa(int id_empresa) {
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

    private boolean existeTutorDocente(int id_tutor_docente) {
        String query = "SELECT COUNT(*) FROM tutordocente WHERE id_tutor_docente = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id_tutor_docente);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;

        } catch (SQLException e) {
            System.err.println("Error al verificar el ID del Tutor Docente: " + e.getMessage());
            return false;
        }
    }

    private boolean existeTutorEmpresa(int id_tutor_empresa) {
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
    
    private boolean existeVisita(int id_visita) {
        String query = "SELECT COUNT(*) FROM visita WHERE id_visita = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id_visita);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;

        } catch (SQLException e) {
            System.err.println("Error al verificar el ID de la visita: " + e.getMessage());
            return false;
        }
    }

    private boolean existeComentario(int id_comentario) {
        String query = "SELECT COUNT(*) FROM comentario WHERE id_comentario = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id_comentario);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;

        } catch (SQLException e) {
            System.err.println("Error al verificar el ID del comentario: " + e.getMessage());
            return false;
        }
    }
    
    private boolean existePractica(int id_asignacion) {
        String query = "SELECT COUNT(*) FROM practica WHERE id_asingacion = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id_asignacion);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
            
        } catch (SQLException e) {
            System.err.println("Error l verificar el ID de la práctica: " + e.getMessage());
            return false;
        }
    }

    private boolean existePrograma(int id_programa) {
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