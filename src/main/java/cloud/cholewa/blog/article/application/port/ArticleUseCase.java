package cloud.cholewa.blog.article.application.port;

import cloud.cholewa.blog.article.domain.Article;
import lombok.Value;

public interface ArticleUseCase {

    Article addArticle(CreateArticleCommand command);

    @Value
    class CreateArticleCommand {
        String title;
        String description;
    }
}
