package pl.pawel.app.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import pl.pawel.app.domain.FilmRepository;

import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static java.util.Objects.nonNull;
import static lombok.AccessLevel.NONE;

@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@EqualsAndHashCode(exclude = {"actors", "repository"})
@JsonInclude(NON_EMPTY)
@NoArgsConstructor
public class Film {

    @Builder.Default
    private List<Actor> actors = new ArrayList<>();

    private Long id;

    @NotBlank
    private String name;

    private String producer;

    @Getter(NONE)
    @JsonIgnore
    @Setter(NONE)
    private FilmRepository repository;

    private State state;

    public void actorAdd(Actor actor) {
        actors.add(actor);
        repository.getPersistence().update(this);
    }

    public Film add() {
        id = repository.getPersistence().add(this);
        return this;
    }

    public Film attach(FilmRepository filmRepository) {
        repository = filmRepository;
        return this;
    }

    @JsonIgnore
    public boolean isAttached() {
        return nonNull(repository);
    }

    public enum State {
        TO_WATCH,
        WATCHED
    }
}
