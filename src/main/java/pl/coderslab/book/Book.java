package pl.coderslab.book;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "books")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;

    public Book(String isbn, String title, String author, String publisher, String type) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.type = type;
    }

}
