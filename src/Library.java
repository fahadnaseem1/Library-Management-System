import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<Integer, Member> members = new HashMap<>();
    private final Map<Integer, Book> books = new HashMap<>();

    public void addBook(Book book){
        if(books.containsKey(book.getBookId())){
            throw new IllegalStateException("book with ID " + book.getBookId()+ " already exist");
        }
        books.put(book.getBookId(), book);
    }

    public void removeBook(int bookId){
        Book book = books.get(bookId);

        if(book == null ){
            throw new IllegalStateException("book with ID " + bookId + " does not exist");
        }
        if(book.getStatus() == BookStatus.BORROWED){
            throw new IllegalStateException("book with ID "+ bookId +" is borrowed ");
        }
        books.remove(bookId);
    }

    public Book findBook(int bookId) {
        return books.get(bookId);
    }

    public void registerMember(Member member){
        if(members.containsKey(member.getMemberId())){
            throw new IllegalStateException("member with ID "+ member.getMemberId()+" already exist");
        }
        members.put(member.getMemberId(), member);
    }

    public void removeMember(int memberId){
        Member member = members.get(memberId);

        if(member == null ){
            throw new IllegalStateException("member with ID " + memberId + " does not exist");
        }
        if(member.getBorrowedBookCount() > 0){
            throw new IllegalStateException("member with ID "+ memberId + " has borrowed books");
        }
        members.remove(memberId);
    }

    public Member findMember(int memberId){
        return members.get(memberId);
    }
}
