import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem {

    static class Book {
        Long id;
        String title;
        boolean available;
    }

    static class Member {
        Long id;
        String name;
    }

    static class Loan {
        Long id;
        Long memberId;
        Long bookId;
        boolean returned;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Book> books = new ArrayList<>();
        List<Member> members = new ArrayList<>();
        List<Loan> loans = new ArrayList<>();

        Long loanSequence = 1L;

        while (true) {

            System.out.println("\n===== LIBRARY SYSTEM =====");
            System.out.println("1. Register Book");
            System.out.println("2. Register Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show Books");
            System.out.println("6. Show Members");
            System.out.println("7. Show Loans");
            System.out.println("0. Exit");
            System.out.print("Option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:

                    System.out.print("Book Id: ");
                    Long bookId = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Title: ");
                    String title = scanner.nextLine();

                    Book book = new Book();
                    book.id = bookId;
                    book.title = title;
                    book.available = true;

                    books.add(book);

                    System.out.println("Book registered successfully.");
                    break;

                case 2:

                    System.out.print("Member Id: ");
                    Long memberId = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    Member member = new Member();
                    member.id = memberId;
                    member.name = name;

                    members.add(member);

                    System.out.println("Member registered successfully.");
                    break;

                case 3:

                    System.out.print("Member Id: ");
                    Long borrowMemberId = scanner.nextLong();

                    System.out.print("Book Id: ");
                    Long borrowBookId = scanner.nextLong();

                    member = null;

                    for (Member currentMember : members) {
                        if (currentMember.id.equals(borrowMemberId)) {
                            member = currentMember;
                            break;
                        }
                    }

                    if (member == null) {
                        System.out.println("Member not found.");
                        break;
                    }

                    Book selectedBook = null;

                    for (Book currentBook : books) {
                        if (currentBook.id.equals(borrowBookId)) {
                            selectedBook = currentBook;
                            break;
                        }
                    }

                    if (selectedBook == null) {
                        System.out.println("Book not found.");
                        break;
                    }

                    if (!selectedBook.available) {
                        System.out.println("Book is already borrowed.");
                        break;
                    }

                    Loan loan = new Loan();
                    loan.id = loanSequence++;
                    loan.memberId = borrowMemberId;
                    loan.bookId = borrowBookId;
                    loan.returned = false;

                    loans.add(loan);

                    selectedBook.available = false;

                    System.out.println("Book borrowed successfully.");
                    break;

                case 4:

                    System.out.print("Loan Id: ");
                    Long loanId = scanner.nextLong();

                    Loan selectedLoan = null;

                    for (Loan currentLoan : loans) {
                        if (currentLoan.id.equals(loanId)) {
                            selectedLoan = currentLoan;
                            break;
                        }
                    }

                    if (selectedLoan == null) {
                        System.out.println("Loan not found.");
                        break;
                    }

                    if (selectedLoan.returned) {
                        System.out.println("Loan already returned.");
                        break;
                    }

                    Book borrowedBook = null;

                    for (Book currentBook : books) {
                        if (currentBook.id.equals(selectedLoan.bookId)) {
                            borrowedBook = currentBook;
                            break;
                        }
                    }

                    if (borrowedBook == null) {
                        System.out.println("Book not found.");
                        break;
                    }

                    selectedLoan.returned = true;
                    borrowedBook.available = true;

                    System.out.println("Book returned successfully.");
                    break;

                case 5:

                    System.out.println("\n--- BOOKS ---");

                    for (Book currentBook : books) {
                        System.out.println(
                                "Id: " + currentBook.id +
                                        ", Title: " + currentBook.title +
                                        ", Available: " + currentBook.available
                        );
                    }

                    break;

                case 6:

                    System.out.println("\n--- MEMBERS ---");

                    for (Member currentMember : members) {
                        System.out.println(
                                "Id: " + currentMember.id +
                                        ", Name: " + currentMember.name
                        );
                    }

                    break;

                case 7:

                    System.out.println("\n--- LOANS ---");

                    for (Loan currentLoan : loans) {
                        System.out.println(
                                "Loan Id: " + currentLoan.id +
                                        ", Member Id: " + currentLoan.memberId +
                                        ", Book Id: " + currentLoan.bookId +
                                        ", Returned: " + currentLoan.returned
                        );
                    }

                    break;

                case 0:

                    System.out.println("Goodbye.");
                    scanner.close();
                    return;

                default:

                    System.out.println("Invalid option.");
            }
        }
    }
}