public class Faculty {

    // class fields
    private String name;
    private String email;
    private String password;
    private Students students;
    private TMSLog tmsLog;

    /*The Faculty constructor takes three parameters, the name, email, and password,
      corresponding to the three fields identically named. 
      Other fields require no parameters but the
      constructor methods.*/
    public Faculty(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        students = new Students();
        tmsLog = new TMSLog();
    }

    // return true if email in the parameters is the same as the fields of the class
    public boolean hasEmail(String email) {
        return this.email.equals(email);
    }

    // return true if password in the parameters is the same as the fields of the class
    public boolean hasPassword(String password) {
        return this.password.equals(password);
    }

    // getter (email)
    public String getEmail() {
        return this.email;
    }

    // getter (password)
    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;
    }

    // override the toString method
    @Override
    public String toString() {
        return this.name + ", " + this.email + ", " + this.password;
    }
}
