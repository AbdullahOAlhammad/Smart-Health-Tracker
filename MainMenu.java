package assignment;

import java.util.Scanner;

public class MainMenu {

    private User user;
    private Scanner sc = new Scanner(System.in);

    // Controllers
    private UserController userController = new UserController();
    private DietController dietController = new DietController();
    private ActivityController activityController = new ActivityController();
    private SleepController sleepController = new SleepController();
    private WaterIntakeController waterController = new WaterIntakeController();
    private SummaryController summaryController = new SummaryController();
    private HealthController healthController = new HealthController();

    public MainMenu(User user) {
        this.user = user;
    }

    public void start() {
        int choice;
        do {
            System.out.println("\n------------------------");
            System.out.println("        MAIN MENU");
            System.out.println("------------------------");
            System.out.println("1. Personal Details");
            System.out.println("2. Add Record");
            System.out.println("3. Display Records");
            System.out.println("4. Remove Record");
            System.out.println("5. Recommended Daily Calorie");
            System.out.println("6. BMI");
            System.out.println("7. Summary Today");
            System.out.println("8. Summary Last 7 Days");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> personalDetails();         
                case 2 -> addRecord();              
                case 3 -> displayRecords();         
                case 4 -> removeRecord();            
                case 5 -> showRecommendedCalories();
                case 6 -> showBMI();                
                case 7 -> summaryToday();             
                case 8 -> summaryWeekly();            
                case 9 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option. Try again.");
            }

        } while (choice != 9);
    }

    private void personalDetails() {
        System.out.println("\n--- Personal Details ---");
        userController.fillInDetails(user, sc);
    }

    private void addRecord() {
        System.out.println("\n--- Add Record ---");
        healthController.addRecordMenu(user);
    }

    private void displayRecords() {
        System.out.println("\n--- Display Records ---");
        System.out.println("1. Diet Records");
        System.out.println("2. Activity Records");
        System.out.println("3. Sleep Records");
        System.out.println("4. Water Intake Records");
        System.out.print("Choose an option: ");

        int c = Integer.parseInt(sc.nextLine());

        switch (c) {
            case 1 -> dietController.displayDietRecords(user);
            case 2 -> activityController.displayActivityRecords(user);
            case 3 -> sleepController.displaySleepRecords(user);
            case 4 -> waterController.displayWaterRecords(user);
            default -> System.out.println("Invalid option.");
        }
    }

    // 4) Remove Record -> HealthController.removeRecordMenu(user)
    private void removeRecord() {
        System.out.println("\n--- Remove Record ---");
        healthController.removeRecordMenu(user);
    }

    private void showRecommendedCalories() {
        System.out.println("\n--- Recommended Daily Calorie ---");
        userController.showRecommendedDailyCalories(user, sc);
    }

    private void showBMI() {
        System.out.println("\n--- BMI ---");
        userController.displayBMI(user);
    }

    private void summaryToday() {
        summaryController.displayDailySummary(user);
    }

    private void summaryWeekly() {
        summaryController.displayWeeklySummary(user);
    }
}