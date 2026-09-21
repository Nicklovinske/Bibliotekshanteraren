package org.example;

import java.util.Scanner;

public class Interface {
    static void main(){
        Library library = new Library();
        Scanner scanner = new Scanner(IO.readln());
        boolean running = true;

        IO.println("Welcome to the archives of Minas Tirith.");

        while (running){
            IO.println("\n--- Main Menu ---");
            IO.println("1. Add a book.");
            IO.println("2. Register member.");
            IO.println("3. Loan book.");
            IO.println("4. Return loaned book.");
            IO.println("5. Search for a book.");
            IO.println("6. List of all books.");
            IO.println("7. Exit.");
            IO.println("Please choose an option (1-7): ");

            int choice = Integer.parseInt(IO.readln());

            switch (choice){
                case 1:
                    IO.println("Enter the title of the book: ");
                    //Todo: prompt for bbook details and create library.addBook()
            }
        }

    }
}
