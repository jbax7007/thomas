package thomas777.service.impl;

import thomas777.dao.TagTypeDao;
import thomas777.domain.TagType;
import thomas777.service.TagTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;


@Service
public class TagTypeServiceImpl implements TagTypeService {


    @Autowired
    private TagTypeDao tagTypeDao;

    @Override
    public void save(TagType tagType) {
        tagTypeDao.save(tagType);
    }

    @Override
    public List<TagType> findAllTagTypes() {
        return tagTypeDao.findAll();
    }

    @Override
    public long numberOfTagTypes() {
        return tagTypeDao.count();
    }

}