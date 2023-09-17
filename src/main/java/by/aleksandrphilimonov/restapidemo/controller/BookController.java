package by.aleksandrphilimonov.restapidemo.controller;

import by.aleksandrphilimonov.restapidemo.dao.BookDAO;
import by.aleksandrphilimonov.restapidemo.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookDAO dao;

    public BookController(BookDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Book> findAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")// api/books/1
    public Book findById(@PathVariable Integer id) {
        return dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Book with id: " + id + " was not found."));
    }

    @PostMapping
    public void create(@RequestBody Book book) {
        dao.create(book);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Book book) {
        dao.update(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        dao.delete(id);
    }
}
