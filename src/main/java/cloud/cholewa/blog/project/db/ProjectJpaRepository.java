package cloud.cholewa.blog.project.db;

import cloud.cholewa.blog.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectJpaRepository extends JpaRepository<Project, Long> {

    @Query("SELECT DISTINCT p FROM Project p JOIN fetch p.tags")
    List<Project> findAll();
}
