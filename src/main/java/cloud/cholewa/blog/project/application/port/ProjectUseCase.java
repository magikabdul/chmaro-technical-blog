package cloud.cholewa.blog.project.application.port;

import cloud.cholewa.blog.project.domain.Project;
import lombok.Value;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProjectUseCase {

    List<Project> findAll();

    List<Project> findByTitleAndTag(String title, String tag);

    List<Project> findByTitle(String title);

    List<Project> findByTag(String tag);

    Optional<Project> findById(Long id);

    Project addProject(CreateProjectCommand command);

    @Value
    class CreateProjectCommand {
        String title;
        String description;
        Set<String> tags;
    }
}
