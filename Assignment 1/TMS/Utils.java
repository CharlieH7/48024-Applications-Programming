import java.util.*;


public class Utils{
    private static final Scanner scanner = new Scanner(System.in);
    public static final String tmsFormat = "| %-18s | %-11.2f | %-11.2f | %-11.2f | %-11.2f |%n";
    public static final String studentFormat = "| %-20s | %-25s | %-10s | %-10s |%n";
    public static final String sumFormat = "| %-18s |  %-9.2f  |%n";
    public static final String logFormat = "| %-12s |  %-9s   |%n";
    
    
    public static String string(String prompt){
        System.out.print(prompt+": ");
        return scanner.nextLine();
    }
    
    public static char choice(String prompt){
        System.out.print(prompt+": ");
        return scanner.nextLine().charAt(0);
    }
    
    public static double amount(String prompt){
        System.out.print(prompt+": ");
        double value = scanner.nextDouble();
	    scanner.nextLine();
	    return value;
        
    }
    
    public static boolean check(String prompt){
        System.out.print(prompt+": ");
        String s=scanner.nextLine();
        if (!s.equals("2022AUT"))//promo code
           return false;
        else 
           return true;
    }
    
    public static int number(String prompt){
        System.out.print(prompt+": ");
        int value = scanner.nextInt();
		scanner.nextLine(); 
		return value;
    }
    
    public static String formattedValue(String symbol, double value){
        return String.format(symbol+"%.2f", value);
    }

    public static void loginPrompt() {
        System.out.println("Tuition Management System:");
        System.out.println("L- Login");
        System.out.println("X- Exit");
    }
    
    public static void studentHeader( ){
         System.out.format("+----------------------+---------------------------+------------+------------+%n");
         System.out.format("| Student Name         | Email                     |  Phone     | Type       |%n");
         System.out.format("+----------------------+---------------------------+------------+------------+%n");
    }
    public static void slipHeader( ){
         System.out.format("+--------------------+-------------+-------------+-------------+-------------+%n");
         System.out.format("| Student Name       |   Tuition   | Scholarship |     Net     |  Deduction  |%n");
         System.out.format("+--------------------+-------------+-------------+-------------+-------------+%n");
    }
    public static void logHeader( ){
         System.out.format("+--------------+----------------+%n");
         System.out.format("|  TMS Record  |    RecordID    |%n");
         System.out.format("+--------------+----------------+%n");
    }
       
}
