import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberManager {
    private List<Member> members = new ArrayList<>();
    private Scanner sc;
    private int incrementer = 0;
    //CONSTRUCTOR
    public MemberManager(Scanner sc){
        this.sc = sc;
    }

    //CREATE MEMBER
    public void create(String firstName, String lastName, String dni, String contact) {
        incrementer ++;
        Member member = new Member(firstName, lastName, dni, contact, incrementer);
        members.add(member);
    }


    //EDIT MEMBER
    public void edit(){
        String dni;
        boolean findMember = false;

        do{
            System.out.print("Introduce el 'DNI' del socio: \n  > ");
            dni = sc.nextLine();
            for(int i = 0; i < members.size(); i++){
                if(members.get(i).getDni().equalsIgnoreCase(dni)) {
                    findMember = true;
                    System.out.println("A continuación podrás cambiar el DNI, Nombre, Apellido, y Contacto. Si no deseas cambiar algún concepto, pulsa Intro y pasarás al siguiente.");

                    System.out.print("  > DNI: ");
                    String newDni = sc.nextLine();
                    if(!newDni.isEmpty()){
                        members.get(i).setDni(newDni);
                    }

                    System.out.print("  > Nombre: ");
                    String newFirstName = sc.nextLine();
                    if(!newFirstName.isEmpty()){
                        members.get(i).setFirstName(newFirstName);
                    }

                    System.out.print("  > Apellido: ");
                    String newLastName = sc.nextLine();
                    if(!newLastName.isEmpty()){
                        members.get(i).setLastName(newLastName);
                    }

                    System.out.print("  > Contacto: ");
                    String newContact = sc.nextLine();
                    if(!newContact.isEmpty()){
                        members.get(i).setContact(newContact);
                    }break;
                }
            }if(!findMember){
                System.out.println("No se encontró este socio.");
            }
        }while(!findMember && !dni.isEmpty());
    }

    //LIST MEMBER
    public void list(){
        for(int i = 0; i < members.size(); i++){
            System.out.println(members.get(i));
        }
    }

    //DELETE MEMBER
    public void delete(){
        boolean findMember = false;
        String deleteMember;
        do{
            System.out.print("Introduce el DNI del socio que quieres borrar o pulsa 'Intro' para salir: \n  > ");
            deleteMember = sc.nextLine();
            for(int i = 0; i < members.size(); i++){
                if(members.get(i).getDni().equalsIgnoreCase(deleteMember)){
                    findMember = true;
                    System.out.print("Socio encontrado: " + members.get(i).getFirstName() + " " + members.get(i).getLastName() + "\n¿Estás seguro que deseas borrarlo?:\n  > ");
                    String confirmation = sc.nextLine();
                    while(!confirmation.equalsIgnoreCase("si") && !confirmation.equalsIgnoreCase("no")) {
                        System.out.print("Recuerda escribir 'Si' o 'No' para continuar. \n  > ");
                        confirmation = sc.nextLine();
                    }if (confirmation.equalsIgnoreCase("si")){
                        members.remove(i);
                        System.out.println("Socio eliminado.");
                    }else {
                        System.out.println("El socio no se eliminó.");
                    }break;
                }
            }
        }while(!findMember && !deleteMember.isEmpty());
    }

}
