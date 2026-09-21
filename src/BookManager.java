import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class BookManager {
    private List<Book> books = new ArrayList<>();
    private Scanner sc;
    private int idBook = 0;

    //CONSTRUCTOR
    public BookManager(Scanner sc){
        this.sc = sc;
    }

    //CREATE BOOK METHOD
    public void create(String title, String author, String publisher){
        idBook ++;
        Book book = new Book(title, author, publisher, BookStatus.AVAILABLE, idBook);
        books.add(book);
    }

    //LIST BOOK METHOD
    public void list(){
        for(int i = 0; i < books.size() ; i++){
            System.out.println(books.get(i));
        }
    }

    //KNOWNBOOK METHOD
    public void knownBookMethod(){
        System.out.print("¿Quieres ver el listado para conocer el titulo exacto del libro (Si/No)?:\n  > ");
        String knownBook = sc.nextLine();
        while(!knownBook.equalsIgnoreCase("si") && !knownBook.equalsIgnoreCase("no")){
            System.out.println("Recuerda escribir 'Si' o 'No' para continuar. ");
            System.out.print("¿Quieres ver el listado para conocer el título exacto del libro (Si/No)?:\n  > ");
            knownBook = sc.nextLine();
        }
        if(knownBook.equalsIgnoreCase("si")){
            list();
        }
    }


    //EDIT BOOK METHOD
    public void edit(){
        knownBookMethod();
        //EDIT BOOK
        String titleName;
        boolean findBook = false;
        int editIdBook = 0;

        //UN SOLO INTENTO DE ID, SIN REINTENTO (REVISAR PARA EDIT Y DELETE)
        do{
            System.out.print("Introduce el título del libro quieres editar o pulsa 'Intro' para salir: \n  > ");
            titleName = sc.nextLine();
            if(titleName.isEmpty()){
                System.out.println("Operación finalizada.");
                break;
            }
            for(int i = 0; i < books.size(); i++) {
                if (books.get(i).getTitle().equalsIgnoreCase(titleName)) {
                    System.out.println(books.get(i));
                    findBook = true;
                }
            }
            if(!findBook){
                System.out.println("No existe ese libro en la base de datos.");
            }else {
                try {
                    System.out.print("Estos son los libros que existen. Pon el 'Identificador' del libro que deseas borrar: \n  > ");
                    boolean idFound = false;
                    editIdBook = sc.nextInt();
                    sc.nextLine();
                    for(int i = 0; i < books.size(); i++){
                        if(books.get(i).getIdBook() == editIdBook) {
                            idFound = true;
                            System.out.println("Libro seleccionado: " + books.get(i));
                            System.out.println("A continuación podrás cambiar el Titulo, Autor, Editorial y Estado del libro. Si no deseas cambiar algún concepto, pulsa Intro y pasarás al siguiente.");
                            System.out.print("  > Título: ");
                            String newTitle = sc.nextLine();
                            if(!newTitle.isEmpty()){
                                books.get(i).setTitle(newTitle);
                            }

                            System.out.print("  > Autor: ");
                            String newAuthor = sc.nextLine();
                            if(!newAuthor.isEmpty()){
                                books.get(i).setAuthor(newAuthor);
                            }

                            System.out.print("  > Editorial: ");
                            String newPublisher = sc.nextLine();
                            if(!newPublisher.isEmpty()){
                                books.get(i).setPublisher(newPublisher);
                            }

                            System.out.print("  > Estado (Disponible/Prestado): ");
                            String newStatus = sc.nextLine().toUpperCase();
                            while (!newStatus.equalsIgnoreCase("Disponible") && !newStatus.equalsIgnoreCase("Prestado")) {
                                System.out.println("Recuerda que solo puede estar Disponible o Prestado.");
                                System.out.print("  > Estado (Disponible/Prestado): ");
                                newStatus = sc.nextLine().toUpperCase();
                            }
                            if(newStatus.equals("DISPONIBLE")){
                                newStatus = "AVAILABLE";
                            }else {
                                newStatus = "LOANED";
                            }
                            BookStatus status = BookStatus.valueOf(newStatus);
                            books.get(i).setBookStatus(status);
                            break;
                        }
                    }
                    if(!idFound) {
                        System.out.println("Ese identificador no corresponde a ninguno de los libros mostrados.");
                        break;
                    }
                }catch (InputMismatchException e){
                    System.out.println("Error. Debes introducir el número de Identificador.");
                    sc.nextLine();
                }
            }
        }while(!findBook);
    }

    //DELETE BOOK
    public void delete(){
        knownBookMethod();
        boolean findBook = false;
        String deleteBook;
        int deleteIdBook;
        String confirmation = "";
        do{
            System.out.print("Introduce el título del libro que quieres borrar o pulsa 'Intro' para volver al menú: \n  > ");
            deleteBook = sc.nextLine();
            if(deleteBook.isEmpty()){
                System.out.println("Operación finalizada.");
                break;
            }
            for(int i = 0; i < books.size(); i++) {
                if (books.get(i).getTitle().equalsIgnoreCase(deleteBook)) {
                    System.out.println(books.get(i));
                    findBook = true;
                }
            }
            if(!findBook){
                System.out.println("No existe ese libro en la base de datos.");
            }else {
                try{
                    System.out.print("Estos son los libros que existen. Pon el 'Identificador' del libro que deseas borrar: \n  > ");
                    boolean idFound = false;
                    deleteIdBook = sc.nextInt();
                    sc.nextLine();
                    for(int i = 0; i < books.size(); i++) {
                        if (books.get(i).getIdBook() == deleteIdBook) {
                            idFound = true;
                            System.out.print("Libro seleccionado: " + books.get(i) + "\n¿Estás seguro que deseas borrarlo?:\n  > ");
                            confirmation = sc.nextLine();
                            while(!confirmation.equalsIgnoreCase("si") && !confirmation.equalsIgnoreCase("no")) {
                                System.out.print("Recuerda escribir 'Si' o 'No' para continuar. \n  > ");
                                confirmation = sc.nextLine();
                            }
                            if (confirmation.equalsIgnoreCase("si")){
                                books.remove(i);
                                System.out.println("Libro eliminado.");
                            }else {
                                System.out.println("El libro no se eliminó.");
                            }break;
                        }
                    }
                    if(!idFound) {
                        System.out.println("Ese identificador no corresponde a ninguno de los libros mostrados.");
                        break;
                    }
                }catch (InputMismatchException e){
                    System.out.println("Error. Debes introducir el número de Identificador.");
                    sc.nextLine();
                }
            }
        }while(!findBook);
    }
}
