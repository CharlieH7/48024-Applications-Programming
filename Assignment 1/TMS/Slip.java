import java.util.ArrayList;

public class Slip {

    private String name;
    private double totalFee;
    private double scholarship;
    private double netFee;
    private double deduction;
    private double bas;
    private Students student = new Students();

    public Slip(ArrayList<Student> student) {
        for (Student s: student) {
            this.name = s.getName();
            this.totalFee = s.getTotalFee();
            this.scholarship = s.getScholarship();
            this.netFee = s.getNetFee();
            this.deduction = s.getDeduction();
        }
    }

    public String getName() {
        return this.name;
    }

    public double getTotalFee() {
        return this.totalFee;
    }

    public double getScholarship() {
        return this.scholarship;
    }

    public double getNetFee() {
        return this.netFee;
    }

    public double getDeduction() {
        return this.deduction;
    }

}
