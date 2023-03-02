package thomas777.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import thomas777.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TagDao extends JpaRepository<Tag, Long>, JpaSpecificationExecutor<Tag> {

    @Query(value = "select * from t_tag a inner join t_tag_type b on a.typeid = b.id where b.name = :tagType", nativeQuery = true)
    List<Tag> findTagsByTagType(@Param("tagType") String tagType);//used for video screen


    @Query(value = "select a.id, a.name, a.typeID, count(a.id) as c from t_tag a inner join t_video_details c on a.id = c.tagid where a.typeid = :tagTypeID group by a.id order by count(a.id) desc limit :n offset 0 ", nativeQuery = true)
    List<Tag> findTagsByTagTypeTop(@Param("tagTypeID") int tagTypeID, @Param("n") int n);//used for video screen

    @Query(value = "select a.id, a.name from t_tag a inner join t_video_details c on a.id = c.tagid where a.typeid = :tagTypeID group by a.id order by count(a.id) desc offset :n", nativeQuery = true)
    List<Tag> findTagsByTagTypeExcess(@Param("tagTypeID") int tagTypeID, @Param("n") int n);//used for video screen

    @Query(value = "select a.name, b.name AS \"type\" from t_tag a inner join t_tag_type b on a.typeid = b.id where a.id = :tagID", nativeQuery = true)
    String findTagName(@Param("tagID") int tagID);//used for video screen

}