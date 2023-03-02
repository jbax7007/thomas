package thomas777.service;

import org.springframework.data.repository.query.Param;
import thomas777.domain.TagType;

import java.util.List;

public interface TagTypeService {
    long numberOfTagTypes();
    List<TagType> findAllTagTypes();


    void save(TagType tagType);
}
