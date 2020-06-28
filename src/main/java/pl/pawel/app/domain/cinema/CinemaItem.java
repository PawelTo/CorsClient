package pl.pawel.app.domain.cinema;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

import static java.util.Objects.isNull;

@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
public class CinemaItem {

    private static final String FILM_ADD = "FilmAdded";
    private static final String FILM_REMOVE = "FilmRemoved";
    private static final String FILM_WATCHED = "FilmWatched";
    @NotNull
    private String id;

    private String name;

    @NotNull
    private Operation operation;

    private String value;

    public Method getMethod() {
        Method method = Method.UNKNOWN;
        if (isNull(operation))
            method = Method.UNKNOWN;
        switch (operation) {
            case Add:
                method = Method.ACTOR_ADD;
            case Remove:
                method = Method.ACTOR_REMOVE;
            case Set:
                method = methodForFilmOperation();
        }
        return method;
    }

    private Method methodForFilmOperation() {
        Method method = Method.UNKNOWN;
        if (isNull(name))
            method = Method.UNKNOWN;
        switch (name) {
            case FILM_ADD:
                method = Method.FILM_ADD;
            case FILM_REMOVE:
                method = Method.FILM_REMOVE;
            case FILM_WATCHED:
                method = Method.FILM_WATCHED;
            default:
                method = Method.UNKNOWN;
        }
        return method;
    }

    public enum Operation {
        Add,
        Remove,
        Set;

        boolean isAdd() {
            return this.equals(Operation.Add);
        }

        boolean isRemove() {
            return this.equals(Operation.Remove);
        }

        boolean isSet() {
            return this.equals(Operation.Set);
        }
    }

    public enum Method {
        FILM_ADD,
        FILM_REMOVE,
        FILM_WATCHED,
        ACTOR_ADD,
        ACTOR_REMOVE,
        UNKNOWN;
    }
}
