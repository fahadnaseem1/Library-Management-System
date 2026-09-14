public class Book {

    private final int bookId;
    private final String title;
    private final String author;
    private BookStatus status = BookStatus.AVAILABLE;
    
    public String getAuthor() {
        return author;
    }

    public BookStatus getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public int getBookId() {
        return bookId;
    }

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public void markAsBorrowed(){
        status = BookStatus.BORROWED;
    }

    public void markAsAvailable(){
        status = BookStatus.AVAILABLE;
    }
}
