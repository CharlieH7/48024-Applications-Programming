import java.util.ArrayList;

public class TMS {
    private double totalTuition;
    private double totalScholarship;
    private double totalNetFee;
    private double totalDeduction;
    private double bas;
    private String name;
    public Students students;
    public ArrayList<Slip> slips;
    public Faculty faculty;
    public String recordID;
    public int counter;
    public Student s;
    
    public TMS(int counter, Students students, Faculty faculty, String recordID) {
        this.counter = counter;
        this.students = students;
        this.faculty = faculty;
        this.recordID = recordID;
        for (Student s: students.students) {
            this.name = s.getName();
            this.totalTuition = s.getTotalFee();
            this.totalScholarship = s.getScholarship();
            this.totalNetFee = s.getNetFee();
            this.totalDeduction = s.getDeduction();
            this.bas = s.getBasFee();
        }
    }

    public String getName() {
        return this.faculty.getName();
    }

    public boolean hasRecordID(String recordID) {
        return this.recordID.equals(recordID);
    }

    public String getStudentName() {
        return this.name;
    }

    public double getTotalFee() {
        return this.totalTuition;
    }

    public double getScholarship() {
        return this.totalScholarship;
 
    }

    public double getNetFee() {
        return this.totalNetFee;
    }

    public double getDeduction() {
        return this.totalDeduction;
    
    }

    public double getBasFee() {
        for (Student s: students.students) {
            return s.getBasFee();
        }
        return 0.0;
    }

    public boolean compare(TMS other) {

        if (this.students != other.students) {
            return false;
        }
        if (this.faculty != other.faculty) {
            return false;
        }
        if (this.recordID != other.recordID) {
            return false;
        }
        return true;

    }
}
