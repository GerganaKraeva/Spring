package bg.softuni.pathfinder.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Column(columnDefinition = "TEXT")
   private String description;

    @Enumerated(EnumType.STRING)
    private CategoryName name;

}
