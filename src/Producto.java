/**
 * Clase Producto - Representa un nodo en el árbol binario de búsqueda
 * Contiene los datos del producto (ID y nombre) y los punteros a los nodos izquierdo y derecho
 */
public class Producto {
    private int id;
    private String nombre;
    private Producto izquierdo;
    private Producto derecho;

    /**
     * Constructor de la clase Producto
     * @param id Identificador único del producto
     * @param nombre Nombre del producto
     */
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Producto getIzquierdo() {
        return izquierdo;
    }

    public Producto getDerecho() {
        return derecho;
    }

    // Setters
    public void setIzquierdo(Producto izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(Producto derecho) {
        this.derecho = derecho;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre;
    }
}
