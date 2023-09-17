package by.aleksandrphilimonov.restapidemo.controller;

import by.aleksandrphilimonov.restapidemo.dao.BookDAO;
import by.aleksandrphilimonov.restapidemo.dao.InMemoryBookDAO;
import by.aleksandrphilimonov.restapidemo.model.Book;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookDAO dao;

    public BookController() {
        this.dao = new InMemoryBookDAO();
    }

    @GetMapping("/")
    public List<Book> getAllBook() {
        return dao.findAll();
    }

    @GetMapping("/{id}")// api/books/1
    public Book findById(@PathVariable Integer id) {
        Optional<Book> optional = books.stream().filter(book -> book.getId() == id).findFirst();
        return optional.orElseGet(() -> books.stream().filter(book -> book.getId() == id).findFirst().get());
    }

    @PostMapping
    public void create(@Valid Book book) {
        //before we event get here
    }

    @PutMapping("/{id}")
    public void update(@Valid Book book) {
        //;update an existing book
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        //delete Book by id
    }

    public void findBookByAuthor() {

    }

}
