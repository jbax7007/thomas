package thomas777.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import thomas777.domain.Tag;
import thomas777.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface VideoDao extends JpaRepository<Video, Long>, JpaSpecificationExecutor<Video> {

    @Query(value = "select * from t_video a order by a.date desc limit :perpage offset (:page * :perpage)", nativeQuery = true)
    List<Video> findAllVideos(@Param("page") long page,@Param("perpage") long perpage);//used for video screen
    @Query(value = "select * from t_video a inner join t_video_details b on a.id = b.video_id where b.tagid = :tag order by a.date desc limit :perpage offset (:page * :perpage)", nativeQuery = true)
    List<Video> findVideosByTag(@Param("tag") long tag, @Param("page") long page,@Param("perpage") long perpage);//used for video screen

    @Query(value = "select videoID from t_video where videoTitle = :title")
    long findVideoID(@Param("title") String title);

    @Query(value = "select * from t_video a order by a.date desc limit :n", nativeQuery = true)
    List<Video> findRecentVideos(@Param("n") long n);

}