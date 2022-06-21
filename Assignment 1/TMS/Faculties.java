import java.util.ArrayList;

public class Faculties {

    public ArrayList<Faculty> faculties;

    // The Faculties constructor initialize the ArrayList
    public Faculties () {
        faculties = new ArrayList<Faculty>();
        faculties.add(new Faculty("John Smith", "john.smith@uts.com", "user222"));
        faculties.add(new Faculty("Jane Tyler", "jane.tyler@uts.com", "super123"));
    }

   
}
