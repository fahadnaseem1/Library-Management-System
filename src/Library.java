import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Integer, Member> members = new HashMap<>();
    private Map<Integer, Book> books = new HashMap<>();

    public void addBook(Book book){
        if(books.containsKey(book.getBookId())){
            throw new IllegalStateException("book with ID " + book.getBookId()+ " already exist");
        }
        books.put(book.getBookId(), book);
    }

    public void removeBook(int bookId){
        if(!books.containsKey(bookId)){
            throw new IllegalStateException("book with ID " + bookId + " does not exist");
        }
        Book book = books.get(bookId);
        if(book.getStatus() == BookStatus.BORROWED){
            throw new IllegalStateException("book with ID "+ bookId +" is borrowed ");
        }
        books.remove(bookId);
    }

    public Book findBook(int bookId) {
        return books.get(bookId);
    }
}
