
package assignment;



class Calculation {
    
    
    //Behaviours
    public double calculateCaloriesBurned(int steps, double weight) {
        double strideLength = 0.762;
        return (steps * strideLength * weight *1.036/1000);                
        
    }
    
    
     
    
    
  
    
}
