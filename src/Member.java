import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {

    private final int memberId;
    private final String name;
    private final String email;
    private final List<Book> borrowedBooks = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public Member(int memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
    }

    public void addBorrowedBook(Book book) {
        if (hasBorrowedBook(book)) {
            throw new IllegalStateException("Member already has this book.");
        }
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book){
        borrowedBooks.remove(book);
    }

    public int getBorrowedBookCount(){
        return borrowedBooks.size();
    }

    public boolean hasBorrowedBook(Book book){
        for(Book x: borrowedBooks){
            if(x.getBookId() == book.getBookId()) {
                return true;
            }
        }
        return false;
    }

    public List<Book> getBorrowedBooks(){
        return Collections.unmodifiableList(borrowedBooks);

    }

}
