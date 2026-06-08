import java.util.Scanner;

/**
 * Clase Main - Interfaz de usuario (Consola)
 * Proporciona un menú interactivo para gestionar el inventario
 */
public class Main {
    private static ArbolInventario arbol;
    private static Scanner scanner;

    public static void main(String[] args) {
        arbol = new ArbolInventario();
        scanner = new Scanner(System.in);
        int opcion;

        mostrarBienvenida();

        do {
            mostrarMenu();
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    mostrarInventario();
                    break;
                case 3:
                    buscarProducto();
                    break;
                case 0:
                    salir();
                    break;
                default:
                    System.out.println("✗ Opción inválida. Por favor, intente nuevamente.\n");
            }
        } while (opcion != 0);

        scanner.close();
    }

    /**
     * Muestra el mensaje de bienvenida
     */
    private static void mostrarBienvenida() {
        System.out.println("\n╔═════════════════════════════════════════╗");
        System.out.println("║     SISTEMA DE INVENTARIO CON ÁRBOL     ║");
        System.out.println("║           Árbol Binario de Búsqueda      ║");
        System.out.println("╚═════════════════════════════════════════╝\n");
    }

    /**
     * Muestra el menú principal
     */
    private static void mostrarMenu() {
        System.out.println("─────────────────────────────────────────");
        System.out.println("             MENÚ PRINCIPAL");
        System.out.println("─────────────────────────────────────────");
        System.out.println("  1. Registrar Producto");
        System.out.println("  2. Mostrar Inventario");
        System.out.println("  3. Buscar Producto");
        System.out.println("  0. Salir");
        System.out.println("─────────────────────────────────────────");
    }

    /**
     * Obtiene la opción del usuario con validación
     * @return Opción seleccionada por el usuario
     */
    private static int obtenerOpcion() {
        System.out.print("Seleccione una opción: ");
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada
            return opcion;
        } catch (Exception e) {
            scanner.nextLine(); // Limpiar el buffer en caso de error
            System.out.println("✗ Entrada inválida. Intente de nuevo.\n");
            return -1;
        }
    }

    /**
     * Registra un nuevo producto en el inventario
     */
    private static void registrarProducto() {
        System.out.println("\n─ REGISTRAR NUEVO PRODUCTO ─");
        
        System.out.print("Ingrese el ID del producto: ");
        int id = obtenerEntero();

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("✗ El nombre no puede estar vacío.\n");
            return;
        }

        arbol.insertar(id, nombre);
        System.out.println();
    }

    /**
     * Obtiene un número entero del usuario
     * @return Número entero ingresado
     */
    private static int obtenerEntero() {
        try {
            int numero = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            return numero;
        } catch (Exception e) {
            scanner.nextLine(); // Limpiar el buffer en caso de error
            System.out.println("✗ Por favor, ingrese un número válido.");
            return -1;
        }
    }

    /**
     * Muestra todo el inventario ordenado
     */
    private static void mostrarInventario() {
        arbol.recorridoInorden();
    }

    /**
     * Busca un producto por su ID
     */
    private static void buscarProducto() {
        System.out.println("\n─ BUSCAR PRODUCTO ─");
        System.out.print("Ingrese el ID del producto a buscar: ");
        int id = obtenerEntero();

        if (arbol.buscar(id)) {
            Producto producto = arbol.obtenerProducto(id);
            System.out.println("\n✓ Producto encontrado:");
            System.out.println("  " + producto.toString());
        } else {
            System.out.println("\n✗ El producto con ID " + id + " no existe en el inventario.");
        }
        System.out.println();
    }

    /**
     * Muestra mensaje de salida y cierra la aplicación
     */
    private static void salir() {
        System.out.println("\n╔═════════════════════════════════════════╗");
        System.out.println("║       ¡Gracias por usar el sistema!    ║");
        System.out.println("║              ¡Hasta luego!             ║");
        System.out.println("╚═════════════════════════════════════════╝\n");
    }
}
