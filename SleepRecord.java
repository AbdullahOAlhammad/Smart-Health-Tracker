package assignment;


import java.time.LocalDate;

//
// SleepRecord represents a user's sleep information
// for a specific date.
// It is a child class of HealthRecord.
//

public class SleepRecord extends HealthRecord {
    
 // Attributes

 // Number of hours the user slept 
 private double hours;
 
 //Enum Sleep quality value
 private SleepQuality quality;
    
 
 // Constructor

 
public SleepRecord(LocalDate date, User user, double hours,SleepQuality quality) {
        super(date, user);
        this.hours = hours;
        this.quality = quality;
    }


// Polymorphism:
// Overrides the display() method in HealthRecord
//to show sleep-specific information.


public void display() {
    super.display();
    System.out.println("Hours slept: " + hours);
    System.out.println("Sleep quality: " + quality);
}
    /**
     * @return the hours
     */
    public double getHours() {
        return hours;
    }
    /**
     * @param hours the hours to set
     */
    public void setHours(double hours) {
        this.hours = hours;
    }

    /**
     * @return the quality
     */
    public SleepQuality getQuality() {
        return quality;
    }

    /**
     * @param quality the quality to set
     */
    public void setQuality(SleepQuality quality) {
        this.quality = quality;
    }
}