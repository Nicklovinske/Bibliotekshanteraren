package org.example;

public class Interface {
    static void main() {
        Library library = new Library();
        boolean running = true;

        IO.println("Welcome to the archives of Minas Tirith.");

        while (running) {
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

            switch (choice) {
                case 1:
                    IO.println("---Add New Book---");
                    IO.println("Enter the title of the book: ");
                    String title = IO.readln();
                    IO.println("Enter the author of the book: ");
                    String author = IO.readln();
                    IO.println("Enter the ISBN of the book: ");
                    String isbn = IO.readln();
                    library.addBook(title, author, isbn);
                    break;

                case 2:
                    IO.println("---Register New Member---");
                    IO.println("Enter name: ");
                    String name = IO.readln();
                    IO.println("Enter a 4-digit ID code. ");
                    int idNumber = Integer.parseInt(IO.readln());

                    library.registerNewMember(name, idNumber);
                    break;

                case 3:
                    IO.println("---Loan Book---");

                    IO.println("Enter your 4-digit ID code: ");
                    int borrowMemberId = Integer.parseInt(IO.readln());

                    IO.println("Enter the ISBN of the book you would like to loan: ");
                    String borrowIsbn = IO.readln();


                    library.borrowBook(borrowMemberId, borrowIsbn);
                    break;

                case 4:
                    IO.println("---Return Loaned Book---");
                    IO.println("Enter your 4-digit ID code: ");
                    int returnMemberId = Integer.parseInt(IO.readln());

                    IO.println("Enter the ISBN of the book you would like to return: ");
                    String returnIsbn = IO.readln();

                    library.returnBook(returnMemberId, returnIsbn);
                    break;

                case 5:
                    IO.println("--- Search for a Book ---");
                    IO.println("Enter an author or title to search: ");
                    String query = IO.readln();
                    library.searchBooks(query);
                    break;

                case 6:
                    IO.println("--- Check Inventory ---");
                    library.listAllBooks();
                    break;

                case 7:
                    IO.println("--- Exit ---");
                    running = false;
                    break;

                default:
                    IO.println("Invalid option. Please enter a number between 1 and 7.");
            }
        }

    }
}
