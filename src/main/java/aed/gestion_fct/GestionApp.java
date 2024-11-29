package aed.gestion_fct;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Clase principal para gestionar un sistema de administración de diferentes
 * tablas en una base de datos. Proporciona menús para interactuar con varias
 * entidades como alumnos, empresas, tutores, programas, visitas, prácticas y
 * comentarios.
 */
public class GestionApp {

    private final Scanner sc;

    /**
     * Constructor que inicializa el Scanner para la entrada de datos.
     */
    public GestionApp() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Método principal que inicia la aplicación. Presenta un menú para que el
     * usuario seleccione la tabla que desea gestionar. Incluye una opción para
     * cerrar la aplicación.
     */
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

                opcion = leerOpcion(1, 9);

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

    /**
     * Muestra el menú para gestionar la tabla "Alumno". Proporciona opciones
     * para crear, leer, modificar y borrar registros.
     */
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

    /**
     * Muestra el menú para gestionar la tabla "Empresa". Proporciona opciones
     * para crear, leer, modificar y borrar registros.
     */
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

    /**
     * Muestra el menú para gestionar la tabla "Tutor Docente". Proporciona
     * opciones para crear, leer, modificar y borrar registros.
     */
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

    /**
     * Muestra el menú para gestionar la tabla "Tutor Empresa". Proporciona
     * opciones para crear, leer, modificar y borrar registros.
     */
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

    /**
     * Muestra el menú para gestionar la tabla "Visita". Proporciona opciones
     * para crear, leer, modificar y borrar registros.
     */
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

    /**
     * Menú para gestionar los comentarios. Proporciona opciones para crear,
     * leer, modificar y borrar comentarios. También permite volver al menú
     * principal.
     */
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
                break; // Salir del menú de comentarios
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

    /**
     * Menú para gestionar los programas. Proporciona opciones para crear, leer,
     * modificar y borrar programas. También permite volver al menú principal.
     */
    private void menuPrograma() {
        while (true) {
            System.out.println("\n--- Menú Programa ---");
            System.out.println("1. Crear programa");
            System.out.println("2. Leer programas");
            System.out.println("3. Modificar programa");
            System.out.println("4. Borrar programa");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = leerOpcion(1, 5);

            if (opcion == 5) {
                break; // Salir del menú de programas
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

    /**
     * Menú para gestionar las prácticas. Proporciona opciones para crear, leer,
     * modificar y borrar prácticas. También permite volver al menú principal.
     */
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

    /**
     * Crea un nuevo registro en la tabla "alumno". Solicita al usuario ingresar
     * los datos necesarios: nombre, teléfono, correo e ID del programa. Valida
     * los datos antes de insertarlos en la base de datos.
     */
    private void crearAlumno() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.println();
        System.out.println("Programas disponibles:");
        System.out.println();

        leerPrograma(); // Muestra los programas disponibles
        int id_programa = leerIdPrograma("ID del programa: "); // Verifica la validez del ID

        String telefono = leerEntrada("Teléfono (Solo números): ", "^[0-9 ]+$",
                "El teléfono solo puede contener números y espacios.");
        String correo = leerEntrada("Correo (Debe contener @): ", ".*@.*",
                "El correo debe contener un '@'.");

        String insertQuery = "INSERT INTO alumno (nombre, id_programa, telefono, correo) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setInt(2, id_programa); // Inserta el ID del programa
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, correo);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Alumno creado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear alumno: " + e.getMessage());
        }
    }

    /**
     * Crea un nuevo registro en la tabla "empresa". Solicita al usuario
     * ingresar los datos necesarios: nombre, dirección, teléfono y correo.
     * Valida los datos antes de insertarlos en la base de datos.
     */
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

    /**
     * Crea un nuevo registro en la tabla "tutordocente". Solicita al usuario
     * ingresar el nombre, teléfono y correo. Valida los datos antes de
     * insertarlos en la base de datos.
     */
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

    /**
     * Crea un nuevo registro en la tabla "tutorempresa". Solicita al usuario
     * ingresar el nombre, teléfono y correo. Valida los datos antes de
     * insertarlos en la base de datos.
     */
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

    /**
     * Crea un nuevo registro en la tabla "visita". Solicita al usuario ingresar
     * la fecha, observaciones y el ID de asignación. Valida los datos antes de
     * insertarlos en la base de datos.
     */
    private void crearVisita() {
        String fecha = leerEntrada("Fecha (dd/MM/yyyy): ",
                "\\d{2}/\\d{2}/\\d{4}",
                "La fecha debe estar en formato dd/MM/yyyy.");
        Date fechaConversa = leerFecha(fecha);

        System.out.println("Introduzca observación en caso de haberla: ");
        String observaciones = sc.nextLine();
        int id_asignacion = leerIdAsignacion("Introduzca el ID de la práctica: ");

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

    /**
     * Crea un nuevo registro en la tabla "comentario". Solicita al usuario
     * ingresar la fecha, detalle y el ID de la empresa. Valida los datos antes
     * de insertarlos en la base de datos.
     */
    private void crearComentario() {
        String fechaIntroducida = leerEntrada("Fecha del comentario (dd/MM/yyyy): ",
                "\\d{2}/\\d{2}/\\d{4}",
                "La fecha debe estar en formato dd/MM/yyyy.");

        Date fecha = leerFecha(fechaIntroducida);

        System.out.print("Detalle: ");
        String detalle = sc.nextLine();

        System.out.println();
        System.out.println("Empresas disponibles: ");
        System.out.println();

        leerEmpresa();
        int id_empresa = leerIdEmpresa("ID de la empresa: ");

        String insertQuery = "INSERT INTO comentario (fecha, detalle, id_empresa) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setDate(1, fecha);
            preparedStatement.setString(2, detalle);
            preparedStatement.setInt(3, id_empresa);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Comentario creado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear comentario: " + e.getMessage());
        }
    }

    /**
     * Crea un nuevo registro en la tabla "programa". Solicita al usuario
     * ingresar el nombre del programa. Valida los datos antes de insertarlos en
     * la base de datos.
     */
    private void crearPrograma() {
        System.out.print("Nombre del programa: ");
        String nombre = sc.nextLine();

        String insertQuery = "INSERT INTO programa (nombre_programa) VALUES (?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, nombre);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Programa creado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear programa: " + e.getMessage());
        }
    }

    /**
     * Crea un nuevo registro en la tabla "practica". Solicita al usuario
     * ingresar las fechas, estado y las relaciones con otras tablas mediante
     * IDs. Valida los datos antes de insertarlos en la base de datos.
     */
    private void crearPractica() {
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

    /**
     * Lee todos los registros de la tabla "empresa". Muestra el ID, nombre,
     * dirección, teléfono y correo de cada empresa en la base de datos.
     */
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

    /**
     * Lee todos los registros de la tabla "tutordocente". Muestra el ID,
     * nombre, teléfono y correo de cada tutor docente en la base de datos.
     */
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

    /**
     * Lee todos los registros de la tabla "tutorempresa". Muestra el ID,
     * nombre, teléfono y correo de cada tutor de empresa en la base de datos.
     */
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

    /**
     * Lee todos los registros de la tabla "visita". Muestra el ID, fecha,
     * observaciones y práctica asociada de cada visita en la base de datos.
     */
    private void leerVisita() {
        String query = "SELECT * FROM visita";

        try (Connection connection = ConnectionPool.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_visita"));
                System.out.println("Fecha: " + resultSet.getDate("fecha"));
                System.out.println("Observaciones: " + resultSet.getString("observaciones"));
                System.out.println("Práctica: " + resultSet.getInt("id_asignacion"));
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error al leer las visitas: " + e.getMessage());
        }
    }

    /**
     * Lee todos los registros de la tabla "comentario". Muestra el ID, fecha,
     * detalle e ID de la empresa asociada a cada comentario.
     */
    private void leerComentario() {
        String query = "SELECT * FROM comentario";

        try (Connection connection = ConnectionPool.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("ID Comentario: " + resultSet.getInt("id_comentario"));
                System.out.println("Fecha: " + resultSet.getDate("fecha"));
                System.out.println("Detalle: " + resultSet.getString("detalle"));
                System.out.println("ID Empresa: " + resultSet.getInt("id_empresa"));
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error al leer los comentarios: " + e.getMessage());
        }
    }

    /**
     * Lee todos los registros de la tabla "programa". Muestra el ID y nombre de
     * cada programa en la base de datos.
     */
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

    /**
     * Lee todos los registros de la tabla "practica". Muestra información
     * detallada de cada práctica, incluyendo fechas, estado y claves foráneas
     * asociadas.
     */
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
                System.out.println("ID del tutor de la empresa: " + resultSet.getInt("id_tutor_empresa"));
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error al leer las practicas: " + e.getMessage());
        }
    }

    /**
     * Actualiza los datos de un alumno en la base de datos. Permite modificar
     * el nombre, el programa asociado, el teléfono y el correo del alumno.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
    private void modificarAlumno() {
        int id_alumno = leerIdAlumno("ID del alumno a modificar: ");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.println();
        System.out.println("Programas disponibles:");
        System.out.println();

        leerPrograma();
        int id_programa = leerIdPrograma("Nuevo ID del programa: ");

        String telefono = leerEntrada("Teléfono (Solo números): ", "^[0-9 ]+$",
                "El teléfono solo puede contener números y espacios.");
        String correo = leerEntrada("Correo (Debe contener @): ", ".*@.*",
                "El correo debe contener un '@'.");

        String updateQuery = "UPDATE alumno SET nombre = ?, id_programa = ?, telefono = ?, correo = ? WHERE id_alumno = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setInt(2, id_programa);
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, correo);
            preparedStatement.setInt(5, id_alumno);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Alumno actualizado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar el alumno: " + e.getMessage());
        }
    }

    /**
     * Actualiza los datos de una empresa en la base de datos. Permite modificar
     * el nombre, la dirección, el teléfono y el correo de la empresa.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
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

    /**
     * Actualiza los datos de un tutor docente en la base de datos. Permite
     * modificar el nombre, el teléfono y el correo del tutor docente.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
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

    /**
     * Actualiza los datos de un tutor de empresa en la base de datos. Permite
     * modificar el nombre, el teléfono y el correo del tutor de empresa.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
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

    /**
     * Actualiza los datos de una visita en la base de datos. Permite modificar
     * la fecha, las observaciones y la práctica asociada a la visita.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
    private void modificarVisita() {
        int id_visita = leerIdVisita("ID de la visita a modificar: ");

        String fecha = leerEntrada("Fecha (dd/MM/yyyy): ", "\\d{2}/\\d{2}/\\d{4}",
                "La fecha debe estar en formato dd/MM/yyyy.");
        System.out.println("Introduzca observación en caso de haberla:");
        String observaciones = sc.nextLine();

        System.out.println("Prácticas disponibles:");
        leerPractica();
        int id_asignacion = leerIdAsignacion("ID de la práctica: ");

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

    /**
     * Actualiza los datos de un comentario en la base de datos. Permite
     * modificar la fecha, el detalle y la empresa asociada al comentario.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
    private void modificarComentario() {
        int id_comentario = leerIdComentario("ID del comentario a modificar: ");

        String fechaIntroducida = leerEntrada("Fecha del comentario (dd/MM/yyyy): ", "\\d{2}/\\d{2}/\\d{4}",
                "La fecha debe estar en formato dd/MM/yyyy.");
        Date fecha = leerFecha(fechaIntroducida);

        System.out.print("Detalle: ");
        String detalle = sc.nextLine();

        System.out.println("Empresas disponibles:");
        leerEmpresa();
        int id_empresa = leerIdEmpresa("ID de la empresa: ");

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

    /**
     * Actualiza los datos de un programa en la base de datos. Permite modificar
     * el nombre del programa.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
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

    /**
     * Actualiza los datos de una práctica en la base de datos. Permite
     * modificar las fechas, el estado, y las claves foráneas asociadas a la
     * práctica.
     *
     * @throws SQLException si ocurre un error durante la ejecución de la
     * consulta SQL.
     */
    private void modificarPractica() {
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
     * Elimina un alumno de la base de datos.
     * <p>
     * Este método solicita al usuario el ID del alumno a eliminar y lo utiliza
     * para ejecutar una consulta DELETE en la base de datos, eliminando el
     * registro correspondiente.
     * </p>
     *
     * @throws SQLException Si ocurre un error al intentar eliminar el alumno de
     * la base de datos.
     */
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

    /**
     * Elimina un tutor docente de la base de datos.
     * <p>
     * Este método solicita al usuario el ID del tutor docente a eliminar y lo
     * utiliza para ejecutar una consulta DELETE en la base de datos, eliminando
     * el registro correspondiente.
     * </p>
     *
     * @throws SQLException Si ocurre un error al intentar eliminar el tutor
     * docente de la base de datos.
     */
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

    /**
     * Elimina una visita de la base de datos.
     * <p>
     * Este método solicita al usuario el ID de la visita a eliminar y lo
     * utiliza para ejecutar una consulta DELETE en la base de datos, eliminando
     * el registro correspondiente.
     * </p>
     *
     * @throws SQLException Si ocurre un error al intentar eliminar la visita de
     * la base de datos.
     */
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

    /**
     * Elimina un comentario de la base de datos.
     * <p>
     * Este método solicita al usuario el ID del comentario a eliminar y lo
     * utiliza para ejecutar una consulta DELETE en la base de datos, eliminando
     * el registro correspondiente.
     * </p>
     *
     * @throws SQLException Si ocurre un error al intentar eliminar el
     * comentario de la base de datos.
     */
    private void borrarComentario() {
        int id_comentario = leerIdComentario("ID del comentario a borrar: ");
        String deleteQuery = "DELETE FROM comentario WHERE id_comentario = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id_comentario);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Comentario eliminado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar el comentario: " + e.getMessage());
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

    /**
     * Lee una opción del usuario dentro de un rango específico.
     * <p>
     * Este método solicita al usuario que ingrese una opción, y verifica que la
     * opción se encuentre dentro del rango proporcionado (mínimo y máximo). Si
     * la opción no es válida, solicitará al usuario que ingrese nuevamente una
     * opción válida.
     * </p>
     *
     * @param min El valor mínimo válido para la opción.
     * @param max El valor máximo válido para la opción.
     * @return La opción seleccionada por el usuario.
     */
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

    /**
     * Lee una fecha proporcionada por el usuario, validando que esté en formato
     * dd/MM/yyyy.
     * <p>
     * Este método solicita al usuario que ingrese una fecha en formato
     * dd/MM/yyyy, valida que la fecha sea correcta, y convierte la entrada en
     * un objeto {@link java.sql.Date}.
     * </p>
     *
     * @param fechaInput La fecha proporcionada por el usuario como cadena de
     * texto.
     * @return La fecha convertida a {@link java.sql.Date}.
     */
    private Date leerFecha(String fechaInput) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // Validación estricta de la fecha

        while (true) {
            try {
                // Intentar analizar la fecha con formato estricto
                java.util.Date fecha = dateFormat.parse(fechaInput);
                return new java.sql.Date(fecha.getTime()); // Convertir a java.sql.Date si es necesario
            } catch (Exception e) {
                System.out.println("Fecha introducida errónea, asegurese de haber introducido el formato dd/MM/yyyy y que los datos introducidos sean válidos.");

                // Solicitar una nueva entrada
                Scanner scanner = new Scanner(System.in);
                System.out.print("Introduzca la fecha: ");
                fechaInput = scanner.nextLine();
            }
        }
    }

    /**
     * Lee el ID de un alumno proporcionado por el usuario, verificando que sea
     * válido.
     * <p>
     * Este método solicita al usuario el ID de un alumno y verifica que el ID
     * ingresado sea numérico y que exista en la base de datos. Si el ID no es
     * válido, se solicitará un nuevo ingreso.
     * </p>
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar el ID.
     * @return El ID del alumno ingresado por el usuario.
     */
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

    /**
     * Lee el ID de un tutor docente proporcionado por el usuario, verificando
     * que sea válido.
     * <p>
     * Este método solicita al usuario el ID de un tutor docente y verifica que
     * el ID ingresado sea numérico y que exista en la base de datos. Si el ID
     * no es válido, se solicitará un nuevo ingreso.
     * </p>
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar el ID.
     * @return El ID del tutor docente ingresado por el usuario.
     */
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

    /**
     * Lee el ID de una visita proporcionado por el usuario, verificando que sea
     * válido.
     * <p>
     * Este método solicita al usuario el ID de una visita y verifica que el ID
     * ingresado sea numérico y que exista en la base de datos. Si el ID no es
     * válido, se solicitará un nuevo ingreso.
     * </p>
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar el ID.
     * @return El ID de la visita ingresado por el usuario.
     */
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

    /**
     * Lee el ID de un comentario proporcionado por el usuario, verificando que
     * sea válido.
     * <p>
     * Este método solicita al usuario el ID de un comentario y verifica que el
     * ID ingresado sea numérico y que exista en la base de datos. Si el ID no
     * es válido, se solicitará un nuevo ingreso.
     * </p>
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar el ID.
     * @return El ID del comentario ingresado por el usuario.
     */
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
    private int leerIdAsignacion(String mensaje) {
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

    /**
     * Lee una entrada del usuario y valida que coincida con un patrón regular
     * específico.
     * <p>
     * Este método solicita al usuario que ingrese un valor y lo valida
     * utilizando una expresión regular proporcionada. Si la entrada no coincide
     * con el patrón, se mostrará un mensaje de error y se solicitará una nueva
     * entrada.
     * </p>
     *
     * @param mensaje El mensaje que se mostrará al usuario para pedir la
     * entrada.
     * @param regex La expresión regular que se usará para validar la entrada.
     * @param errorMensaje El mensaje de error que se mostrará si la entrada no
     * es válida.
     * @return La entrada proporcionada por el usuario si es válida.
     */
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

    /**
     * Verifica si un alumno con el ID dado existe en la base de datos.
     * <p>
     * Este método realiza una consulta en la base de datos para verificar si
     * existe un registro de alumno con el ID proporcionado.
     * </p>
     *
     * @param id_alumno El ID del alumno a verificar.
     * @return true si el alumno con el ID existe, false en caso contrario.
     */
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

    /**
     * Verifica si un tutor docente con el ID dado existe en la base de datos.
     * <p>
     * Este método realiza una consulta en la base de datos para verificar si
     * existe un registro de tutor docente con el ID proporcionado.
     * </p>
     *
     * @param id_tutor_docente El ID del tutor docente a verificar.
     * @return true si el tutor docente con el ID existe, false en caso
     * contrario.
     */
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

    /**
     * Verifica si una visita con el ID dado existe en la base de datos.
     * <p>
     * Este método realiza una consulta en la base de datos para verificar si
     * existe un registro de visita con el ID proporcionado.
     * </p>
     *
     * @param id_visita El ID de la visita a verificar.
     * @return true si la visita con el ID existe, false en caso contrario.
     */
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

    /**
     * Verifica si un comentario con el ID dado existe en la base de datos.
     * <p>
     * Este método realiza una consulta en la base de datos para verificar si
     * existe un registro de comentario con el ID proporcionado.
     * </p>
     *
     * @param id_comentario El ID del comentario a verificar.
     * @return true si el comentario con el ID existe, false en caso contrario.
     */
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
    private boolean existePractica(int id_asignacion) {
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
     * Verifica si un programa con el ID dado existe en la base de datos.
     * <p>
     * Este método realiza una consulta en la base de datos para verificar si
     * existe un registro de programa con el ID proporcionado.
     * </p>
     *
     * @param id_programa El ID del programa a verificar.
     * @return true si el programa con el ID existe, false en caso contrario.
     */
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
