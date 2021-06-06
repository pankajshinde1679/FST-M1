package activities;

public class Activity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Age of a person in seconds.
		double seconds = 1000000000;
		
		// Orbital period of planets.
		double EarthSeconds = 31557600; // 365.25*24*60*60;
		double MercurySeconds = 0.2408467;
		double VenusSeconds = 0.61519726;
		double MarsSeconds = 1.8808158;
		double JupiterSeconds = 11.862615;
		double SaturnSeconds = 29.447498;
		double UranusSeconds = 84.016846;
		double NeptuneSeconds = 164.79132;
		
		// Calculate age of a person.
		
		System.out.println("Age on EARTH is: "+seconds/(365.25*24*3600) +"Earth Years");
		System.out.println("Age on MERCURY is: "+seconds/EarthSeconds/MercurySeconds +"Earth Years"); // Mercury take 88 Earth days. 88/365.25 = 0.2408467
		System.out.println("Age on VENUS is: "+seconds/EarthSeconds/VenusSeconds +"Earth Years"); // Venus takes 225 Earth days.
		System.out.println("Age on MARS is: "+seconds/EarthSeconds/MarsSeconds +"Earth Years"); // Mars takes 687 Earth days.
		System.out.println("Age on JUPITER is: "+seconds/EarthSeconds/JupiterSeconds +"Earth Years"); // Jupiter takes 4333 Earth days
		System.out.println("Age on SATURN is: "+seconds/EarthSeconds/SaturnSeconds +"Earth Years"); // Saturn takes 10756 Earth days
		System.out.println("Age on URANUS is: "+seconds/EarthSeconds/UranusSeconds +"Earth Years"); // Uranus takes 30687 Earth days
		System.out.println("Age on NEPTUNE is: "+seconds/EarthSeconds/NeptuneSeconds +"Earth Years"); // Neptune takes 60190 Earth days 
		
	}

}
