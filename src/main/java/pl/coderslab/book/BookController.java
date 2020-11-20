package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final MemoryBookService memoryBookService;

    @Autowired
    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Book> listAllBooks() {
        return memoryBookService.listAllBooks();
    }

    @PostMapping("")
    public List<Book> addBook(@RequestBody Book book) {
        memoryBookService.addBook(book);
        return memoryBookService.listAllBooks();
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable("bookId") long bookId) {
        return memoryBookService.getBook(bookId);
    }

    @DeleteMapping("/{bookId}")
    public List<Book> deleteBook(@PathVariable("bookId") long bookId) {
        memoryBookService.deleteBook(bookId);
        return memoryBookService.listAllBooks();
    }

    @PutMapping("")
    public List<Book> updateBook(@RequestBody Book book) {
        System.out.println("in put");
        memoryBookService.updateBook(book);
        return memoryBookService.listAllBooks();
    }


}