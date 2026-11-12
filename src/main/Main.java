package main;

import book.BookManager;
import member.MemberManager;
import loan.LoanManager;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookManager book = new BookManager(sc);
        MemberManager member = new MemberManager(sc);
        LoanManager loan = new LoanManager(sc);
        int option = 0;

        do{
            System.out.println("\n===== GESTOR DE BIBLIOTECA =====");
            System.out.println("1. Gestionar libros");
            System.out.println("2. Gestionar socios");
            System.out.println("3. Crear préstamo");
            System.out.println("4. Listar préstamos");
            System.out.println("5. Registrar devolución");
            System.out.println("0. Salir");
            System.out.print("  > ");
            try{
                option = sc.nextInt();
                sc.nextLine();
                switch(option){
                    case 1:
                        bookMenu(book, sc);
                        break;
                    case 2:
                        memberMenu(member, sc);
                        break;
                    case 3:
                        loan.create(book, member);
                        break;
                    case 4:
                        loan.list();
                        break;
                    case 5:
                        loan.returnBook();
                        break;
                    case 0:
                        System.out.println("Programa finalizado.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }catch(java.util.InputMismatchException e){
                System.out.println("Error. Debes introducir una opción numérica.");
                sc.nextLine();
            }
        }while(option != 0);
    }

    private static void bookMenu(BookManager book, Scanner sc){
        int option = 0;
        do{
            System.out.println("\n===== GESTIÓN DE LIBROS =====");
            System.out.println("1. Crear libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Editar libro");
            System.out.println("4. Borrar libro");
            System.out.println("0. Volver");
            System.out.print("  > ");
            try{
                option = sc.nextInt();
                sc.nextLine();
                switch(option){
                    case 1:
                        System.out.print("Título: ");
                        String title = sc.nextLine();
                        System.out.print("Autor: ");
                        String author = sc.nextLine();
                        System.out.print("Editorial: ");
                        String publisher = sc.nextLine();
                        book.create(title, author, publisher);
                        System.out.println("Libro creado correctamente.");
                        break;
                    case 2:
                        book.list();
                        break;
                    case 3:
                        book.edit();
                        break;
                    case 4:
                        book.delete();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }catch(java.util.InputMismatchException e){
                System.out.println("Error. Debes introducir una opción numérica.");
                sc.nextLine();
            }
        }while(option != 0);
    }

    private static void memberMenu(MemberManager member, Scanner sc){
        int option = 0;
        do{
            System.out.println("\n===== GESTIÓN DE SOCIOS =====");
            System.out.println("1. Crear socio");
            System.out.println("2. Listar socios");
            System.out.println("3. Editar socio");
            System.out.println("4. Borrar socio");
            System.out.println("0. Volver");
            System.out.print("  > ");
            try{
                option = sc.nextInt();
                sc.nextLine();
                switch(option){
                    case 1:
                        System.out.print("Nombre: ");
                        String firstName = sc.nextLine();
                        System.out.print("Apellido: ");
                        String lastName = sc.nextLine();
                        System.out.print("DNI: ");
                        String dni = sc.nextLine();
                        System.out.print("Contacto: ");
                        String contact = sc.nextLine();
                        member.create(firstName, lastName, dni, contact);
                        System.out.println("Socio creado correctamente.");
                        break;
                    case 2:
                        member.list();
                        break;
                    case 3:
                        member.edit();
                        break;
                    case 4:
                        member.delete();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }catch(java.util.InputMismatchException e){
                System.out.println("Error. Debes introducir una opción numérica.");
                sc.nextLine();
            }
        }while(option != 0);
    }
}
