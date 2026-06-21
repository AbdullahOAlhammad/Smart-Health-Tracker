package assignment;

import java.time.LocalDate;
import java.util.Scanner;

public class WaterIntakeController {

    // Add water record with full validation
    public void addWaterRecord(User user, Scanner sc) {

        // Validate liters (0–10 liters per day is a logical range)
        double liters = InputValidator.readDouble(
                sc,
                "Enter liters of water: ",
                0,
                10
        );

        WaterIntakeRecord record = new WaterIntakeRecord(
                LocalDate.now(),
                user,
                liters
        );

        user.getHealthRecords().add(record);

        System.out.println(" Water intake record added.");
        System.out.println(evaluateWaterIntake(user, liters));
    }

    // Evaluation message
    public String evaluateWaterIntake(User user, double liters) {

        double needed = user.getWeight() * 0.033; // recommended daily formula

        if (liters < needed * 0.6)
            return " Water intake is too low. Drink more water.";

        if (liters < needed)
            return "Almost enough water. Drink a bit more.";

        if (liters <= needed * 1.3)
            return "Great job! Your water intake is sufficient.";

        return "You drank more water than needed today.";
    }

    // Display all water records
    public void displayWaterRecords(User user) {
        boolean found = false;

        for (HealthRecord r : user.getHealthRecords()) {
            if (r instanceof WaterIntakeRecord) {
                r.display();
                System.out.println("----------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No water intake records found.");
        }
    }
}