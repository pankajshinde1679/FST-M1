package activities;

public class Activity5 {

	public static void main(String[] args) {
				
		//Create object for MyBook
		MyBook newNovel = new MyBook();
		
		// Set the title.
		newNovel.setTitle("Java - The Complete Reference");
		
		// Print the title of the book.
		System.out.println("The Title is : "+newNovel.getTitle());
	}

}
