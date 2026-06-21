/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;



import java.time.LocalDate;

public class WaterIntakeRecord extends HealthRecord {

    private double liters; 

    public WaterIntakeRecord(LocalDate date, User user, double liters) {
        super(date, user);
        this.liters = liters;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Water Intake: " + liters + " L");
    }

    public double getLiters() {
        return liters;
    }

    public void setLiters(double liters) {
        this.liters = liters;
    }
}