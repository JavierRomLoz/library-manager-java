import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BookManager {
    private List<Book> books = new ArrayList<>();
    private Scanner sc;

    //CONSTRUCTOR
    public BookManager(Scanner sc){
        this.sc = sc;
    }

    //CREATE BOOK METHOD
    public void create(String title, String author, String publisher){
        Book book = new Book(title, author, publisher, BookStatus.DISPONIBLE);
        books.add(book);
    }

    //LIST BOOK METHOD
    public void list(){
        for(int i = 0; i < books.size() ; i++){
            String titleName = books.get(i).getTitle();
            BookStatus bookStatus = books.get(i).getBookStatus();
            System.out.println((i+1) + ". " + titleName + " " +"Estado: " + bookStatus);
            //System.out.println(books);
        }
    }

    //KNOWNBOOK METHOD
    public void knownBookMethod(){
        System.out.print("¿Quieres ver el listado para conocer el titulo exacto del libro (Si/No)?: ");
        String knownBook = sc.nextLine();
        while(!knownBook.equalsIgnoreCase("si") && !knownBook.equalsIgnoreCase("no")){
            System.out.println("Recuerda escribir 'Si' o 'No' para continuar. ");
            System.out.print("¿Quieres ver el listado para conocer el título exacto del libro (Si/No)?: ");
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
        System.out.print("Introduce el título del libro quieres editar: \n  > ");
        String titleName = sc.nextLine();
        boolean findBook = false;


        //¿¿Y SI HAY DOS LIBROS CON EL MISMO NOMBRE??


        for(int i = 0; i < books.size(); i++){
            while(!books.get(i).getTitle().equalsIgnoreCase(titleName)){
                System.out.println("No existe ese libro en la base de datos.");
                System.out.print("Prueba de nuevo: \n  > ");
                titleName = sc.nextLine();
            }
            if(books.get(i).getTitle().equalsIgnoreCase(titleName)) {
                findBook = true;
                System.out.println("A continuación podrás cambiar el Titulo, Autor, Editorial y Estado del libro. Si no deseas cambiar algún concepto, pulsa Intro y pasarás al siguiente.");
                System.out.print("  > Título: ");
                String newTitle = sc.nextLine();
                books.get(i).setTitle(newTitle);

                System.out.print("  > Autor: ");
                String newAuthor = sc.nextLine();
                books.get(i).setAuthor(newAuthor);

                System.out.print("  > Editorial: ");
                String newPublisher = sc.nextLine();
                books.get(i).setPublisher(newPublisher);

                System.out.print("  > Estado (Disponible/Prestado): ");
                String newStatus = sc.nextLine().toUpperCase();
                while (!newStatus.equalsIgnoreCase("Disponible") && !newStatus.equalsIgnoreCase("Prestado")) {
                    System.out.println("Recuerda que solo puede estar Disponible o Prestado.");
                    System.out.print("  > Estado (Disponible/Prestado): ");
                    newStatus = sc.nextLine().toUpperCase();
                }
                BookStatus status = BookStatus.valueOf(newStatus);
                books.get(i).setBookStatus(status);
            }break;
        }if(!findBook) {
                System.out.println("No existe ese libro en la base de datos.");
        }
    }

    //REMOVE BOOK
    public void remove(){
        knownBookMethod();
        boolean findBook = false;
        System.out.print("Introduce el título del libro que quieres borrar: \n  > ");
        String removeBook = sc.nextLine();
        for(int i = 0; i < books.size(); i++){
            while(!books.get(i).getTitle().equalsIgnoreCase(removeBook)){
                System.out.println("No existe ese libro en la base de datos.");
                System.out.print("Prueba de nuevo: \n  > ");
                removeBook = sc.nextLine();
                }
            if(books.get(i).getTitle().equalsIgnoreCase(removeBook)){
                findBook = true;
                System.out.println("Libro encontrado. ¿Estás seguro que deseas borrarlo?: ");
                String confirmation = sc.nextLine();
                while(!confirmation.equalsIgnoreCase("si") && !confirmation.equalsIgnoreCase("no")) {
                    System.out.print("Recuerda escribir 'Si' o 'No' para continuar. \n  > ");
                    confirmation = sc.nextLine();
                }if (confirmation.equalsIgnoreCase("si")){
                    books.remove(i);
                    System.out.println("Libro eliminado.");
                }else {
                    System.out.println("El libro no se eliminó.");
                }
                break;
            }
            }
            if(!findBook) {
            System.out.println("Ese libro no está en la lista.");
        }
    }

}
