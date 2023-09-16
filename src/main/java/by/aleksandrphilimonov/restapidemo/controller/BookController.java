package by.aleksandrphilimonov.restapidemo.controller;

import by.aleksandrphilimonov.restapidemo.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final List<Book> books;

    public BookController() {
        this.books = List.of(
                new Book(1,
                "Hacking with Spring Boot 2.3; Eactive Edition",
                "Greg l. Turnquist",
                "Amazon"),
                new Book(2,
                        "Spring boot: Up and Runnitg",
                        "Mark Heckler",
                        "OReilly Media, Inc"));
    }

    @GetMapping("/")
    public List<Book> getAllBook() {
        return books;
    }

    @GetMapping("/{id}")// api/books/1
    public Book findById(@PathVariable Integer id){
        Optional<Book> optional = books.stream().filter(book -> book.getId() == id).findFirst();
        return optional.orElseGet(() -> books.stream().filter(book -> book.getId() == id).findFirst().get());
    }

}
