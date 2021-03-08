package cloud.cholewa.blog.project.db;

import cloud.cholewa.blog.project.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagJpaRepository extends JpaRepository<Tag, Long> {

}
