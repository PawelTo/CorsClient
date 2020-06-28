package pl.pawel.app.domain.cinema;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;

import static pl.pawel.app.domain.cinema.CinemaItemStatus.Status.*;

@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
public class CinemaItemStatus {

    @NotNull
    private String id;

    @NotNull
    private Status status;

    @Builder.Default
    @NotNull
    private String message = StringUtils.EMPTY;

    public static CinemaItemStatus failure(String id, String message){
        return CinemaItemStatus.builder()
                .id(id)
                .message(message)
                .status(failure)
                .build();
    }

    public static CinemaItemStatus success(String id){
        return CinemaItemStatus.builder()
                .id(id)
                .status(success)
                .build();
    }

    public static CinemaItemStatus warning(String id, String message){
        return CinemaItemStatus.builder()
                .id(id)
                .message(message)
                .status(warning)
                .build();
    }

    public enum Status {
        failure,
        success,
        warning;
    }
}
