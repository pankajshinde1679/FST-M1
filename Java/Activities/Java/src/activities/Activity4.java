package activities;

import java.util.Arrays;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num[] = {4, 3, 2, 10, 12, 6, 7, 1, 5, 9, 8, 11};
	
		int sizeOfArray = num.length;
		System.out.println("The size of the array is : "+sizeOfArray);
		
		for(int i = 0; i < sizeOfArray; i++)
		{
			// The array of number is.
			System.out.print(num[i]+", ");
		}
		System.out.println();
				
		for(int i = 1; i < sizeOfArray; i++)
		{
			int asc = num[i];
			int j = i - 1;
			
			while(j >= 0 && asc < num[j])
			{
				num[j + 1] = num[j];
				--j;
			}
			num[j + 1] = asc;
		}
		
		System.out.println("Sorted array is :");
		System.out.println(Arrays.toString(num));		
	}

}
