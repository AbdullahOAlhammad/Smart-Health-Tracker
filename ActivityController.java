package assignment;

import java.time.LocalDate;
import java.util.Scanner;

public class ActivityController {

    public void addActivityRecord(User u, Scanner sc) {

        int steps = InputValidator.readInt(sc,
                "Enter steps: ",
                0,
                100000);

        User.ActivityLevel level = chooseActivityLevel(sc);

        ActivityRecord a = new ActivityRecord(LocalDate.now(), u, steps, level);
        u.getHealthRecords().add(a);

        System.out.println("✔ Activity record added.");
    }

    public void addActivityRecord(User u, int steps, User.ActivityLevel level) {
        ActivityRecord a = new ActivityRecord(LocalDate.now(), u, steps, level);
        u.getHealthRecords().add(a);
        System.out.println("✔ Activity record added.");
    }

    public User.ActivityLevel chooseActivityLevel(Scanner sc) {

        System.out.println("Select Activity Level:");
        System.out.println("1. Sedentary");
        System.out.println("2. Light");
        System.out.println("3. Moderate");
        System.out.println("4. Very");
        System.out.println("5. Super");

        int choice = InputValidator.readChoice(sc,
                "Choose activity level: ",
                1,
                5);

        return User.ActivityLevel.values()[choice - 1];
    }

    public void displayActivityRecords(User u) {
        boolean found = false;

        for (HealthRecord r : u.getHealthRecords()) {
            if (r instanceof ActivityRecord) {
                r.display();
                System.out.println("----------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No activity records found.");
        }
    }
}