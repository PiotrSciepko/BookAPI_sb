package pl.coderslab.book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();
    Book getBook(long id);
    void addBook(Book book);
    void deleteBook(long id);
    void updateBook(Book book);
}
