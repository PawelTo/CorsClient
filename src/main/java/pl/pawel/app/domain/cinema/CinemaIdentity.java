package pl.pawel.app.domain.cinema;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
public class CinemaIdentity {

    private String filmId;

    private String filmName;
}
