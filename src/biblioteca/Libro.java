package biblioteca;

public class Libro {
    //Representa un libro y tiene un constructor que establece sus atributos:
    // título, autor y número de copias disponibles.

    // Atributos
    private String titulo;
    private String autor;
    private int copiasDisponibles;

    // Constructor
    public Libro(String titulo, String autor, int copiasDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.copiasDisponibles = copiasDisponibles;
    }

    // Métodos
    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getCopiasDisponibles() {
        return this.copiasDisponibles;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCopiasDisponibles(int copiasDisponibles) {
        this.copiasDisponibles = copiasDisponibles;
    }

}
