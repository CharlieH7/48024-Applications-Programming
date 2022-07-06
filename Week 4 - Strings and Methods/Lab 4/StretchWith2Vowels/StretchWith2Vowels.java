import java.util.*;

public class StretchWith2Vowels {
    public static void main(String[] args) {

        // merged read loop
        String sentence;
        while (!(sentence = readSentence()).equals("*")) {
            System.out.println(output(sentence));
        }
        // if the input = * then print Done
        System.out.println("Done");
    }

    // read method
    public static String readSentence() {
        System.out.print("Sentence: ");
        return In.nextLine();
    }
    
    // splitting the input sentence into an array of words
    public static int countTheNumberOfMatchingWords(String sentences) {
        int sum = 0;
        // split the whole sentence into an array of words (split by white spaces)
        for (String sentence: sentences.split(" ")) {
            // count the number of mathcing words if it satify the condition of exactly 2 vowel then it is a mathcing word and added to the sum
            if (check2Vowel(sentence)) {
                sum++;
            }
        }
        return sum;
    }

    // check if it contains exactly 2 vowel 
    public static boolean check2Vowel(String words) {
        words = words.toLowerCase();
        // whenever encounter 'z' split into an array of words and check with the method countVowel
        for(String word: words.split("z")) {
            if (countVowel(word) == 2) {
                return true;
            }
        }
        return false;
        
    }

    // count the number of vowels in the word 
    public static int countVowel(String word) {
        int count = 0;
        // convert the word to lowercase
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            String character = "" + word.charAt(i);
            // for each character in the word if it contains vowel add 1 to count
            if (containsVowel(character)) {
                count++;
            }
        }
        return count;
    }

    // if the word contains vowels return true
    public static boolean containsVowel(String word) {
        return word.toLowerCase().contains("a") || word.toLowerCase().contains("e") || word.toLowerCase().contains("i") || word.toLowerCase().contains("o") || word.toLowerCase().contains("u");
    }

    // return the output of the number of matching words
    public static String output(String sentence) {
        return "Matching words = " + countTheNumberOfMatchingWords(sentence);
    }
}
