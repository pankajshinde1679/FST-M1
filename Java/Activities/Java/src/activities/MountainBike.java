package activities;

public class MountainBike extends Bicycle {

	int seatHeight;
	
	public MountainBike(int gears, int currentSpeed,int seatHeight) {
		super(gears, currentSpeed);
		this.seatHeight = seatHeight;
		// TODO Auto-generated constructor stub
		
	}
	
	public void setHeight(int newValue) {
	    seatHeight = newValue;
	}
	
	// Print the number of gears and the currentSpeed of the bicycle.
	public String bicycleDesc() {
		//super.bicycleDesc(); Tried to check if we can call parent method through super keyword.
		return("Exact No of gears are "+ gears + "\nExact Speed of bicycle is " + currentSpeed);
	}

	
}
