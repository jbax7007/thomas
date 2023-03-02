package thomas777.service;

import thomas777.domain.Tag;
import thomas777.domain.TagType;

import java.util.List;

public interface TagService {
    long numberOfTags();
    List<Tag> findAllTags();
    List<Tag> findTagsByType(String type);

    List<Tag> findTagsByTypeTo(int typeID, int n);

    List<Tag> findTagsByTypeFrom(int typeID, int n);

    String findTagName(int tagID);

    void save(Tag tag);
}
