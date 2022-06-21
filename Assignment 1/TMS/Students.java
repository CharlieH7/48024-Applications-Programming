
import java.util.ArrayList;

public class Students {

    public ArrayList<Student> students;

    public Students () {
        students = new ArrayList<Student>();
        students.add(new Student("Thomas Muller", "thomas.muller@uts.com", "99991111", "3 Byern St. Sydney 2001", "13697480", "Full-Time", 48, 4000, "null"));
        students.add(new Student("Alice Stefan", "alice.stefan@uts.com", "88881111", "24 Pitt St. Sydney 2001", "14517880", "Part-Time", 24, 0, "null"));
        students.add(new Student("Lucy Lu", "lucy.lu@uts.com", "98981100", "11 Hunter St. Sydney 2100", "13267102", "Full-Time", 48, 0, "2022AUT"));
        students.add(new Student("Andreas Brehme", "andreas.b@uts.com", "90001222", "91 Sussex St. Sydney 2100", "13678020", "Full-Time", 48, 0, "null"));
        students.add(new Student("Ruddy Voller", "ruddy.v@uts.com", "98980000", "15 Stan St. Sydney 2100", "13972870", "Full-Time", 48, 8000, "null"));
        students.add(new Student("Monica Shwarz", "monica.s@uts.com", "92241188", "155 Jones St. Sydney 2001", "13859610", "Part-Time", 24, 0, "2022AUT"));
    }

    public String getName() {
        String name = "";
        for (Student s: students) {
            name = s.getName();
        }
        return name;
    }
    
}
