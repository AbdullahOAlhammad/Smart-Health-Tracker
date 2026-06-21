
package assignment;

import java.time.*;
 
 // HealthRecord is the base (parent) class for all health-related records
 // in the Smart Health Tracker system.
 // It stores common attributes shared by all record types.
 

class HealthRecord {
    
    //Attributes
    
    // Date when the health record was created
    private LocalDate date = LocalDate.now();
    
    // Reference to the user who owns this record
    private User user;
    
     private String HealthRecordID;
    
    
    //Constructor
    public HealthRecord(LocalDate date,User user) {
        this.date = date;
        this.user = user;
    }
    
     //
     // display() shows basic record information.
     // This method is designed to be overridden
     //by child classes to support polymorphism.
     //

    //Behaviours
    public void display() {
        System.out.println("Date :" + date);
        System.out.println("User: " + user.getName());
    }
    
    //Getter & Setter
    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }  
    
}
