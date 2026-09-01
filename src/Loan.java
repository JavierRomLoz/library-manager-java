public class Loan {
    private Book book;
    private Member member;
    private String loanDate;
    private String expectedReturnDate;
    private String actualReturnDate = null;
    private LoanStatus status;
    private int loanId;

    //CONSTRUCTOR
    public Loan(Book book, Member member, String loanDate, String expectedReturnDate, LoanStatus status, int loanId){
        this.book = book;
        this.member = member;
        this.loanDate = loanDate;
        this.expectedReturnDate = expectedReturnDate;
        this.status = status;
        this.loanId = loanId;
    }

    //GETTERS & SETTERS
    public Book getBook(){
        return book;
    }
    public void setBook(Book book){
        this.book = book;
    }

    public Member getMember(){
        return member;
    }
    public void setMember(Member member){
        this.member = member;
    }

    public String getLoanDate(){
        return loanDate;
    }
    public void setLoanDate(String loanDate){
        this.loanDate = loanDate;
    }

    public String getExpectedReturnDate(){
        return expectedReturnDate;
    }
    public void setExpectedReturnDate(String expectedReturnDate){
        this.expectedReturnDate = expectedReturnDate;
    }

    public String getActualReturnDate(){
        return actualReturnDate;
    }
    public void setActualReturnDate(String actualReturnDate){
        this.actualReturnDate = actualReturnDate;
    }

    public LoanStatus getStatus(){
        return status;
    }
    public void setStatus(LoanStatus status){
        this.status = status;
    }

    public int getLoanId(){
        return loanId;
    }
    public void setLoanId(int loanId){
        this.loanId = loanId;
    }

    //toString METHOD
    @Override
    public String toString(){
        return ("Id Préstamo: " + loanId + " " + "Libro: " + book.getTitle() + " " + "Socio: " + member.getMemberNumber() + " " + "Fecha de Préstamo: " + loanDate + " " + "Fecha Estimada de Devolución: " + expectedReturnDate + " " + "Fecha Real de Devolución: " + actualReturnDate + " " + "Estado Préstamo: " + status + " ");
    }


}
