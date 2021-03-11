package cloud.cholewa.blog.project.domain;

import cloud.cholewa.blog.config.jpa.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "tags")
@Setter
@Getter
@NoArgsConstructor
public class Tag extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "tags", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties("tags")
    private Set<Project> projects;
}
