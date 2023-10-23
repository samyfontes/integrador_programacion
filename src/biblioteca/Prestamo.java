package biblioteca;

public class Prestamo {
    //Representa un préstamo de un libro y tiene un constructor que establece los detalles del préstamo.
    // usuario, libro y fecha de préstamo.

    // Atributos
    private Usuario usuario;
    private Libro libro;
    private String fechaPrestamo;

    // Constructor
    public Prestamo(Usuario usuario, Libro libro, String fechaPrestamo) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
    }

    // Métodos
    public Usuario getUsuario() {
        return this.usuario;
    }

    public Libro getLibro() {
        return this.libro;
    }

    public String getFechaPrestamo() {
        return this.fechaPrestamo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

}
