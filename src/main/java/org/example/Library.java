package org.example;

import java.awt.print.Book;

public class Library {
    private Member[] members = new Member[10];
    private int memberCount = 0;

    private Book[] books = new Book[10];
    private int bookCount = 0;

    private Loan[] activeLoans = new Loan[10];
    private int loanCount = 0;

    public boolean isBookAvailable(String isbn) {
        for (int i = 0; i < loanCount; i++) {
            if (activeLoans[i].isbn().equals(isbn)) {
                return false;
            }
        }
        return true;
    }

    public void borrowBook(int idNumber, String isbn){
        if (!isBookAvailable(isbn)){
            IO.println("Sorry " + title + " is not available for borrowing.");
            return;
        }
    }

    public void registerNewMember(String name, int idNumber) {
        if (memberCount >= members.length) {
            Member[] members2 = new Member[members.length * 2];
            for (int i = 0; i < members.length; i++) {
                members2[i] = members[i];
            }
            members = members2;
        }
        if (idNumber < 1000 || idNumber > 9999) {
            IO.println("Invalid ID number. Please choose a 4-digit pin.");
            return;
        }
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getIdNumber() == idNumber) {
                IO.println("Member with ID number " + idNumber + " already exists. Please choose a different ID number.");
                return;
            }
        }
        Member newMember = new Member(name, idNumber);
        members[memberCount] = newMember;
        memberCount++;

        IO.println("Member " + name + " with ID number " + idNumber + " has been registered.");
    }

    public Member findMemberById(int idNumber) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getIdNumber() == idNumber) {
                return members[i];
            }
        }
        return null;
    }

    public void loanBook(String title, int id) {
    }

    public void returnLoanedBook(String title, int id) {
    }
}

record book(String isbn, String title, String author) {
}
