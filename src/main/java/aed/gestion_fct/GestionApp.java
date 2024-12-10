package aed.gestion_fct;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Clase principal para gestionar un sistema de administración de diferentes
 * tablas en una base de datos. Proporciona menús para interactuar con varias
 * entidades como alumnos, empresas, tutores, programas, visitas, prácticas y
 * comentarios.
 */
public class GestionApp {

    public final Scanner sc;

    /**
     * Constructor que inicializa el Scanner para la entrada de datos.
     */
    public GestionApp() {
        this.sc = new Scanner(System.in);
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
    public String leerEntrada(String mensaje, String regex, String errorMensaje) {
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
    public int leerOpcion(int min, int max) {
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
    public Date leerFecha(String fechaInput) {
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
    
    /*
    Guardo esto por si acaso
    
    String telefono = leerEntrada("Teléfono (Solo números): ", "^[0-9 ]+$",
                "El teléfono solo puede contener números y espacios.");
        String correo = leerEntrada("Correo (Debe contener @): ", ".*@.*",
                "El correo debe contener un '@'.");
    */
}