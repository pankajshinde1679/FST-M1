package activities;

public class Bicycle implements BicycleParts, BicycleOperations{

	public int gears;
	public int currentSpeed;
	
	public Bicycle(int gears, int currentSpeed)
	{
		this.gears = gears;
		this.currentSpeed = currentSpeed;
				
	}	
	
	public void applyBrake(int decrement) {		
		
		currentSpeed -= decrement; 
		System.out.println("Current speed after decrement is : " + currentSpeed);
	}

	
	public void speedUp(int increment) {
		
		currentSpeed += increment;
		System.out.println("Current speed after increment is : " + currentSpeed);
	}
	
	// Print the number of gears and the currentSpeed of the bicycle.
	public String bicycleDesc() {		
		System.out.println("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);
	    return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);
	}
	

	
}
