package thomas777.service;

import thomas777.domain.Article;

import java.util.List;

public interface ArticleService {
    long numberOfArticles();
    List<Article> findAllArticles();

    void save(Article article);
}
