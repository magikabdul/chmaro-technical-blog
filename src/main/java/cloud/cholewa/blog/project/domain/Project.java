package cloud.cholewa.blog.project.domain;

import cloud.cholewa.blog.config.jpa.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "projects")
@NoArgsConstructor
public class Project extends BaseEntity {

    private String title;

    @Column(length = 5000)
    private String description;

    private LocalDateTime date;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable
    @JsonIgnoreProperties("projects")
    private Set<Tag> tags = new HashSet<>();

    public Project(String title, String description) {
        this.title = title;
        this.description = description;
        this.date = LocalDateTime.now();
    }
}
