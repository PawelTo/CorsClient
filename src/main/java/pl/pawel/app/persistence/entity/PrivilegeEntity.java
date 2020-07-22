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
import javax.persistence.Id;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@Data
@DynamicUpdate
@Entity(name = "Privilege")
@NoArgsConstructor
public class PrivilegeEntity {

    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP not null", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdTimestamp;

    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;

    @Column(length = 64)
    private String name;

    @Column(length = 64)
    private String value;

    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP not null", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedTimestamp;
}
