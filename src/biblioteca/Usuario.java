package biblioteca;

public class Usuario {
    //Representa un usuario de la biblioteca y tiene un constructor que inicializa sus datos:
    // nombre, apellido y número de documento.

    // Atributos
    private String nombre;
    private String apellido;
    private int documento;
    private Roles rol;

    // Constructor
    public Usuario(String nombre, String apellido, int documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
    }

    // Métodos
    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public int getDocumento() {
        return this.documento;
    }

    public Roles getRol() {
        return rol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }
}
