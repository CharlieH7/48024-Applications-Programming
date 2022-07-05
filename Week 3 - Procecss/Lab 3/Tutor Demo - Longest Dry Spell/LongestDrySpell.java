public class LongestDrySpell {
	public static void main(String[] args) {
		//Put your code here
		int max = 0;
		int count = 0;
		// read pattern
		System.out.print("Rainfall: ");
		double rainfall = In.nextDouble();

		// read loop pattern
		while (rainfall != -1) {
			if (rainfall == 0) {
				count++;
			}
			else if (rainfall > 0) {
				if (count > max) {
					max = count;
				}
				count = 0;
			}
			System.out.print("Rainfall: ");
			rainfall = In.nextDouble();
		}
		if (count > max) {
			max = count;
		}
		System.out.println("Longest dry spell = " + max);
	}
}
