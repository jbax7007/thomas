package thomas777.dao;

import thomas777.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface BookDao extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
}

