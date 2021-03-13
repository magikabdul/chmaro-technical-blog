package cloud.cholewa.blog.article.application.port;

import cloud.cholewa.blog.article.domain.Article;
import cloud.cholewa.blog.article.domain.Cover;
import lombok.Value;

import java.util.Optional;

public interface ArticleUseCase {

    Article addArticle(CreateArticleCommand command);

    Optional<Article> getArticleById(Long id);

    void addArticleCover(Article article, CreateArticleCover createArticleCover);

    Optional<Cover> getArticleCoverById(Long id);

    @Value
    class CreateArticleCommand {
        String title;
        String description;
    }

    @Value
    class CreateArticleCover {
        byte[] file;
        String contentType;
        String filename;
    }

    @Value
    class CoverResponse {
        Long id;
        String filename;
        String contentType;
        byte[] file;
    }
}
