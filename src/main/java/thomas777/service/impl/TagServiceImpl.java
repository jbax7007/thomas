package thomas777.service.impl;

import org.springframework.data.repository.query.Param;
import thomas777.dao.TagDao;
import thomas777.domain.Tag;
import thomas777.domain.TagType;
import thomas777.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;


@Service
public class TagServiceImpl implements TagService {


    @Autowired
    private TagDao tagDao;

    @Override
    public void save(Tag tag) {
        tagDao.save(tag);
    }

    @Override
    public List<Tag> findAllTags() {
        return tagDao.findAll();
    }

    @Override
    public List<Tag> findTagsByType(String type) { return tagDao.findTagsByTagType(type); }

    @Override
    public String findTagName(int tagID){ return  tagDao.findTagName(tagID); }

    @Override
    public List<Tag> findTagsByTypeTo(int typeID, int n){ return  tagDao.findTagsByTagTypeTop(typeID, n);}

    @Override
    public List<Tag> findTagsByTypeFrom(int typeID, int n){ return tagDao.findTagsByTagTypeExcess(typeID, n);}
    @Override
    public long numberOfTags() {
        return tagDao.count();
    }



}