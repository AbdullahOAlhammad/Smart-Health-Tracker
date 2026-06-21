package assignment;
import java.time.*;
//sup-class
class ActivityRecord extends HealthRecord {

    // Attributes
    
    // Number of steps taken by the user
    private int steps;
    
    // Calories burned based on steps and user weight
    private double caloriesBurned;
    
    //  Enum ActivityLevel
    private User.ActivityLevel activityLevel; 

    // Constructor
    public ActivityRecord(LocalDate date, User user, int steps, User.ActivityLevel activityLevel) {
        super(date, user);
        this.steps = steps;
        this.activityLevel = activityLevel;
        this.caloriesBurned = calculateCaloriesBurned(steps);
    }

    // Behavior
    Calculation c = new Calculation();

    public double calculateCaloriesBurned(int steps) {
        double strideLength = 0.762;
        return (steps * strideLength * getUser().getWeight() * 1.036 / 1000);
    }
    
  
     // Polymorphism:
     // This method overrides the display() method
     // in the HealthRecord parent class.
     // The correct version is called at runtime.
  
    @Override
    public void display() {
        super.display();// Display common HealthRecord details
        System.out.println("Steps: " + steps);
        System.out.println("Activity Level: " + activityLevel);
        System.out.printf("Calories Burned: %.1f kcal\n", caloriesBurned);
    }

    // Getters & Setters
    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    public User.ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(User.ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }
}
