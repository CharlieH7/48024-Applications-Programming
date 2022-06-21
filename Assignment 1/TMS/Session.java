import java.util.*;
public class Session {

    private Faculties faculties;
    public Faculty faculty;
    public Students student;
    private Student s;
    private int i = 1;
    int counter = 0;
    ArrayList<TMS> tmslog = new ArrayList<TMS>();
    String recordID;
    TMS t;

    
    public Session() {
        faculties = new Faculties();
    }

    public static void main(String[] args) {
        Session session = new Session();
        session.loginMenu(session.faculties.faculties);
    }

    private Faculty login(ArrayList<Faculty> faculties, String email, String password) {
        for (Faculty item: faculties) {
            if (item.hasEmail(email) && item.hasPassword(password)) {
                return item;
            }
        }
        return null;
    }

    private Student matchStudent(ArrayList<Student> student, String name) {
        for (Student item: student) {
            if (item.hasName(name)) {
                return item;
            }
        }
        return null;
    }

    private void loginMenu(ArrayList<Faculty> faculties) {
        Utils.loginPrompt();
        char command = Utils.choice("Command (L/X)");
        while (command != 'X') {
            switch (command) {
                case 'L':
                    String email = Utils.string("Email");
                    String password = Utils.string("Password");
                    faculty = login(faculties, email, password);
                    if (faculty != null) {
                        use();
                        System.out.println();
                        System.out.println("TMS Tuition Management System:");
                        command = Utils.choice("Command (L/X)");
                        break;                    
                    }
                    else {
                        System.out.println("Incorrect faculty details!");
                        command = Utils.choice("Command (L/X)");
                        break;
                    }
                default:
                    Utils.loginPrompt();
                    command = Utils.choice("Command (L/X)");
            }
        }
        System.out.println();
        System.out.println("Session Terminated!");
    }


    private void use() {
        char commands;
        student = new Students();
        menu();
        System.out.print("Session Admin: " + faculty.getName());
        commands = Utils.choice(" - Menu Commands (C/R/U/D/V/T/X)");
        while (commands!= 'X') {
            switch (commands) {
                case 'C':
                    add();
                    break;
                case 'R':
                    view();
                    break;
                case 'U':
                    update();
                    break;
                case 'D':
                    delete();
                    break;
                case 'V':
                    Utils.studentHeader();
                    for (Student s: student.students) {
                        System.out.format(Utils.studentFormat, s.getName(), s.getEmail(), s.getPhone(), s.getType());
                    }
                    System.out.format("+----------------------+---------------------------+------------+------------+%n");
                    break;
                case 'T':
                    useTMSmenu();
                    break;
                default:
                    menu();
            }
            System.out.print("Session Admin: " + faculty.getName());
            commands = Utils.choice(" - Menu Commands (C/R/U/D/V/T/X)");
        }
    }

    private void useTMSmenu() {
        char commands;
        tmsMenu();
        System.out.print("Session Admin: " + faculty.getName());
        commands = Utils.choice(" - Menu Commands (F/V/A/R/S/X)");
        while (commands!= 'X') {
            switch (commands) {
                case 'F':
                    viewTuitionSlip();
                    break;
                case 'V':
                    viewTMSReport();
                    break;
                case 'A':
                    archieve();
                    break;
                case 'R':
                    retrieve();
                    break;
                case 'S':
                    showTMSlog();
                    break;
                default:
                    tmsMenu();
            }
            System.out.print("Session Admin: " + faculty.getName());
            commands = Utils.choice(" - Menu Commands (F/V/A/R/S/X)");
        }
        System.out.println();
        System.out.println("Faculty Menu:");
    }

    private void add() {
        String name = Utils.string("Name");
        String email = Utils.string("Email");
        String phone = Utils.string("Phone");
        String address = Utils.string("Address");
        String id = Utils.string("ID");
        String type = Utils.string("Type");
        int credits = Utils.number("Credits");
        double scholarship = Utils.amount("Scholarship($)");
        String deductionCode = Utils.string("Deduction Code");
        student.students.add(new Student(name, email, phone, address, id, type, credits, scholarship,  deductionCode));
        System.out.println(name + " record has been created.");
    }

    private void view() {
        String name = Utils.string("Name");
        s = matchStudent(student.students, name);
        if (s != null) {
            Utils.studentHeader();
            System.out.format(Utils.studentFormat, s.getName(), s.getEmail(), s.getPhone(), s.getType());
            System.out.format("+----------------------+---------------------------+------------+------------+%n");
        }
        else {
            System.out.println(name + " record does not exist!");
        }
    }

    public void update() {
        String name = Utils.string("Name");
        s = matchStudent(student.students, name);
        if (s != null){
            System.out.println("Updating " + name + " record: ");
            String name1 = Utils.string("Name");
            String email = Utils.string("Email");
            String phone = Utils.string("Phone");
            String address = Utils.string("Address");
            String type = Utils.string("Type");
            int credits = Utils.number("Credits");
            double scholarship = Utils.amount("Scholarship($)");
            String deductionCode = Utils.string("Deduction Code");
            s.changeName(name1);
            s.changeEmail(email);
            s.changePhone(phone);
            s.changeAddress(address);
            s.changeType(type);
            s.changeCredits(credits);
            s.changeScholarship(scholarship);
            s.changeDeductionCode(deductionCode);
            System.out.println(name + " record has been updated.");
        }
        
    }

    private void delete() {
        String name = Utils.string("Name");
        s = matchStudent(student.students, name);
        if (s == null) {
            System.out.println(name + " record does not exist!");
        }
        for (Student s: student.students) {
            if (s != null) {
                if (s.hasName(name)) {
                    student.students.remove(s);
                    System.out.println(name + " record has been deleted.");
                    break;
                }
            }
        }
       
    }

    private void viewTMSReport() {
        System.out.println("TMS Report: ");
        Utils.slipHeader();
        double scholarshipSum = 0;
        double netFeeSum = 0;
        double deductionSum = 0;
        double basFeeSum = 0;
        double tuitionSum = 0;
        for (Student s: student.students) {
            tuitionSum += s.getTotalFee();
            scholarshipSum += s.getScholarship();
            netFeeSum += s.getNetFee();
            deductionSum += s.getDeduction();
            basFeeSum += s.getBasFee();
            System.out.format(Utils.tmsFormat, s.getName(), s.getTotalFee(), s.getScholarship(), s.getNetFee(), s.getDeduction());
        }
        System.out.format("+--------------------+-------------+-------------+-------------+-------------+%n");
        System.out.println();
        System.out.format("+--------------------+-------------+%n");
        System.out.format(Utils.sumFormat, "Total Tuition", tuitionSum);
        System.out.format(Utils.sumFormat, "Total Scholarship", scholarshipSum);
        System.out.format(Utils.sumFormat, "Total NetFee", netFeeSum);
        System.out.format(Utils.sumFormat, "Total Deduction", deductionSum);
        System.out.format(Utils.sumFormat, "Total Bas", basFeeSum);
        System.out.format("+--------------------+-------------+%n");
    }

    private void viewTuitionSlip() {
        String name = Utils.string("Name");
        s = matchStudent(student.students, name);
        if (s != null) {
            System.out.println("Tuition Slip:");
            Utils.slipHeader();
            System.out.format(Utils.tmsFormat, s.getName(), s.getTotalFee(), s.getScholarship(), s.getNetFee(), s.getDeduction());
            System.out.format("+--------------------+-------------+-------------+-------------+-------------+%n");
        }
        else {
            System.out.println("Tuition slip does not exist for " + name + "!");
        }
    }

    private void archieve() {
        recordID = faculty.getName() + i;
        System.out.println("TMS record is created as:" + recordID);  
        i += 1;  
        counter += 1;
        tmslog.add(new TMS(counter,student, faculty, recordID));
        if (i > 2) {
           TMS currentOne = tmslog.get(counter - 1);  
           TMS previousOne = tmslog.get(counter - 2);
        //    System.out.println(currentOne);
        //    System.out.println(previousOne);
           if (currentOne.students.equals(previousOne.students)) {
               previousOne.recordID = currentOne.recordID;
           }
        }
    }

    private void showTMSlog() {
        System.out.println("TMS Archive:");
        Utils.logHeader();
        for (TMS t: tmslog) {
            System.out.format(Utils.logFormat, "TMS " + t.counter, t.recordID);
        }
        
        System.out.println("+--------------+----------------+");
    }

    private TMS matchTMS(ArrayList<TMS> tmslog, String recordID) {
        for (TMS item: tmslog) {
            if (item.hasRecordID(recordID)) {
                return item;
            }
        }
        return null;
    }

    private void retrieve() {
        boolean flag = false;
        String ID = Utils.string("RecordID");
        
        for(TMS t: tmslog) {
           if ((ID.equals(t.recordID))) {
                flag = true;
                System.out.println("TMS Report: ");
                Utils.slipHeader();
                double tuitionSum = 0;
                double scholarshipSum = 0;
                double netFeeSum = 0;
                double deductionSum = 0;
                double basFeeSum = 0;
                this.t = matchTMS(tmslog, ID);
                if (t != null) {
                    for (Student s: this.t.students.students) {
                        tuitionSum += s.getTotalFee();
                        scholarshipSum += s.getScholarship();
                        netFeeSum += s.getNetFee();
                        deductionSum += s.getDeduction();
                        basFeeSum += s.getBasFee();
                        System.out.format(Utils.tmsFormat, s.getName(), s.getTotalFee(), s.getScholarship(), s.getNetFee(), s.getDeduction());
                    }
                }

                System.out.format("+--------------------+-------------+-------------+-------------+-------------+%n");
                System.out.println();
                System.out.format("+--------------------+-------------+%n");
                System.out.format(Utils.sumFormat, "Total Tuition", tuitionSum);
                System.out.format(Utils.sumFormat, "Total Scholarship", scholarshipSum);
                System.out.format(Utils.sumFormat, "Total NetFee", netFeeSum);
                System.out.format(Utils.sumFormat, "Total Deduction", deductionSum);
                System.out.format(Utils.sumFormat, "Total Bas", basFeeSum);
                System.out.format("+--------------------+-------------+%n");
                break;
           }
        }
        if (flag == false) {
            System.out.println("No TMS is recorded as: " + ID);
        }
    }

    private void menu() {
        System.out.println("Admin Menu: ");
        System.out.println("C- Add Student");
        System.out.println("R- View Student");
        System.out.println("U- Update Student");
        System.out.println("D- Delete Student");
        System.out.println("V- View Students");
        System.out.println("T- TMS Menu");
        System.out.println("X- Logout");
    }  

    private void tmsMenu() {
        System.out.println("TMS Menu: ");
        System.out.println("F- Find Tuition Slip");
        System.out.println("V- View TMS Report");
        System.out.println("A- Archive TMS Report");
        System.out.println("R- Retrieve TMS Report");
        System.out.println("S- Show TMS Log");
        System.out.println("X- Close");
    } 

}
