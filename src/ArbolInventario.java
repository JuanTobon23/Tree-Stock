/**
 * Clase ArbolInventario - Implementa la lógica del árbol binario de búsqueda
 * Gestiona las operaciones de inserción, búsqueda y recorrido del inventario
 */
public class ArbolInventario {
    private Producto raiz;

    /**
     * Constructor de la clase ArbolInventario
     * Inicializa el árbol vacío
     */
    public ArbolInventario() {
        this.raiz = null;
    }

    /**
     * Insertar un nuevo producto en el árbol
     * @param id Identificador del producto
     * @param nombre Nombre del producto
     */
    public void insertar(int id, String nombre) {
        if (raiz == null) {
            raiz = new Producto(id, nombre);
            System.out.println("✓ Producto insertado correctamente.");
        } else {
            insertar(raiz, id, nombre);
        }
    }

    /**
     * Método recursivo privado para insertar un producto en el árbol
     * @param nodo Nodo actual en el árbol
     * @param id Identificador del producto
     * @param nombre Nombre del producto
     */
    private void insertar(Producto nodo, int id, String nombre) {
        if (id < nodo.getId()) {
            if (nodo.getIzquierdo() == null) {
                nodo.setIzquierdo(new Producto(id, nombre));
                System.out.println("✓ Producto insertado correctamente.");
            } else {
                insertar(nodo.getIzquierdo(), id, nombre);
            }
        } else if (id > nodo.getId()) {
            if (nodo.getDerecho() == null) {
                nodo.setDerecho(new Producto(id, nombre));
                System.out.println("✓ Producto insertado correctamente.");
            } else {
                insertar(nodo.getDerecho(), id, nombre);
            }
        } else {
            System.out.println("✗ Error: Ya existe un producto con el ID " + id);
        }
    }

    /**
     * Realiza un recorrido inorden del árbol (izquierda, nodo, derecha)
     * Muestra todos los productos ordenados por ID
     */
    public void recorridoInorden() {
        if (raiz == null) {
            System.out.println("✗ El inventario está vacío.");
        } else {
            System.out.println("\n═══════════════════════════════════════");
            System.out.println("        INVENTARIO (Recorrido Inorden)");
            System.out.println("═══════════════════════════════════════");
            recorridoInorden(raiz);
            System.out.println("═══════════════════════════════════════\n");
        }
    }

    /**
     * Método recursivo privado para realizar recorrido inorden
     * @param nodo Nodo actual del árbol
     */
    private void recorridoInorden(Producto nodo) {
        if (nodo != null) {
            recorridoInorden(nodo.getIzquierdo());
            System.out.println("  " + nodo.toString());
            recorridoInorden(nodo.getDerecho());
        }
    }

    /**
     * Buscar un producto por su ID
     * @param id Identificador del producto a buscar
     * @return true si existe, false si no existe
     */
    public boolean buscar(int id) {
        return buscar(raiz, id);
    }

    /**
     * Método recursivo privado para buscar un producto
     * @param nodo Nodo actual del árbol
     * @param id Identificador del producto a buscar
     * @return true si existe, false si no existe
     */
    private boolean buscar(Producto nodo, int id) {
        if (nodo == null) {
            return false;
        }

        if (id == nodo.getId()) {
            return true;
        } else if (id < nodo.getId()) {
            return buscar(nodo.getIzquierdo(), id);
        } else {
            return buscar(nodo.getDerecho(), id);
        }
    }

    /**
     * Obtiene el producto según su ID
     * @param id Identificador del producto
     * @return El objeto Producto si existe, null si no existe
     */
    public Producto obtenerProducto(int id) {
        return obtenerProducto(raiz, id);
    }

    /**
     * Método recursivo privado para obtener un producto
     * @param nodo Nodo actual del árbol
     * @param id Identificador del producto
     * @return El objeto Producto si existe, null si no existe
     */
    private Producto obtenerProducto(Producto nodo, int id) {
        if (nodo == null) {
            return null;
        }

        if (id == nodo.getId()) {
            return nodo;
        } else if (id < nodo.getId()) {
            return obtenerProducto(nodo.getIzquierdo(), id);
        } else {
            return obtenerProducto(nodo.getDerecho(), id);
        }
    }
}
