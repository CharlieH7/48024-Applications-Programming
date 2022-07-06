public class ZCount {
    public static void main(String[] args) {
        System.out.println("z count = " + zCount(readString()));
    }

    public static String readString() {
        System.out.print("String: ");
        return In.nextLine();
    }

    public static int zCount(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'z' || s.charAt(i) == 'Z') {
                count++;
            }  
        }
        return count; 
    }
}
