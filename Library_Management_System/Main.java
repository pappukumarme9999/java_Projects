import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Register Member");
            System.out.println("4. Remove Member");
            System.out.println("5. List Books");
            System.out.println("6. List Members");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter book author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter book ISBN: ");
                        String isbn = scanner.nextLine();
                        libraryService.addBook(new Book(title, author, isbn));
                        break;
                    case 2:
                        System.out.print("Enter book ISBN to remove: ");
                        String isbnToRemove = scanner.nextLine();
                        libraryService.removeBook(isbnToRemove);
                        break;
                    case 3:
                        System.out.print("Enter member name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter member ID: ");
                        int memberId = Integer.parseInt(scanner.nextLine());
                        libraryService.registerMember(new LibraryMember(name, memberId));
                        break;
                    case 4:
                        System.out.print("Enter member ID to remove: ");
                        int memberIdToRemove = Integer.parseInt(scanner.nextLine());
                        libraryService.removeMember(memberIdToRemove);
                        break;
                    case 5:
                        libraryService.listBooks();
                        break;
                    case 6:
                        libraryService.listMembers();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
