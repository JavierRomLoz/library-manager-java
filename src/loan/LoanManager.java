package loan;

import book.Book;
import book.BookManager;
import book.BookStatus;
import member.Member;
import member.MemberManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LoanManager {
    private List<Loan> loans = new ArrayList<>();
    private Scanner sc;
    private int loanId = 0;
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);

    //CONSTRUCTOR
    public LoanManager(Scanner sc){
        this.sc = sc;
    }

    //CREATE LOAN
    public void create(BookManager bookManager, MemberManager memberManager){
        System.out.println("Estos son los libros disponibles:");
        bookManager.list();
        try{
            System.out.print("Introduce el identificador del libro que quieres prestar o pulsa '0' para salir: \n  > ");
            int bookId = sc.nextInt();
            sc.nextLine();
            if(bookId == 0){
                System.out.println("Operación finalizada.");
                return;
            }

            Book book = bookManager.findById(bookId);
            if(book == null){
                System.out.println("No existe ningún libro con ese identificador.");
                return;
            }
            if(book.getBookStatus() != BookStatus.AVAILABLE){
                System.out.println("Ese libro ya está prestado.");
                return;
            }

            System.out.print("Introduce el DNI del socio: \n  > ");
            String dni = sc.nextLine();
            Member member = memberManager.findByDni(dni);
            if(member == null){
                System.out.println("No se encontró este socio.");
                return;
            }

            String loanDate = askDate("Introduce la fecha del préstamo (dd/MM/yyyy):");
            String expectedReturnDate = askDate("Introduce la fecha estimada de devolución (dd/MM/yyyy):");
            while(isBefore(expectedReturnDate, loanDate)){
                System.out.println("La fecha estimada no puede ser anterior a la fecha del préstamo.");
                expectedReturnDate = askDate("Introduce la fecha estimada de devolución (dd/MM/yyyy):");
            }

            loanId++;
            Loan loan = new Loan(book, member, loanDate, expectedReturnDate, LoanStatus.ACTIVE, loanId);
            loans.add(loan);
            book.setBookStatus(BookStatus.LOANED);
            System.out.println("Préstamo creado correctamente.");
        }catch(InputMismatchException e){
            System.out.println("Error. Debes introducir el número de Identificador.");
            sc.nextLine();
        }
    }

    //LIST LOAN METHOD
    public void list(){
        for(int i = 0; i < loans.size(); i++){
            System.out.println(loans.get(i));
        }
    }

    //RETURN BOOK
    public void returnBook(){
        if(loans.isEmpty()){
            System.out.println("No hay préstamos registrados.");
            return;
        }

        list();
        try{
            System.out.print("Introduce el identificador del préstamo que quieres finalizar o pulsa '0' para salir: \n  > ");
            int selectedLoanId = sc.nextInt();
            sc.nextLine();
            if(selectedLoanId == 0){
                System.out.println("Operación finalizada.");
                return;
            }

            Loan loan = findById(selectedLoanId);
            if(loan == null){
                System.out.println("No existe ningún préstamo con ese identificador.");
                return;
            }
            if(loan.getStatus() == LoanStatus.FINISHED){
                System.out.println("Ese préstamo ya está finalizado.");
                return;
            }

            String actualReturnDate = askDate("Introduce la fecha real de devolución (dd/MM/yyyy):");
            while(isBefore(actualReturnDate, loan.getLoanDate())){
                System.out.println("La fecha de devolución no puede ser anterior a la fecha del préstamo.");
                actualReturnDate = askDate("Introduce la fecha real de devolución (dd/MM/yyyy):");
            }

            loan.setActualReturnDate(actualReturnDate);
            loan.setStatus(LoanStatus.FINISHED);
            loan.getBook().setBookStatus(BookStatus.AVAILABLE);
            System.out.println("Devolución registrada correctamente.");
            showDelay(loan);
        }catch(InputMismatchException e){
            System.out.println("Error. Debes introducir el número de Identificador.");
            sc.nextLine();
        }
    }

    private Loan findById(int idLoan){
        for(int i = 0; i < loans.size(); i++){
            if(loans.get(i).getLoanId() == idLoan){
                return loans.get(i);
            }
        }
        return null;
    }

    private String askDate(String message){
        String date;
        do{
            System.out.print(message + "\n  > ");
            date = sc.nextLine();
            try{
                LocalDate.parse(date, dateFormat);
                return date;
            }catch(DateTimeParseException e){
                System.out.println("Formato no válido. Utiliza dd/MM/yyyy.");
            }
        }while(true);
    }

    private boolean isBefore(String firstDate, String secondDate){
        LocalDate first = LocalDate.parse(firstDate, dateFormat);
        LocalDate second = LocalDate.parse(secondDate, dateFormat);
        return first.isBefore(second);
    }

    private void showDelay(Loan loan){
        LocalDate expectedDate = LocalDate.parse(loan.getExpectedReturnDate(), dateFormat);
        LocalDate actualDate = LocalDate.parse(loan.getActualReturnDate(), dateFormat);
        long delay = java.time.temporal.ChronoUnit.DAYS.between(expectedDate, actualDate);
        if(delay > 0){
            System.out.println("El préstamo se ha devuelto con " + delay + " días de retraso.");
        }else{
            System.out.println("El préstamo se ha devuelto dentro del plazo.");
        }
    }
}
