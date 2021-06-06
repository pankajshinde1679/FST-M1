package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Plane plane = new Plane(10);

		//Add passengers on the list
		plane.onBoard("Pankaj");
		plane.onBoard("Priya");
		plane.onBoard("Anvi");
		plane.onBoard("Avneesh");

		//Plane takes off
		System.out.println("Plane took off at: " + plane.takeOff());

		//Print list of people on board
		System.out.println("People on the plane: " + plane.getPassengers());

		//Plane flying 
		Thread.sleep(10000);

		// Plane landed.
		plane.land();

		//Plane lands
		System.out.println("Plane landed at: " + plane.getLastTimeLanded());
		
		// List of people in the plane after landing.
		System.out.println("People on the plane after landing: " + plane.getPassengers()); 


	}

}
