package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, String> mp = new HashMap<>();
		
		// Create Map.
		mp.put(1, "Red");
		mp.put(2, "Green");
		mp.put(3, "Brown");
		mp.put(4, "Orange");
		mp.put(5, "Purple");
		
		// Print the Map on the console.
		System.out.println("The Map is: "+mp);
		
		// Print the color based on value.
		System.out.println("Print color: "+mp.get(5));
		
		// Print all set of keys.
		System.out.println("Print all keys: "+mp.keySet());
		
		// Print all set of values.
		System.out.println("Print all values: "+mp.values());
		
		// Remove a key based on key value but key and value does not match.
		mp.remove(1,"Brown");
		
		// After removing a color.
		System.out.println("The Map is: "+mp);
		
		// Remove a key based on correct key value
		mp.remove(1,"Red");
		
		// After removing a color.
		System.out.println("The Map is: "+mp);
		
		// Remove value based on key.
		mp.remove(2);
		
		// After removing a color.
		System.out.println("The Map is: "+mp);
		
		// Remove based on value.
		mp.remove("Brown"); // Cannot be removed based on value.
		
		// After removing a color based on value.
		System.out.println("The Map is: "+mp);
		
		// Check if a key is present.
		if(mp.containsKey(4))
			System.out.println("The map contains the key");
		else
			System.out.println("The map does not contains the key");
		
		// Check if value is present.
		if(mp.containsValue("Orange"))
			System.out.println("The map contains the value");
		else
			System.out.println("The map does not contains the value");
		
		// Print the size of the Map.
		System.out.println("The size is: "+mp.size());
	}

}
