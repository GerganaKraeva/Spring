package bg.softuni.pathfinder.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{

    @Column(nullable = false)
    private Boolean approved;

    @Column(nullable = false)
    private Instant created;

    @Column(name="text_content",columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne(optional = false)
    private User author;


    @ManyToOne(optional = false, fetch = FetchType.LAZY )
    private Route route;

}
