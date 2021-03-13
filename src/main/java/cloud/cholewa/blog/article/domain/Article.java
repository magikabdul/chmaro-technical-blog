package cloud.cholewa.blog.article.domain;

import cloud.cholewa.blog.config.jpa.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "articles")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Article extends BaseEntity {

    @Column(unique = true)
    private String title;

    @Column(length = 1000)
    private String description;

    private Long coverId;

    @CreatedDate
    private LocalDateTime createdAt;

    @Column(length = 20000)
    private String content;

    public Article(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
