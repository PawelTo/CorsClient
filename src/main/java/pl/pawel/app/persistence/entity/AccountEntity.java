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

import static javax.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@Data
@DynamicUpdate
@Entity(name = "Account")
@NoArgsConstructor
public class AccountEntity {

    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP not null", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdTimestamp;

    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;

    @Column(length = 64)
    private String name;

    @JoinTable(name = "account_privilege",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Set<PrivilegeEntity> privileges = new HashSet<>();

    @Column(length = 64)
    private String surname;

    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP not null", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedTimestamp;
}
