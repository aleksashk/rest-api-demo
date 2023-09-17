package by.aleksandrphilimonov.restapidemo.dao;

import by.aleksandrphilimonov.restapidemo.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryBookDAO implements BookDAO {
    private List<Book> books = new ArrayList<>();

    public InMemoryBookDAO() {
        loadBooks();
    }

    private void loadBooks() {
        books.add(new Book(1,
                "Hacking with Spring Boot 2.3; Eactive Edition",
                "Greg l. Turnquist",
                "Amazon"));
        books.add(new Book(2,
                "Spring boot: Up and Runnitg",
                "Mark Heckler",
                "OReilly Media, Inc"));
    }

    @Override
    public Optional<Book> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Book create(Book book) {
        return null;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
