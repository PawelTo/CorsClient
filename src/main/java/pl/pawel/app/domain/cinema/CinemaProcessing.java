package pl.pawel.app.domain.cinema;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
public class CinemaProcessing {

    @NotNull
    private CinemaIdentity identity;

    @NotBlank
    private String identityRequestId;

    @NotNull
    private List<CinemaItem> items;

    @DecimalMin(value = "0")
    @NotNull
    private Long timestamp;
}
