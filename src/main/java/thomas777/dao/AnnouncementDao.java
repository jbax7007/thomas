package thomas777.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import thomas777.domain.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import thomas777.domain.Article;
import thomas777.domain.Video;

import java.util.List;

public interface AnnouncementDao extends JpaRepository<Announcement, Long>, JpaSpecificationExecutor<Announcement> {

    @Query(value = "select * from t_announcement a order by a.date desc limit :n", nativeQuery = true)
    List<Announcement> findRecentAnnouncements(@Param("n") long n);//used for video screen

}
