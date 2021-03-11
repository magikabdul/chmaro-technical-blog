package cloud.cholewa.blog.article.web;

import cloud.cholewa.blog.article.application.port.ArticleUseCase;
import cloud.cholewa.blog.article.application.port.ArticleUseCase.CreateArticleCommand;
import cloud.cholewa.blog.article.domain.Article;
import cloud.cholewa.blog.config.web.CreatedURI;
import cloud.cholewa.blog.project.domain.Tag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.net.URI;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleUseCase articleService;

    @PostMapping
    public ResponseEntity<?> addArticle(@Valid @RequestBody RestArticleCommand command) {
        Article article = articleService.addArticle(command.toCreateCommand());
        return ResponseEntity.created(createArticleUri(article)).build();
    }

    @PutMapping("/cover")
    public ResponseEntity<?> addCover() {
        return null;
    }

    @PutMapping("/content")
    public ResponseEntity<?> addContent() {
        return null;
    }



    @Data
    private static class RestArticleCommand {

        @NotBlank
        private String title;

        @NotBlank
        private String description;

        CreateArticleCommand toCreateCommand() {
            return new CreateArticleCommand(title, description);
        }
    }

    private URI createArticleUri(Article article) {
        return new CreatedURI("/" + article.getId().toString()).uri();
    }
}
