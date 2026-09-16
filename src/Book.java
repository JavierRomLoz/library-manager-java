public class Book {
    private String title;
    private String author;
    private String publisher;
    private BookStatus bookStatus;
    private int idBook;

    //CONSTRUCTOR
    public Book(String title, String author, String publisher, BookStatus bookStatus, int idBook){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.bookStatus = bookStatus;
        this.idBook = idBook;
    }

    //GETTERS & SETTERS
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public String getPublisher(){
        return publisher;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public BookStatus getBookStatus(){
        return bookStatus;
    }
    public void setBookStatus(BookStatus bookStatus){
        this.bookStatus = bookStatus;
    }

    public int getIdBook(){
        return idBook;
    }
    public void setIdBook(int idBook){
        this.idBook = idBook;
    }

    //toString METHOD
    @Override
    public String toString(){
        return ("Id: " + idBook + " - " + "Título: " + title + " " +"Autor: " + author + " " + "Editorial: " + publisher + " " + "Estado: " + bookStatus);
    }
}