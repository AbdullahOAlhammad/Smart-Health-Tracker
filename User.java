
package assignment;

import java.util.*;
import java.time.*;

class User {
    
    //Attributes(Encapsulation)
    
    
    
     // Account information
    private String username;
    private String password;
    private String userId;
    
    // Personal health information
    private String name;
    private int age;
    private Gender gender;
    private double height; // height in (cm)
    private double weight; //weight in kilograms(kg)
    
    enum ActivityLevel {
        Sedentary, Light, Moderate, Very, Super
    }
    enum WeightGoal {
        Maintain, Lose, Gain
    }
    
    /*
      A user can have multiple health records.
      Polymorphism is achieved by storing different
      HealthRecord subclasses in this list.
     */
    private List<HealthRecord> healthRecords;

    // Static variable to generate unique user IDs
    
    private static int userCount = 0;
    
    //Constructor
    
    public User(String username, String password) {
        this.userId = "U" + userCount++;
        this.username = username;
        this.password = password;
        this.healthRecords = new ArrayList<>();        
    }    
    
    //Getter & Setter

   // Returns the unique user ID
    public String getUserId() {
        return userId;
    }

    // Returns user's name
    public String getName() {
        return name;
    }

    // Sets user's name
    public void setName(String name) {
        this.name = name;
    }

     // Returns user's age
    public int getAge() {
        return age;
    }
    

     // Sets user's age
    public void setAge(int age) {
        
    this.age = age;
        
    }

    // Returns user's gender

    public Gender getGender() {
        return gender;
    }

    // Sets user's gender

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // Returns user's height

    public double getHeight() {
        return height;
    }
    // Sets user's Height
    public void setHeight(double height) {
        
        this.height = height;
    }

    // Returns user's weight

    public double getWeight() {
        return weight;
    }

    // Sets user's Weight

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Returns username

    public String getUsername() {
        return username;
    }

    // Sets username

    public void setUsername(String username) {
        this.username = username;
    }

    // Returns password (access controlled)

    public String getPassword() {
        return password;
    }
    
    // Sets password

    public void setPassword(String password) {
        this.password = password;
    }

    /*
      Returns the list of health records.
      The list contains HealthRecord objects
      and supports runtime polymorphism.
     */
    public List<HealthRecord> getHealthRecords() {
        return healthRecords;
    }
    

    
}
