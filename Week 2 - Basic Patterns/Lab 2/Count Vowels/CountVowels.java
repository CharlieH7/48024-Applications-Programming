public class CountVowels {
	public static void main(String[] args) {
		// write your solution here
		// read pattern
		System.out.print("Character: ");
		char character = In.nextChar();
		int count = 0;

		// read loop pattern
		while (character != '.')
		{
			System.out.print("Character: ");
			character = In.nextChar();
			// if character is a vowel then increment the count
			if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') 
			{
				count++;
			}
		}

		// output pattern
		System.out.println("Vowel count = " + count);
	}
}
