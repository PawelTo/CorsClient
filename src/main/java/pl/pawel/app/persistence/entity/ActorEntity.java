package pl.pawel.app.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@Data
@DynamicUpdate
@Entity(name = "Actor")
@NoArgsConstructor
public class ActorEntity {

    private int age;

    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP not null", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdTimestamp;

    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;

    @Column(length = 64)
    private String name;

    @Column(length = 5)
    private String sex;

    @Column(length = 64)
    private String surname;

    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP not null", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedTimestamp;
}
