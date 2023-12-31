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
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public long count() {
        return books.size();
    }

    @Override
    public Book create(Book book) {
        book.setId((int) count() + 1);
        books.add(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        for (Book b : books) {
            if(b.getId()==book.getId()){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
                b.setPublisher(book.getPublisher());
            }
            break;
        }
        return book;
    }

    @Override
    public void delete(int id) {
        books.remove(id);
    }
}
