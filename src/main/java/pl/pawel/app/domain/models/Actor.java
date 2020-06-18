package pl.pawel.app.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import pl.pawel.app.domain.ActorRepository;

import javax.validation.constraints.NotBlank;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

@Builder(toBuilder = true)
@Data
@EqualsAndHashCode(exclude = {"repository"})
@JsonInclude(NON_EMPTY)
public class Actor {

    private int age;

    private Long id;

    @NotBlank
    private String name;

    @Getter(AccessLevel.NONE)
    @JsonIgnore
    @Setter(AccessLevel.NONE)
    private ActorRepository repository;

    private Actor.Sex sex;

    @NotBlank
    private String surname;

    public Actor add(){
        id = repository.getPersistence().add(this);
        return this;
    }
    public enum Sex {
        MAN,
        WOMAN,
    }
}
