import java.util.List;

public class LibraryService {
    private BookDAO bookDAO;
    private LibraryMemberDAO memberDAO;

    public LibraryService() {
        bookDAO = new BookDAO();
        memberDAO = new LibraryMemberDAO();
    }

    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    public void removeBook(String isbn) {
        bookDAO.removeBook(isbn);
    }

    public void registerMember(LibraryMember member) {
        memberDAO.registerMember(member);
    }

    public void removeMember(int memberId) {
        memberDAO.removeMember(memberId);
    }

    public void listBooks() {
        List<Book> books = bookDAO.getAllBooks();
        System.out.println("Books in the library:");
        books.forEach(System.out::println);
    }

    public void listMembers() {
        List<LibraryMember> members = memberDAO.getAllMembers();
        System.out.println("Library members:");
        members.forEach(System.out::println);
    }
}
