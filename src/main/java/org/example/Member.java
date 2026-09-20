package org.example;

public class Member {
    private String name;
    private int idNumber;
    private int activeLoans;

    public Member() {
        name = "Undeclared";
        idNumber = 0;
        activeLoans = 0;

    }

    public Member(String name, int idNumber){
        this.name = name;
        this.idNumber = idNumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getActiveLoans() {
        return activeLoans;
    }

    public void setActiveLoans(int activeLoans) {
        this.activeLoans = activeLoans;
    }
}
