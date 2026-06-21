package assignment;

import java.util.Scanner;

public class HealthController {

    private Scanner sc = new Scanner(System.in);

    // Controllers2
    private DietController dietController = new DietController();
    private ActivityController activityController = new ActivityController();
    private SleepController sleepController = new SleepController();
    private WaterIntakeController waterController = new WaterIntakeController();

    // ADD RECORD MENU
    public void addRecordMenu(User user) {

        System.out.println("\nSelect Record Type:");
        System.out.println("1. Diet Record");
        System.out.println("2. Activity Record");
        System.out.println("3. Sleep Record");
        System.out.println("4. Water Intake Record");

        int type = InputValidator.readChoice(sc, "Choose: ", 1, 4);

        switch (type) {

            case 1 -> { // DIET
                double calories = InputValidator.readDouble(sc, "Enter calories: ", 0, 5000);
                double fat = InputValidator.readDouble(sc, "Enter fat (g): ", 0, 500);
                double protein = InputValidator.readDouble(sc, "Enter protein (g): ", 0, 500);

                dietController.addDietRecord(user, calories, fat, protein, User.WeightGoal.Maintain);
            }

            case 2 -> { // ACTIVITY
                activityController.addActivityRecord(user, sc);
            }

            case 3 -> { // SLEEP
                sleepController.addSleepRecord(user, sc);
            }

            case 4 -> { // WATER
                waterController.addWaterRecord(user, sc);
            }
        }
    }



    // REMOVE RECORD MENU
    public void removeRecordMenu(User user) {

        if (user.getHealthRecords().isEmpty()) {
            System.out.println(" No records found.");
            return;
        }

        System.out.println("\n------ RECORDS ------");

        for (int i = 0; i < user.getHealthRecords().size(); i++) {
            System.out.println((i + 1) + ")");
            user.getHealthRecords().get(i).display();
            System.out.println("------------------");
        }

        int num = InputValidator.readInt(
                sc,
                "Enter record number to remove: ",
                1,
                user.getHealthRecords().size()
        );

        user.getHealthRecords().remove(num - 1);
        System.out.println(" Record removed successfully");
    }
}