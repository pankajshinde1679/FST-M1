package activities;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Car carName = new Car();	
		
		carName.make = 2014;
		carName.color="black";
		carName.transmission = "Manual";
		
		carName.displayCharacteristics();
		carName.accelarate();
		carName.brake();
	}

}
