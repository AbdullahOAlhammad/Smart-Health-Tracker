package assignment;

import java.time.LocalDate;
import java.util.Scanner;

public class SleepController {

    // Add Sleep Record with full validation
    public void addSleepRecord(User u, Scanner sc) {

        // Validate sleep hours
        double hours = InputValidator.readDouble(
                sc,
                "Enter hours slept: ",
                0,
                24
        );

        // Choose quality
        System.out.println("Choose sleep quality:");
        System.out.println("1. Poor");
        System.out.println("2. Fair");
        System.out.println("3. Good");
        System.out.println("4. Excellent");

        int choice = InputValidator.readChoice(
                sc,
                "Choice: ",
                1,
                4
        );

        SleepQuality quality = SleepQuality.values()[choice - 1];

        // Create record
        SleepRecord sr = new SleepRecord(LocalDate.now(), u, hours, quality);
        u.getHealthRecords().add(sr);

        System.out.println(" Sleep record added.");
        System.out.println(evaluateSleep(hours));
    }

    // Evaluate sleep
    public String evaluateSleep(double hours) {
        if (hours < 6) return "You slept too little.";
        if (hours <= 9) return "Good sleep!";
        return "You slept more than usual.";
    }

    // Display all sleep records
    public void displaySleepRecords(User u) {
        boolean found = false;

        for (HealthRecord r : u.getHealthRecords()) {
            if (r instanceof SleepRecord) {
                r.display();
                System.out.println("-----------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No sleep records found.");
        }
    }
}