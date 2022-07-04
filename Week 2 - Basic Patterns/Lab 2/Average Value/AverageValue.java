import java.util.Scanner;

public class AverageValue {
	public static void main(String[] args) {
		// write your solution here

		// read pattern
		System.out.print("Value: ");
		int integer = In.nextInt();
		double sum = 0;
		double count = 0;

		// read loop pattern
		while (integer != -1) 
		{
			sum += integer;
			System.out.print("Value: ");
			count++;
			integer = In.nextInt();
		}
		double average = sum/count;

		// output pattern - only print if there's at least one integer
		if (count > 1) 
		{
			System.out.println("Average = " + average);	
		}	
	}
}
