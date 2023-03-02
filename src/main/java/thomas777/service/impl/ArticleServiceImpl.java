package thomas777.service.impl;

import thomas777.dao.ArticleDao;
import thomas777.domain.Article;
import thomas777.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private ArticleDao articleDao;

    @Override
    public void save(Article article) {
        articleDao.save(article);
    }

    @Override
    public List<Article> findAllArticles() {
        return articleDao.findAll();
    }

    @Override
    public long numberOfArticles() {
        return articleDao.count();
    }



}
