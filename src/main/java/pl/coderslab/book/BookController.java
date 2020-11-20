package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(@Qualifier("jpaBookService") BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping("")
    public List<Book> addBook(@RequestBody Book book) {
       bookService.addBook(book);
        return bookService.getBooks();
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable("bookId") long bookId) {
        return bookService.getBook(bookId);
    }

    @DeleteMapping("/{bookId}")
    public List<Book> deleteBook(@PathVariable("bookId") long bookId) {
        bookService.deleteBook(bookId);
        return bookService.getBooks();
    }

    @PutMapping("")
    public List<Book> updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        return bookService.getBooks();
    }


}