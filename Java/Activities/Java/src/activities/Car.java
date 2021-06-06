package activities;

public class Car {


	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	String t;
	String d;
	
	public Car() {
		// TODO Auto-generated constructor stub
		tyres = 4;
		doors = 4;
	}
	
	public void displayCharacteristics()
	{
		System.out.println("Tyres are:" +tyres);
		System.out.println("Doors are:"+doors);	
		System.out.println("Make of the car:" +make);
		System.out.println("Color of the car:"+color);
		System.out.println("Transmission of the car:"+transmission);
	}
	
	public void accelarate()
	{
		System.out.println("Car is moving forward.");
	}
	
	public void brake()
	{
		System.out.println("Car has stopped.");
	}

}
