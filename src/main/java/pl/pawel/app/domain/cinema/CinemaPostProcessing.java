package pl.pawel.app.domain.cinema;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class CinemaPostProcessing {

    @NotBlank
    private String identityRequestId;

    @NotNull
    private List<CinemaItemStatus> itemStatuses;

    @Getter(AccessLevel.NONE)
    @NotNull
    private Status overallStatus;

    public Status getOverallStatus() {
        return isNotEmpty(itemStatuses) ? overallStatusFrom(itemStatuses) : Status.success;
    }

    private Status overallStatusFrom(List<CinemaItemStatus> itemStatuses) {
        List<CinemaItemStatus.Status> distinctItemStatuses = distinctItemStatuses(itemStatuses);
        if (distinctItemStatuses.contains(CinemaItemStatus.Status.failure))
            return Status.failure;
        if (distinctItemStatuses.contains(CinemaItemStatus.Status.warning))
            return Status.warning;
        return Status.success;
    }

    private List<CinemaItemStatus.Status> distinctItemStatuses(List<CinemaItemStatus> itemStatuses) {
        return itemStatuses.stream()
                .map(CinemaItemStatus::getStatus)
                .distinct()
                .collect(toList());
    }

    public static class CinemaPostProcessingBuilder {

        private Status overallStatus;

        private CinemaPostProcessingBuilder overallStatus(Status status) {
            this.overallStatus = status;
            return this;
        }
    }

    public enum Status {
        failure,
        success,
        warning;
    }
}
