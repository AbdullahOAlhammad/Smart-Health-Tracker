package assignment;

import java.util.Scanner;

public class InputValidator {

    public static int readInt(Scanner sc, String message, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(sc.nextLine());
                if (value < min || value > max) {
                    System.out.println(" Please enter a value between " + min + " and " + max + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Numbers only.");
            }
        }
    }

    public static double readDouble(Scanner sc, String message, double min, double max) {
        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(sc.nextLine());
                if (value < min || value > max) {
                    System.out.println(" Please enter a value between " + min + " and " + max + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input! Decimal numbers only.");
            }
        }
    }

    public static int readChoice(Scanner sc, String message, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(sc.nextLine());
                if (value < min || value > max) {
                    System.out.println(" Invalid choice. Choose between " + min + " and " + max + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid option.");
            }
        }
    }
}