package cloud.cholewa.blog.project.application.port;

import cloud.cholewa.blog.project.domain.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService implements ProjectUseCase{

    @Override
    public List<Project> findAll() {
        return null;
    }

    @Override
    public List<Project> findByTitleAndTag(String title, String tag) {
        return null;
    }

    @Override
    public List<Project> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Project> findByTag(String tag) {
        return null;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Project addProject(CreateProjectCommand command) {
        return null;
    }
}
