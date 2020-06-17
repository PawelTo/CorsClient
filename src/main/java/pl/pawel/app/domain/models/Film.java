package pl.pawel.app.domain.models;

import lombok.*;
import pl.pawel.app.domain.FilmRepository;

import javax.validation.constraints.NotBlank;

import static lombok.AccessLevel.NONE;

@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@EqualsAndHashCode(exclude = {"repository"})
@NoArgsConstructor
public class Film {

    private Long id;

    @NotBlank
    private String name;

    private String producer;

    private State state;

    @Getter(NONE)
    @Setter(NONE)
    private FilmRepository repository;

    public Film add(){
        id = repository.getPersistence().add(this);
        return this;
    }

    public Film attach(FilmRepository filmRepository) {
        repository = filmRepository;
        return this;
    }

    public enum State{
        TO_WATCH,
        WATCHED
    }
}
