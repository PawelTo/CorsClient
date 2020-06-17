package pl.pawel.app.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@DynamicUpdate
@Entity(name = "Film")
@NoArgsConstructor
public class FilmEntity {

    @CreationTimestamp
    private LocalDateTime createdDt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 64, nullable = false)
    private String producer;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedDt;
}
