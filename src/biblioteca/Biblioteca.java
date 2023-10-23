package biblioteca;
import java.util.*;
import java.time.LocalDate;

public class Biblioteca {
    // Representa la biblioteca y tiene un constructor que inicializa sus atributos:
    // un ArrayList para mantener un registro de libros y una lista de usuarios.

    // Atributos
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Prestamo> prestamos;

    //AGREGAR COLA DE RESERVAS DE LIBROS


    // Constructor
    public Biblioteca() {
        this.libros = new ArrayList<Libro>();
        this.usuarios = new ArrayList<Usuario>();
        this.prestamos = new ArrayList<Prestamo>();
    }




    // Getters y Setters
    public ArrayList<Libro> getLibros() {
        return this.libros;
    }

    public ArrayList<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return this.prestamos;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    //metodos de la biblioteca

    //este metodo permite agregar libros a la biblioteca
    public void agregarLibro(Libro libro) {
        this.libros.add(libro);
    }

    //este metodo permite agregar usuarios a la biblioteca
    public void agregarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    //este metodo permite agregar prestamos a la biblioteca
    public void agregarPrestamo(Prestamo prestamo) {
        this.prestamos.add(prestamo);
    }

    //este metodo muestra una lista de los libros con copias disponibles para prestar, junto con la cantidad de copias disponibles
    public void mostrarLibrosDisponibles(){
        for (Libro libro : this.libros) {
            if (libro.getCopiasDisponibles() > 0) {
                System.out.println(libro.getTitulo() + " - " + libro.getCopiasDisponibles() + " copias disponibles");
            }
        }
    }

    //este metodo permite retirar un libro de la biblioteca, siempre y cuando el usuario exista y el libro tenga copias disponibles
    public void retirarLibro(Usuario usr, String titulo){
        Boolean encontrado = false;
        Libro libro = null;

        for (Libro libroActual : this.libros) {
            if (libroActual.getTitulo().toLowerCase().equals(titulo)) {
                System.out.println(libroActual.getTitulo().toLowerCase() + " - " + titulo);

                libro = libroActual;
                encontrado = true;
            }
        }

        if (encontrado) {
            if (libro.getCopiasDisponibles() > 0) {
                libro.setCopiasDisponibles(libro.getCopiasDisponibles() - 1);
                Prestamo prestamo = new Prestamo(usr, libro, LocalDate.now().toString());
                this.prestamos.add(prestamo);
                System.out.println("El libro " + libro.getTitulo() + " fue retirado por " + usr.getNombre() + " " + usr.getApellido());
            } else {
                System.out.println("No hay copias disponibles del libro " + libro.getTitulo());
            }
        } else {
            System.out.println("El libro no existe");
        }
    }

    //este metodo permite buscar un usuario por su numero de documento
    public Usuario buscarUsuario(int documento){
        Usuario usuario = null;
        Boolean encontrado = false;
        for (Usuario usuarioActual : this.usuarios) {
            if (usuarioActual.getDocumento() == documento) {
                usuario = usuarioActual;
                encontrado = true;
            }
            if(!encontrado){
                throw new RuntimeException("El usuario no existe");
            }
        }
        return usuario;
    }


}
