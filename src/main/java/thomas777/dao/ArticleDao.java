package thomas777.dao;

import thomas777.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface ArticleDao extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {
}


