package pl.pawel.app.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import pl.pawel.app.domain.AccountRepository;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Builder(toBuilder = true)
@Data
@EqualsAndHashCode(exclude = {"repository"})
@JsonInclude(NON_EMPTY)
public class Account {

    private String corporateID;

    @Getter(AccessLevel.NONE)
    @JsonIgnore
    @Setter(AccessLevel.NONE)
    private AccountRepository repository;

    private Long id;

    @NotBlank
    private String name;

    @Builder.Default
    private List<Privilege> privileges = new ArrayList<>();

    @NotBlank
    private String surname;
}
