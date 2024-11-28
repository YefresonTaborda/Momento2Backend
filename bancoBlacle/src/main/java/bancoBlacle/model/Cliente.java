package bancoBlacle.model;

public class Cliente {
    private String id;
    private String nombre;
    private String apellido;
    private String direccion;

    public Cliente(String id, String nombre, String apellido, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
