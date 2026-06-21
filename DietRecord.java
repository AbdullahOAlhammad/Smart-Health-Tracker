
package assignment;

import assignment.User;
import static assignment.Gender.Female;
import static assignment.Gender.Male;

import java.time.*;

//sup-class 
class DietRecord extends HealthRecord {
    
     //Attributes
     private double calories;
     private double fat;
     private double protein;
     private User.WeightGoal Goal;
   

    
    //Constructor
    public DietRecord(LocalDate date, User user, double calories,double fat,double protein,User.WeightGoal Goal) {
        super(date, user);
        this.calories = calories;
        this.fat = fat;
        this.protein = protein;
        this.Goal = Goal;
    }
    
    
    
    //Behaviour
    
    
     //Polymorphism
     public void display() {
        super.display();
        System.out.println("Calories: " + calories);
        System.out.println("Fat: " + getFat() + " g");
        System.out.println("Protein: " + getProtein() + " g");
        System.out.println("Goal: " + Goal);
    }
    
    
    
    
    //Getter & Setter 
    /**
     * @return the calories
     */
    public double getCalories() {
        return calories;
    }

    /**
     * @param calories the calories to set
     */
    public void setCalories(double calories) {
        this.calories = calories;
    }

    /**
     * @return the fat
     */
    public double getFat() {
        return fat;
    }

    /**
     * @param fat the fat to set
     */
    public void setFat(double fat) {
        this.fat = fat;
    }

    /**
     * @return the protein
     */
    public double getProtein() {
        return protein;
    }

    /**
     * @param protein the protein to set
     */
    public void setProtein(double protein) {
        this.protein = protein;
    }
    
    


    
}
