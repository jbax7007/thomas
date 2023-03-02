package thomas777.service.impl;

import thomas777.dao.BookDao;
import thomas777.domain.Book;
import thomas777.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;


@Service
public class BookServiceImpl implements BookService {


    @Autowired
    private BookDao bookDao;

    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public long numberOfBooks() {
        return bookDao.count();
    }

}
