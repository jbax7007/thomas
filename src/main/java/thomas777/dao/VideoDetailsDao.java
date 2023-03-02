package thomas777.dao;

import thomas777.domain.VideoDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface VideoDetailsDao extends JpaRepository<VideoDetails, Long>, JpaSpecificationExecutor<VideoDetails> {


}