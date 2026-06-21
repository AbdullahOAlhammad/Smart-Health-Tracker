package assignment;

import java.time.LocalDate;

public class SummaryController {

    private UserController userController = new UserController();

    //          DAILY SUMMARY
    
    public void displayDailySummary(User u) {

        System.out.println("\n====== DAILY SUMMARY ======");

        LocalDate today = LocalDate.now();
        double caloriesIn = 0;
        double caloriesOut = 0;
        double water = 0;
        double sleepHours = 0;
        int sleepCount = 0;
        int steps = 0;

        for (HealthRecord r : u.getHealthRecords()) {
            if (!r.getDate().equals(today)) continue;

            if (r instanceof DietRecord dr) caloriesIn += dr.getCalories();

            if (r instanceof ActivityRecord ar) {
                caloriesOut += ar.getCaloriesBurned();
                steps += ar.getSteps();
            }

            if (r instanceof WaterIntakeRecord wr) water += wr.getLiters();

            if (r instanceof SleepRecord sr) {
                sleepHours += sr.getHours();
                sleepCount++;
            }
        }

        double avgSleep = (sleepCount == 0) ? 0 : sleepHours / sleepCount;

        System.out.println("Date: " + today);
        System.out.printf("Calories Consumed: %.1f kcal\n", caloriesIn);
        System.out.printf("Calories Burned: %.1f kcal\n", caloriesOut);
        System.out.println("Steps: " + steps);
        System.out.printf("Water Intake: %.1f L\n", water);
        System.out.printf("Average Sleep Hours: %.1f hrs\n", avgSleep);

        System.out.println("=============================\n");
    }

    //          WEEKLY SUMMARY (LAST 7 DAYS)
    public void displayWeeklySummary(User u) {

        System.out.println("\n====== WEEKLY SUMMARY (Last 7 Days) ======");

        LocalDate today = LocalDate.now();
        LocalDate weekStart = today.minusDays(6);

        double caloriesIn = 0;
        double caloriesOut = 0;
        double water = 0;
        double sleepHours = 0;
        int sleepCount = 0;
        int steps = 0;

        for (HealthRecord r : u.getHealthRecords()) {

            if (r.getDate().isBefore(weekStart) || r.getDate().isAfter(today))
                continue;

            if (r instanceof DietRecord dr) caloriesIn += dr.getCalories();

            if (r instanceof ActivityRecord ar) {
                caloriesOut += ar.getCaloriesBurned();
                steps += ar.getSteps();
            }

            if (r instanceof WaterIntakeRecord wr) water += wr.getLiters();

            if (r instanceof SleepRecord sr) {
                sleepHours += sr.getHours();
                sleepCount++;
            }
        }

        double avgSleep = (sleepCount == 0) ? 0 : sleepHours / sleepCount;
        double avgCalIn = caloriesIn / 7;
        double avgCalOut = caloriesOut / 7;

        System.out.println("Week Start: " + weekStart);
        System.out.println("Week End:   " + today);

        System.out.printf("\nTotal Calories Consumed: %.1f kcal\n", caloriesIn);
        System.out.printf("Total Calories Burned: %.1f kcal\n", caloriesOut);
        System.out.println("Total Steps: " + steps);
        System.out.printf("Total Water Intake: %.1f L\n", water);
        System.out.printf("Average Sleep Hours/Day: %.1f hrs\n", avgSleep);

        System.out.printf("\nAverage Daily Calorie Intake: %.1f kcal/day\n", avgCalIn);
        System.out.printf("Average Daily Calorie Burn: %.1f kcal/day\n", avgCalOut);

        System.out.println("==========================================\n");
    }

    //       FULL SUMMARY (USER + DAILY + WEEKLY)
    
    public void displayFullSummary(User u) {

        System.out.println("========== USER SUMMARY ==========");

        System.out.println("Name: " + u.getName());
        System.out.println("Age: " + u.getAge());
        System.out.println("Gender: " + u.getGender());
        System.out.println("Height: " + u.getHeight() + " cm");
        System.out.println("Weight: " + u.getWeight() + " kg");

        double bmi = userController.getBMI(u);

        System.out.printf("BMI: %.2f (%s)\n", bmi, userController.getBMICategory(u));

        System.out.println("----------------------------------");

        displayDailySummary(u);
        displayWeeklySummary(u);

        System.out.println("==================================\n");
    }
}