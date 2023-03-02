package thomas777.dao;

import thomas777.domain.TagType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface TagTypeDao extends JpaRepository<TagType, Long>, JpaSpecificationExecutor<TagType> {
}