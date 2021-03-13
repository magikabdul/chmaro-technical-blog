package cloud.cholewa.blog.article.application;

import cloud.cholewa.blog.article.application.port.ArticleUseCase;
import cloud.cholewa.blog.article.db.ArticleRepository;
import cloud.cholewa.blog.article.db.CoverRepository;
import cloud.cholewa.blog.article.domain.Article;
import cloud.cholewa.blog.article.domain.Cover;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService implements ArticleUseCase {
    private final ArticleRepository articleRepository;
    private final CoverRepository coverRepository;


    @Override
    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    public Article addArticle(CreateArticleCommand command) {
        Article article = new Article(command.getTitle(), command.getDescription());
        return articleRepository.save(article);
    }

    @Override
    public void addArticleCover(Article article, CreateArticleCover createArticleCover) {

        Cover cover = new Cover(
                createArticleCover.getFilename(),
                createArticleCover.getContentType(),
                createArticleCover.getFile());


        Cover savedCover = coverRepository.save(cover);
        article.setCoverId(savedCover.getId());
        articleRepository.save(article);
    }

    @Override
    public Optional<Cover> getArticleCoverById(Long id) {
        return coverRepository.findById(id);
    }
}
