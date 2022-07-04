public class AverageDays {

	//PUT YOUR CODE HERE;
	public static void main(String[] args) {
			double month[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

			// sum pattern
			double sum = 0;
			for (int i = 0; i < month.length; i++)
			{
				sum += month[i];
			}
			double average = sum / month.length;

			// output pattern
			System.out.println("Average days per month = " + average);
	}
}
