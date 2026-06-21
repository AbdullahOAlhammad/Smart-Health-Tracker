
package assignment;

import java.time.LocalDate;

public class DietController {

    public void addDietRecord(User u, double calories, double fat, double protein, User.WeightGoal goal) {
        DietRecord d = new DietRecord(LocalDate.now(), u, calories, fat, protein, goal);
        u.getHealthRecords().add(d);
        System.out.println(" Diet record added.");
    }

    public void displayDietRecords(User u) {
        boolean found = false;

        for (HealthRecord r : u.getHealthRecords()) {
            if (r instanceof DietRecord) {
                r.display();
                System.out.println("-----------------");
                found = true;
            }
        }

        if (!found) System.out.println("No diet records found.");
    }




    public void totalCalorieIntakeToday(User u) {
        double total = 0;
        LocalDate today = LocalDate.now();

        for (HealthRecord r : u.getHealthRecords()) {
            if (r instanceof DietRecord && r.getDate().equals(today)) {
                total += ((DietRecord) r).getCalories();
            }
        }

        System.out.printf("Total calorie intake today: %.1f kcal\n", total);
    }
}