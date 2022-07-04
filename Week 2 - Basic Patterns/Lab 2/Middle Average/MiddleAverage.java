import java.util.ArrayList;

public class MiddleAverage {
	public static void main(String[] args) {
		// write your solution here
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		// read pattern
		System.out.print("Value: ");
		int value = In.nextInt();
		arrayList.add(value);
		int min = arrayList.get(0);
		int max = arrayList.get(0);
		double sum = 0;

		// read loop pattern
		while (value != -1) 
		{
			System.out.print("Value: ");
			value = In.nextInt();
			if (value != -1){
				arrayList.add(value);
			}
		}

		// loop to find minimum in an ArrayList
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i) < min) {
				min = arrayList.get(i);
			}
		}
		// System.out.println(min);

		// loop to find maximum in an ArrayList
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i) > max) {
				max = arrayList.get(i);
			}
		}
		// System.out.println(max);

		/* 
		check to see if there's at least 3 values
		then remove the maximum and minimum from the ArrayList
		*/
		if (arrayList.size() > 3) {
			int max_pos = arrayList.indexOf(max);
			arrayList.remove(max_pos);
			int min_pos = arrayList.indexOf(min);
			arrayList.remove(min_pos);

			// sum pattern
			for (int i = 0; i < arrayList.size(); i++)
				{
					sum += arrayList.get(i);
				}
			double average = sum/arrayList.size();

			// output pattern
			System.out.println("Middle average = " + average);
		}
	}
}
