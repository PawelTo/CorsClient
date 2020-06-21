package pl.pawel.app.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Data
@DynamicUpdate
@Entity(name = "Film")
@NoArgsConstructor
public class FilmEntity {

    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Set<ActorEntity> actors = new HashSet<>();

    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP not null", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdTimestamp;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 64, nullable = false)
    private String producer;

    @Column(length = 64, nullable = false)
    private String state;

    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP not null", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedTimestamp;
}
