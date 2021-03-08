package cloud.cholewa.blog.project.web;

import cloud.cholewa.blog.project.application.port.ProjectUseCase;
import cloud.cholewa.blog.project.domain.Tag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
            return ResponseEntity.ok(project.findAllProjects());
        } else if (title.isPresent()) {
            return ResponseEntity.ok(project.findAllProjects());
        } else if (tag.isPresent()) {
            return ResponseEntity.ok(project.findAllProjects());
        }

        return ResponseEntity.ok(project.findAllProjects());
    }

    @GetMapping
    public ResponseEntity<?> getProjectById(Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Void> addProject(@Valid @RequestBody RestProjectCommand command) {
        return null;
    }

    @Data
    private static class RestProjectCommand {

        @NotBlank
        private String title;

        @NotBlank
        private String description;

        @NotEmpty
        private Set<Tag> tags;
    }
}
