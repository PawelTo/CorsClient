package pl.pawel.app.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import pl.pawel.app.domain.PrivilegeRepository;

import javax.validation.constraints.NotBlank;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Builder(toBuilder = true)
@Data
@EqualsAndHashCode(exclude = {"repository"})
@JsonInclude(NON_EMPTY)
public class Privilege {

    private Long id;

    @NotBlank
    private String name;

    @Getter(AccessLevel.NONE)
    @JsonIgnore
    @Setter(AccessLevel.NONE)
    private PrivilegeRepository repository;

    @NotBlank
    private String value;
}
