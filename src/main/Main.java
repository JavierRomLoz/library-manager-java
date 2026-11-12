package main;

import book.BookManager;
import member.MemberManager;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookManager book = new BookManager(sc);
        MemberManager member = new MemberManager(sc);
        book.create("Javier", "adrian", "María");
        book.create("juan", "adrian", "María");
        book.create("maria", "adrian", "María");
        book.create("Javier", "adrian", "María");
        book.create("juan", "adrian", "María");

        book.edit();
        //book.list();
        System.out.println("<<>>");
        book.list();
        System.out.println("<<>>");
        book.list();
        //System.out.println("<<>>");
        //
        //member.create("Javier", "Román", "0303030H", "620620620");
        //member.create("Adrián", "Román", "0565658J", "654654654");
        //member.create("María", "Francés", "06028465K", "623623623");
        //member.create("Oncio", "Pelon", "321566256Ñ", "689689689");
        //member.list();
    }
}