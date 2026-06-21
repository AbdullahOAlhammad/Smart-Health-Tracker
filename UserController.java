package assignment;


import java.util.Scanner;

// Handles user data, health records, BMI, and calorie calculations 
public class UserController {
    
    // Calls overridden method based on object type
    public void displayAllRecords(User u) {

    for (HealthRecord r : u.getHealthRecords()) {
        r.display();   // Polymorphism happens here
        System.out.println("--------------------");
    }

    }
    

  // Fills and updates user personal details with validation
  public void fillInDetails(User user, Scanner sc) {

    System.out.println("Please enter your name:");
    user.setName(sc.nextLine());

    int age = InputValidator.readInt(sc, "Please enter your age: ", 1, 120);
    user.setAge(age);

    System.out.println("Select gender:");
    System.out.println("1. Male");
    System.out.println("2. Female");
    int choice = InputValidator.readChoice(sc, "Choose gender: ", 1, 2);

    user.setGender(choice == 1 ? Gender.Male : Gender.Female);

    double height = InputValidator.readDouble(sc, "Please enter your height (cm): ", 50, 250);
    user.setHeight(height);

    double weight = InputValidator.readDouble(sc, "Please enter your weight (kg): ", 20, 400);
    user.setWeight(weight);

    System.out.println(" Personal details updated successfully.");
}
  
    // Calculates BMI value
    public double getBMI(User u) {
        return u.getWeight() / Math.pow(u.getHeight() / 100.0, 2);
    }
    
    // Returns BMI category
    public String getBMICategory(User u) {
        double bmi = getBMI(u);
        if (bmi < 18.5) return "Underweight";
        else if (bmi <= 24.9) return "Normal weight";
        else if (bmi <= 29.9) return "Overweight";
        else if (bmi <= 34.9) return "Obesity Class I";
        else if (bmi <= 39.9) return "Obesity Class II";
        else return "Extreme Obesity (Class III)";
    }

    // Displays BMI and category
    public void displayBMI(User u) {
        double bmi = getBMI(u);
        System.out.printf("BMI: %.2f\n", bmi);
        System.out.println("Category: " + getBMICategory(u));
    }

    // Removes a health record safely
    public void removeRecord(User u, int index) {
        if (index < 0 || index >= u.getHealthRecords().size()) {
            System.out.println("Invalid record number.");
            return;
        }

        u.getHealthRecords().remove(index);
        System.out.println("Record removed successfully.");
    }
    
    // Calculates recommended daily calories
    public void showRecommendedDailyCalories(User u, Scanner s) {

    if (u.getGender() == null || u.getAge() <= 0 || u.getHeight() <= 0 || u.getWeight() <= 0) {
        System.out.println("Please fill in personal details first.");
        return;
    }

    System.out.println("Choose Activity Level:");
    System.out.println("1. Sedentary");
    System.out.println("2. Light");
    System.out.println("3. Moderate");
    System.out.println("4. Very");
    System.out.println("5. Super");
    System.out.print("Choice: ");
    int alChoice = Integer.parseInt(s.nextLine());

    User.ActivityLevel al = switch (alChoice) {
        case 1 -> User.ActivityLevel.Sedentary;
        case 2 -> User.ActivityLevel.Light;
        case 3 -> User.ActivityLevel.Moderate;
        case 4 -> User.ActivityLevel.Very;
        case 5 -> User.ActivityLevel.Super;
        default -> User.ActivityLevel.Moderate;
    };

    System.out.println("Choose Weight Goal:");
    System.out.println("1. Maintain");
    System.out.println("2. Lose");
    System.out.println("3. Gain");
    System.out.print("Choice: ");
    int wgChoice = Integer.parseInt(s.nextLine());

    User.WeightGoal wg = switch (wgChoice) {
        case 1 -> User.WeightGoal.Maintain;
        case 2 -> User.WeightGoal.Lose;
        case 3 -> User.WeightGoal.Gain;
        default -> User.WeightGoal.Maintain;
    };

    double tdeeFactor = switch (al) {
        case Sedentary -> 1.2;
        case Light -> 1.375;
        case Moderate -> 1.55;
        case Very -> 1.725;
        case Super -> 1.9;
    };

    double bmr;
    if (u.getGender() == Gender.Male) {
        bmr = (10 * u.getWeight()) + (6.25 * u.getHeight()) - (5 * u.getAge()) + 5;
    } else {
        bmr = (10 * u.getWeight()) + (6.25 * u.getHeight()) - (5 * u.getAge()) - 161;
    }

    double calories = bmr * tdeeFactor;

    switch (wg) {
        case Lose -> calories -= 300;
        case Gain -> calories += 300;
        case Maintain -> {}
    }

    System.out.printf("Recommended Daily Calorie Intake: %.0f kcal\n", calories);
}
    
    
}