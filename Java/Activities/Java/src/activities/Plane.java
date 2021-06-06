package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Plane {
	
	private int maxPassengers;
	private List<String> passengers;
	private Date lastTimeTookOf;
	private Date lastTimeLanded;
	
	

	Plane(int mp)
	{
		maxPassengers = mp;
		passengers = new ArrayList<String>();
	}
	
	void onBoard(String pass)
	{
		passengers.add(pass);
	}
	
	public Date takeOff()
	{		 
		lastTimeTookOf = new Date();
		return lastTimeTookOf;
	}
	
	public void land()
	{
		lastTimeLanded = new Date();
		passengers.clear();
	}
	public Date getLastTimeLanded() {
		return lastTimeLanded;
	}
	
	public List<String> getPassengers()
	{
		return passengers;
	}
}
