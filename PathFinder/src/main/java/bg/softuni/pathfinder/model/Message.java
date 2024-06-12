package bg.softuni.pathfinder.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "messages")
public class Message extends BaseEntity{

    @Column(nullable = false,name = "date_time")
    private Instant dateTime;

    @Column(name = "text_content", columnDefinition = "TEXT")
    private String content;

    @ManyToOne(optional = false)
    private User author;

    @ManyToOne(optional = false)
    private User recipient;

}
