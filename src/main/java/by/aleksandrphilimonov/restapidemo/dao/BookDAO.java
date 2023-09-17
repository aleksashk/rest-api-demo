package by.aleksandrphilimonov.restapidemo.dao;

import by.aleksandrphilimonov.restapidemo.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDAO {
    Optional<Book> findById(int id);

    List<Book> findAll();

    long count();

    Book create(Book book);

    Book update(Book book);

    void delete(int id);
}
