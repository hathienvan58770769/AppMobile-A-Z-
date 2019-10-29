package hathienvan.firstapplication.vd77_transmitreceivestring;

import java.io.Serializable;

public class Student implements Serializable {
    private String fullName;
    private  int yearOld;

    public Student(String fullName, int yearOld) {
        this.fullName = fullName;
        this.yearOld = yearOld;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOld() {
        return yearOld;
    }

    public void setYearOld(int yearOld) {
        this.yearOld = yearOld;
    }
}
