package thomas777.service;

import thomas777.domain.Book;

import java.util.List;

public interface BookService {
    long numberOfBooks();
    List<Book> findAllBooks();

    void save(Book book);
}
