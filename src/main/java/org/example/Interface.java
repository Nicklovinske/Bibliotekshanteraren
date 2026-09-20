package org.example;

public interface Interface {
    static void main(){
        IO.print("Welcome to the archives of Minas Tirith.");
        IO.print("Enter 1 if you are an existing member: ");
        if (Integer.parseInt(IO.readln()) == 1){
            IO.print("Enter your ID number: ");
            int idNumber = Integer.parseInt(IO.readln());
            Member member = new Member(name, idNumber);
            IO.print("Welcome back, " + member.getName() + "!");
        }
        IO.println("Enter 2 if you are a new member: ");
    }
}
