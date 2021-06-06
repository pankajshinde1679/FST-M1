package activities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Activity9 {

	public static void main(String[] args) {	
		
		List<String> myList = new ArrayList<String>();
		
		// Adding items sequentially.
		myList.add("Pankaj");
		myList.add("Anvi");
		myList.add("Avneesh");
		myList.add("Priya");
		myList.add("Om");
		
		// Adding an item at first location.
		myList.add(0, "Shinde");
		
		// Print the Array List.
		System.out.println("Current Arraylist  : "+myList);
		
		// Print all the names.
		for(int i=0;i<myList.size();i++)
		{
			System.out.println("The name is : "+myList.get(i));
		}
		
		// Print the third name.
		System.out.println("The third name is :"+myList.get(2));
		
		// Method to check if a name exists in the ArrayList
		for(int i=0;i<myList.size();i++)
		{
			if(myList.get(i).contains("Om"))
				System.out.println("The name exist in the list : "+myList.get(i));			
		}
		
		// Alter an item in the list.
		myList.set(5, "Alter"); // Replacing Om with Alter
		
		// Print the Array list after alteration.
		System.out.println("Arraylist after alteration : "+myList);
		
		// Print size of the list.
		System.out.println("The size of the list is : "+myList.size());
		
		// Remove a name from the list.
		myList.remove(4);
		
		// Print the size of the list after removing.
		System.out.println("The size of the list after removing a name is : "+myList.size());
		
		// Print the Array list after removing a name.
		System.out.println("Arraylist after removing a name : "+myList);
		
	}

}
