package integrador_programacion;
import biblioteca.*;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        Roles admin = new Roles("admin");
        Roles lector = new Roles("lector");

        // Agregar libros ficticios
        Libro libro1 = new Libro("El Señor de los Anillos", "J.R.R. Tolkien", 5);
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", 3);
        Libro libro3 = new Libro("1984", "George Orwell", 4);
        Libro libro4 = new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", 6);
        Libro libro5 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 7);
        Libro libro6 = new Libro("Los juegos del hambre", "Suzanne Collins", 4);
        Libro libro7 = new Libro("La sombra del viento", "Carlos Ruiz Zafón", 2);
        Libro libro8 = new Libro("Matar a un ruiseñor", "Harper Lee", 5);
        Libro libro9 = new Libro("El Hobbit", "J.R.R. Tolkien", 3);
        Libro libro10 = new Libro("Crimen y castigo", "Fyodor Dostoevsky", 2);
        Libro libro11 = new Libro("Pride and Prejudice", "Jane Austen", 4);
        Libro libro12 = new Libro("El retrato de Dorian Gray", "Oscar Wilde", 3);
        Libro libro13 = new Libro("Rayuela", "Julio Cortázar", 2);
        Libro libro14 = new Libro("Moby-Dick", "Herman Melville", 3);
        Libro libro15 = new Libro("Las aventuras de Sherlock Holmes", "Arthur Conan Doyle", 4);
        Libro libro16 = new Libro("El Gran Gatsby", "F. Scott Fitzgerald", 5);
        Libro libro17 = new Libro("La Odisea", "Homero", 3);
        Libro libro18 = new Libro("La Metamorfosis", "Franz Kafka", 2);
        Libro libro19 = new Libro("Frankenstein", "Mary Shelley", 3);
        Libro libro20 = new Libro("Drácula", "Bram Stoker", 4);

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);
        biblioteca.agregarLibro(libro5);
        biblioteca.agregarLibro(libro6);
        biblioteca.agregarLibro(libro7);
        biblioteca.agregarLibro(libro8);
        biblioteca.agregarLibro(libro9);
        biblioteca.agregarLibro(libro10);
        biblioteca.agregarLibro(libro11);
        biblioteca.agregarLibro(libro12);
        biblioteca.agregarLibro(libro13);
        biblioteca.agregarLibro(libro14);
        biblioteca.agregarLibro(libro15);
        biblioteca.agregarLibro(libro16);
        biblioteca.agregarLibro(libro17);
        biblioteca.agregarLibro(libro18);
        biblioteca.agregarLibro(libro19);
        biblioteca.agregarLibro(libro20);


        // Agregar usuarios ficticios
        Usuario usr1 = new Usuario("Juan", "Pérez", 12345678);
        Usuario usr2 = new Usuario("María", "González", 67890123);
        Usuario usr3 = new Usuario("Carlos", "López", 54321098);
        Usuario usr4 = new Usuario("Samuel", "Fontes", 43278676);
        Usuario usr5 = new Usuario("Matias", "Bertoldo", 12345678);


        usr1.setRol(lector);
        usr2.setRol(lector);
        usr3.setRol(lector);
        usr4.setRol(admin);
        usr5.setRol(admin);

        biblioteca.agregarUsuario(usr1);
        biblioteca.agregarUsuario(usr2);
        biblioteca.agregarUsuario(usr3);
        biblioteca.agregarUsuario(usr4);
        biblioteca.agregarUsuario(usr5);

        Prestamo prestamo1 = new Prestamo(usr1, libro10, "01/01/2021");
        Prestamo prestamo2 = new Prestamo(usr2, libro5, "02/01/2021");
        Prestamo prestamo3 = new Prestamo(usr3, libro1, "03/01/2021");
        Prestamo prestamo4 = new Prestamo(usr4, libro7, "04/01/2021");
        Prestamo prestamo5 = new Prestamo(usr5, libro2, "05/01/2021");
        Prestamo prestamo6 = new Prestamo(usr1, libro16, "06/01/2021");
        Prestamo prestamo7 = new Prestamo(usr2, libro9, "07/01/2021");
        Prestamo prestamo8 = new Prestamo(usr3, libro2, "08/01/2021");
        Prestamo prestamo9 = new Prestamo(usr4, libro1, "09/01/2021");
        Prestamo prestamo10 = new Prestamo(usr5, libro11, "10/01/2021");

        biblioteca.agregarPrestamo(prestamo1);
        biblioteca.agregarPrestamo(prestamo2);
        biblioteca.agregarPrestamo(prestamo3);
        biblioteca.agregarPrestamo(prestamo4);
        biblioteca.agregarPrestamo(prestamo5);
        biblioteca.agregarPrestamo(prestamo6);
        biblioteca.agregarPrestamo(prestamo7);
        biblioteca.agregarPrestamo(prestamo8);
        biblioteca.agregarPrestamo(prestamo9);
        biblioteca.agregarPrestamo(prestamo10);


        insertSpaces();
        System.out.println("Ingrese su numero de documento");
        int dni = scan.nextInt();

        //aca se busca el usuario dentro de los usuarios de la biblioteca por su numero de documento
        // y se ejecuta el menu correspondiente
        for(Usuario usuario : biblioteca.getUsuarios()){
            System.out.println(usuario.getDocumento());
            if(usuario.getDocumento() == dni){
                if(usuario.getRol() == admin){
                    adminMenu(biblioteca, scan, usuario);
                } else if (usuario.getRol() == lector) {
                    normalMenu(biblioteca, scan, usuario);
                }
            }
        }
    }

    private static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private static void insertSpaces(){
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
    }

    //este metodo nos muestra un menu especial para el administrador, junto con la opcion de ejecutar el menu normal
    private static void adminMenu(Biblioteca biblioteca, Scanner scan, Usuario usuario){

        int opcion = 0;
        while(opcion != 7){

            clearConsole();
            System.out.println("Bienvenido " + usuario.getNombre() + " " + usuario.getApellido());
            System.out.println("Menú de administrador:");
            System.out.println("1. Agregar libro");
            System.out.println("2. Agregar usuario");
            System.out.println("3. Mostrar libros disponibles");
            System.out.println("4. Mostrar usuarios");
            System.out.println("5. Mostrar prestamos");
            System.out.println("6. Ejecutar menú normal");
            System.out.println("7. Salir");
            System.out.println();
            System.out.println("Ingrese una opción: ");
            opcion = scan.nextInt();
            scan.nextLine();
            clearConsole();

            switch(opcion){
                case 1:
                    System.out.println("Agregar libro");
                    System.out.print("Ingrese el titulo del libro: ");
                    String titulo = scan.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scan.nextLine();
                    System.out.print("Ingrese la cantidad de copias disponibles: ");
                    int copiasDisponibles = scan.nextInt();
                    scan.nextLine();
                    Libro libro = new Libro(titulo, autor, copiasDisponibles);
                    biblioteca.agregarLibro(libro);
                    System.out.println("El libro " + libro.getTitulo() + " fue agregado a la biblioteca.");
                    //dejamos pasar 2 segundos antes de volver al menu
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.println("Agregar usuario");
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombre = scan.nextLine();
                    System.out.print("Ingrese el apellido del usuario: ");
                    String apellido = scan.nextLine();
                    System.out.print("Ingrese el documento del usuario: ");
                    int documento = scan.nextInt();
                    scan.nextLine();
                    Usuario nuevo_usuario = new Usuario(nombre, apellido, documento);
                    biblioteca.agregarUsuario(usuario);
                    System.out.println("El usuario " + nuevo_usuario.getNombre() + " " + usuario.getApellido() + " fue agregado a la biblioteca.");
                    break;

                case 3:

                    while (opcion != 1) {

                        biblioteca.mostrarLibrosDisponibles();
                        insertSpaces();
                        System.out.println("Presione 1 para volver al menú");
                        opcion = scan.nextInt();
                        scan.nextLine();
                        clearConsole();
                    }

                    break;

                case 4:

                    //mostramos a todos los usuarios en una tabla junto con su numero de documento y su nombre completo
                    while(opcion != 1){

                        System.out.println("               Mostrar usuarios");
                        System.out.println("----------------------------------------------");
                        System.out.println("Nombre completo      -      Documento");
                        System.out.println("----------------------------------------------");

                        for (Usuario usr : biblioteca.getUsuarios()) {
                            String tableRow = String.format("%-20s - %13d", usr.getNombre() + " " + usr.getApellido(), usr.getDocumento());
                            System.out.println(tableRow);
                        }

                        insertSpaces();
                        System.out.println("Presione 1 para volver al menú");
                        opcion = scan.nextInt();
                        scan.nextLine();
                        clearConsole();


                    }
                    break;

                case 5:
                    // Ahora mostraremos los prestamos en una tabla
                    while(opcion != 1) {

                        System.out.println("               Mostrar prestamos");
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.println("Usuario              -      Libro                     -   Fecha");
                        System.out.println("-----------------------------------------------------------------------");

                        for (Prestamo prestamo : biblioteca.getPrestamos()) {
                            String tableRow = String.format("%-20s - %-30s - %s", prestamo.getUsuario().getNombre() + " " + prestamo.getUsuario().getApellido(), prestamo.getLibro().getTitulo(), prestamo.getFechaPrestamo());
                            System.out.println(tableRow);
                        }

                        insertSpaces();
                        System.out.println("Presione 1 para volver al menú");
                        opcion = scan.nextInt();
                        scan.nextLine();
                        clearConsole();
                    }
                        break;

                case 6:
                    normalMenu(biblioteca, scan, usuario);
                    break;
            }
        }
    }

    private static void normalMenu(Biblioteca biblioteca, Scanner scan, Usuario usuario){

        // Menú
        int opcion = 0;
        while (opcion != 4) {

            insertSpaces();
            System.out.println("Menú:");
            System.out.println("1. Retirar libro");
            System.out.println("2. Devolver libro");
            System.out.println("3. Mostrar libros disponibles");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scan.nextInt();
            scan.nextLine();
            clearConsole();

            switch (opcion) {
                case 1:
                    insertSpaces();
                    System.out.println("Retirar libro");
                    System.out.print("Ingrese su numero de documento: ");
                    int documento = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Ingrese el titulo del libro: ");
                    String titulo = scan.nextLine();
                    Usuario usr = biblioteca.buscarUsuario(documento);
                    if (usr != null) {
                        biblioteca.retirarLibro(usr, titulo);
                    } else {
                        System.out.println("hubo un error retirando el libro");
                    }

                    break;
                case 2:
                    insertSpaces();
                    System.out.println("Devolver libro");
                    System.out.print("Ingrese su numero de documento: ");
                    documento = scan.nextInt();
                    scan.nextLine();
                    System.out.println("selecciione el libro que desea devolver:");
                    int i = 1;
                    for (Prestamo prestamo : biblioteca.getPrestamos()) {
                        if (prestamo.getUsuario().getDocumento() == documento) {
                            System.out.println(i + ". " + prestamo.getLibro().getTitulo());
                            i++;
                        }
                    }
                    int opcionLibro = scan.nextInt();
                    scan.nextLine();
                    Prestamo prestamo = biblioteca.getPrestamos().get(opcionLibro - 1);
                    biblioteca.getPrestamos().remove(opcionLibro - 1);
                    prestamo.getLibro().setCopiasDisponibles(prestamo.getLibro().getCopiasDisponibles() + 1);
                    System.out.println("El libro " + prestamo.getLibro().getTitulo() + " fue devuelto por " + prestamo.getUsuario().getNombre() + " " + prestamo.getUsuario().getApellido());

                    break;
                case 3:
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 4:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;

            }
        }


    }

}
