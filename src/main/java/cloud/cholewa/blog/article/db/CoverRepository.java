package cloud.cholewa.blog.article.db;

import cloud.cholewa.blog.article.domain.Cover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoverRepository extends JpaRepository<Cover, Long> {

}
