package cloud.cholewa.blog.project.web;

import cloud.cholewa.blog.project.application.port.ProjectUseCase;
import cloud.cholewa.blog.project.application.port.ProjectUseCase.CreateProjectCommand;
import cloud.cholewa.blog.project.domain.Project;
import cloud.cholewa.blog.config.web.CreatedURI;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.net.URI;
import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectUseCase project;

    @GetMapping
    public ResponseEntity<?> getAllProjects(@RequestParam Optional<String> title, @RequestParam Optional<String> tag) {
        if (title.isPresent() && tag.isPresent()) {
            return ResponseEntity.ok(project.findByTitleAndTag(title.get(), tag.get()));
        } else if (title.isPresent()) {
            return ResponseEntity.ok(project.findByTitle(title.get()));
        } else if (tag.isPresent()) {
            return ResponseEntity.ok(project.findByTag(tag.get()));
        }

        return ResponseEntity.ok(project.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProjectById(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Void> addProject(@Valid @RequestBody RestProjectCommand command) {
        Project project = this.project.addProject(command.toCreateCommand());
        return ResponseEntity.created(createProjectURI(project)).build();
    }

    @Data
    private static class RestProjectCommand {

        @NotBlank
        private String title;

        @NotBlank
        private String description;

        private Set<String> tags;

        CreateProjectCommand toCreateCommand() {
            return new CreateProjectCommand(title, description, tags);
        }
    }

    private URI createProjectURI(Project project) {
        return new CreatedURI("/" + project.getId().toString()).uri();
    }
}
