public class NumberToWords {
	public static void main(String[] args) {
		String[] oneToNineteen = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "tweleve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		String[] twentyToNinety = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		System.out.print("Number: ");
		int number = In.nextInt();
		int num3 = number % 10;
		int num2 = (number % 100)/10;
		int num1 = (number % 1000)/100;
		int LastTwoDigit = number % 100;
		// System.out.println(LastTwoDigit);
		while (number != -1) {
			// cases when the number is 0
			if (number == 0) {
				String zero = "zero";
				System.out.println(zero.trim());
			}
			else if (number < 20) {
				String a = oneToNineteen[number];
				System.out.println(a.trim());
			}
			else if (number >= 20 && number < 100) {
				String b = twentyToNinety[num2] + " " + oneToNineteen[num3];
				System.out.println(b.trim());
			}
			else if (number > 99 && number < 1000) {
				if (num2 == 0 && num3 == 0) {
					String c = oneToNineteen[num1] + " hundred";
					System.out.println(c.trim());
				}
				else {
					if (LastTwoDigit < 20) {
						String d = oneToNineteen[num1] + " hundred and " + oneToNineteen[LastTwoDigit];
						System.out.println(d.trim());
					}
					else if (LastTwoDigit >= 20 && LastTwoDigit < 100) {
						String e = oneToNineteen[num1] + " hundred and " + twentyToNinety[num2] + " " + oneToNineteen[num3];
						System.out.println(e.trim());
					}
						
				}
				
			}
			System.out.print("Number: ");
			number = In.nextInt();
			LastTwoDigit = number % 100;
			num3 = number % 10;
			num2 = (number % 100)/10;
			num1 = (number % 1000)/100;
		}
		
		if (number == -1) {
			System.out.println("Done");
		}
		
	}
}
