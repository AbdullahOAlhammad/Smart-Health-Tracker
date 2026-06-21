package assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Authentication {

    private ArrayList<User> userRecord = new ArrayList<>();
    private Scanner s = new Scanner(System.in);

    public User Menu() {

        while (true) {
            System.out.println("\n------------------------");
            System.out.println("     HEALTH TRACKER");
            System.out.println("------------------------");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String input = s.nextLine();

            switch (input) {

                case "1" -> {
                    User u = login();
                    return u;  
                }

                case "2" -> register();

                case "3" -> System.exit(0);

                default -> System.out.println("Invalid option... please try again.");
            }
        }
    }

    private User login() {

        System.out.println("\n-----------------------");
        System.out.println("        LOGIN");
        System.out.println("-----------------------");

        while (true) {

            System.out.print("Username: ");
            String username = s.nextLine();

            System.out.print("Password: ");
            String password = s.nextLine();

            for (User user : userRecord) {
                if (user.getUsername().equals(username) &&
                        user.getPassword().equals(password)) {

                    System.out.println("Login successful\n");
                    return user;   // 
                }
            }

            System.out.println("Incorrect username or password.\n");
        }
    }

    private void register() {

        System.out.println("\n------------------------");
        System.out.println("        REGISTER");
        System.out.println("------------------------");

        String username;

        while (true) {

            System.out.print("Choose a username: ");
            username = s.nextLine();

            if (userExists(username)) {
                System.out.println("Username already taken. Try another.\n");
            } else {
                break;
            }
        }

        System.out.print("Choose a password: ");
        String password = s.nextLine();

        userRecord.add(new User(username, password));

        System.out.println("Registration successful!\n");
    }

    private boolean userExists(String username) {

        for (User user : userRecord) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}