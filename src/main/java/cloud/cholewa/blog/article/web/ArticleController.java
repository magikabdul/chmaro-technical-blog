package cloud.cholewa.blog.article.web;

import cloud.cholewa.blog.article.application.port.ArticleUseCase;
import cloud.cholewa.blog.article.application.port.ArticleUseCase.CreateArticleCommand;
import cloud.cholewa.blog.article.application.port.ArticleUseCase.CreateArticleCover;
import cloud.cholewa.blog.article.domain.Article;
import cloud.cholewa.blog.config.web.CreatedURI;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.net.URI;
import java.util.Optional;

import static cloud.cholewa.blog.article.application.port.ArticleUseCase.*;

@CrossOrigin
@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleUseCase articleService;

    public ResponseEntity<?> getAllArticles() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cover/{id}")
    public ResponseEntity<?> getArticleCoverById(@PathVariable Long id) {
        return articleService.getArticleCoverById(id)
                .map(cover -> {
                    String contentDisposition = "attachment; filename=\"" + cover.getFilename() + "\"";
                    Resource resource = new ByteArrayResource(cover.getFile());

                    return ResponseEntity.ok()
                            .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                            .contentType(MediaType.parseMediaType(cover.getContentType()))
                            .body(resource);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> addArticle(@Valid @RequestBody RestArticleCommand command) {
        Article article = articleService.addArticle(command.toCreateCommand());
        return ResponseEntity.created(createArticleUri(article)).build();
    }

    @Transactional
    @PutMapping(value = "/{id}/cover", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> addCover(@PathVariable Long id, @RequestParam("file")MultipartFile file) throws IOException {
        Optional<Article> optionalArticle = articleService.getArticleById(id);

        if (optionalArticle.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        articleService.addArticleCover(optionalArticle.get(), new CreateArticleCover(
                file.getBytes(),
                file.getContentType(),
                file.getOriginalFilename()
        ));

        return ResponseEntity.accepted().build();
    }

    @PutMapping("{id}/content")
    public ResponseEntity<?> addContent(@PathVariable Long id) {
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
