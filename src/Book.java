public class Book {
    private String title;
    private String author;
    private String publisher;
    private BookStatus bookStatus;

    //CONSTRUCTOR
    public Book(String title, String author, String publisher, BookStatus bookStatus){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.bookStatus = bookStatus;
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

    //toString METHOD
    @Override
    public String toString(){
        return ("Título: " + title + " " +"Autor: " + author + " " + "Editorial: " + publisher + " " + "Estado: " + bookStatus);
    }
}