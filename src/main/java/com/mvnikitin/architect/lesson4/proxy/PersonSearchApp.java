package com.mvnikitin.architect.lesson4.proxy;

import java.util.Scanner;

public class PersonSearchApp {

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            PersonRepository repository = new PersonSearchEngine();
            String cmd = "n";

            do {
                System.out.println("User to find...");
                System.out.println("First Name: ");
                String firstName = sc.nextLine();

                System.out.println("Middle Name: ");
                String middleName = sc.nextLine();

                System.out.println("Last Name: ");
                String lastName = sc.nextLine();

                System.out.println("Passport: ");
                String passport = sc.nextLine();

                Person person = repository.findPerson(
                        firstName, middleName, lastName, passport);

                System.out.println("\nSearch result: " + person);

                System.out.println("exit [y / n] ?");
                cmd = sc.nextLine();

            } while (!cmd.equals("y"));
        }
    }
}
