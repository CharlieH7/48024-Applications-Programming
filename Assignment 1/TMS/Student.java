
public class Student {
    private String ID;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String type; 
    private int credits;
    private static double payPerCredit;
    private double totalFee;
    private double netFee;
    private double scholarship;
    private double deduction;
    private static double deductionRate;
    private Faculty faculty;
    private String deductionCode;
    private double baseFee;

    public Student(String name, String email, String phone, String address, String ID, String type, int credit, double scholarship, String deductionCode) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.ID = ID;
        this.type = type;
        this.credits = credit;
        this.scholarship = scholarship;
        this.deductionCode = deductionCode;
        this.payPerCredit = 500;
        this.totalFee = credits * payPerCredit;
        this.deductionRate = 0.10;
        if (this.deductionCode.equals("2022AUT")) {
            this.deduction = this.totalFee * this.deductionRate;
        }
        else {
            this.deduction = 0;
        }
        this.netFee = this.totalFee - this.deduction - this.scholarship;
        this.baseFee = this.scholarship + this.deduction;
    }

    public String getName() {
        return this.name;
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getType() {
        return this.type;
    }

    public String getAddress() {
        return this.address;
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

    public String getID(){
        return this.ID;
    }

    public int getCredit() {
        return this.credits;
    }

    public String getDeductionCode() {
        return this.deductionCode;
    }

    public double getBasFee() {
        return this.baseFee;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changeEmail(String email) {
        this.email = email;
    }

    public void changePhone(String phone) {
        this.phone = phone;
    }

    public void changeAddress(String address) {
        this.address = address;
    }

    public void changeID(String ID) {
        this.ID = ID;
    }

    public void changeType(String type) {
        this.type = type;
    }

    public void changeCredits(int credits) {
        this.credits = credits;
    }

    public void changeScholarship(double scholarship) {
        this.scholarship = scholarship;
    }

    public void changeDeductionCode(String deductionCode) {
        this.deductionCode = deductionCode;
    }

}
