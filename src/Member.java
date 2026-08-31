public class Member {
    private String firstName;
    private String lastName;
    private String dni;
    private String contact;
    private int memberNumber;

    //CONSTRUCTOR
    public Member(String firstName, String lastName, String dni, String contact, int memberNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.contact = contact;
        this.memberNumber = memberNumber;
    }

    //GETTERS & SETTERS
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getMemberNumber() {
        return memberNumber;
    }
    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }

    //toString METHOD
    @Override
    public String toString() {
        return ("Nº Miembro: " + memberNumber + " " + "Nombre: " + firstName + " " + "Apellido/s: " + lastName + " " + "Dni: " + dni + " " + "Contacto: " + contact);
    }
}
