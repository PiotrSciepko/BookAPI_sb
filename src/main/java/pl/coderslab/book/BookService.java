package pl.coderslab.book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    Book getBook(long id);
    void addBook(Book book);
    void deleteBook(long id);
    void updateBook(Book book);
}
