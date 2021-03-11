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
@Table(name = "covers")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Cover extends BaseEntity {

    @Column(length = 100000)
    private byte[] file;

    private String contentType;

    private String filename;

    @OneToOne
    private Article article;

    @CreatedDate
    private LocalDateTime createdAt;

    public Cover(String filename, String contentType, byte[] file) {
        this.filename = filename;
        this.contentType = contentType;
        this.file = file;
    }
}
