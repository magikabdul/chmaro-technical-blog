package cloud.cholewa.blog.project.application.port;

import cloud.cholewa.blog.project.db.ProjectJpaRepository;
import cloud.cholewa.blog.project.db.TagJpaRepository;
import cloud.cholewa.blog.project.domain.Project;
import cloud.cholewa.blog.project.domain.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService implements ProjectUseCase {
    private final ProjectJpaRepository projectRepository;
    private final TagJpaRepository tagRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
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
    @Transactional
    public Project addProject(CreateProjectCommand command) {
        Project project = new Project(command.getTitle(), command.getDescription());
        project.setTags(fetchTags(command.getTags()));
        return projectRepository.save(project);
    }

    private Set<Tag> fetchTags(Set<String> tagNames) {
        return tagNames.stream()
                .map(tagName -> {
                    if (tagRepository.findByName(tagName).isPresent()) {
                        return tagRepository.findByName(tagName).get();
                    } else {
                        Tag tag = new Tag();
                        tag.setName(tagName);
                        return tagRepository.save(tag);
                    }
                })
                .collect(Collectors.toSet());
    }
}
