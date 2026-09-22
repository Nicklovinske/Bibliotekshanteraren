package org.example;

import java.time.LocalDate;

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

    public void addBook(String isbn, String title, String author){
        if (bookCount >= books.length) {
            Book[] books2 = new Book[books.length * 2];
            for (int i = 0; i < books.length; i++) {
                books2[i] = books[i];
            }
            books = books2;
        }
        for (int i = 0; i < bookCount; i++){
            if (books[i].isbn().equals(isbn)) {
                IO.println("Book with ISBN " + isbn + " already exists.");
                return;
            }
        }
        books[bookCount] = new Book(isbn, title, author);
        bookCount++;

        IO.println("Book added successfully.");
    }

    public void borrowBook(int idNumber, String isbn, String title){
        if (!isBookAvailable(isbn)){
            IO.println("Sorry " + title + " is not available for borrowing.");
            return;
        }

        Member member = findMemberById(idNumber);
        if (member == null) {
            IO.println("Member with ID number " + idNumber + " does not exist.");
            return;
        }

        if (loanCount >= activeLoans.length) {
            Loan[] activeLoans2 = new Loan[activeLoans.length * 2];
            for (int i = 0; i < activeLoans.length; i++) {
                activeLoans2[i] = activeLoans[i];
            }
            activeLoans = activeLoans2;
        }

        activeLoans[loanCount] = new Loan(idNumber, isbn);
        loanCount++;

        member.setActiveLoans(member.getActiveLoans() + 1);

        IO.println("Fantastic! Book loaned to " + member.getName() + ". Please return by " + LocalDate.now().plusDays(14));
    }

    public void returnBook (int idNumber, String isbn, String title) {
        for (int i = 0; i < loanCount; i++) {
            if (activeLoans[i].isbn().equals(isbn) && activeLoans[i].idNumber() == idNumber) {
                Member member = findMemberById(idNumber);
                if (member != null) {
                    member.setActiveLoans(member.getActiveLoans() - 1);
                }
                activeLoans[i] = activeLoans[loanCount - 1];
                activeLoans[loanCount - 1] = null;
                loanCount--;
                IO.println("Thank you for returning " + title + ".");
                return;
            }
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

