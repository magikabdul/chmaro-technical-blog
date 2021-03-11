package cloud.cholewa.blog.article.application;

import cloud.cholewa.blog.article.application.port.ArticleUseCase;
import cloud.cholewa.blog.article.db.ArticleRepository;
import cloud.cholewa.blog.article.domain.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService implements ArticleUseCase {
    private final ArticleRepository articleRepository;

    @Override
    public Article addArticle(CreateArticleCommand command) {
        Article article = new Article(command.getTitle(), command.getDescription());
        return articleRepository.save(article);
    }
}
