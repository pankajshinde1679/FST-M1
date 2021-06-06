package activities;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num = {10, 77, 10, 54, -11, 10};
		int sum=0;
		
		// Iterate through the array for all numbers
		for(int i=0;i<=5;i++)
		{
			// Add sum only if number is 10
			if(num[i]==10)
			{
				sum = sum+num[i];
			}
		}
		
		// Print result on console if sum is 30 or not.
		if(sum==30)
			System.out.println("The total is :" +sum);
		else
			System.out.println("The total is not 30.");

	}

}
