package pl.pawel.app.domain.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

@Builder(toBuilder = true)
@Data
@JsonInclude(NON_EMPTY)
public class User {

    private Access access;

    private List<Authority> authorities;

    private String corporateID;

    private String name;

    private String surname;

    public Access getAccess() {
        return authorityOfHighestType().map(authority -> Access.builder()
                .role(authority.getRole())
                .build())
                .orElse(null);
    }

    private Optional<Authority> authorityOfHighestType() {
        return authorities.stream().max(Authority::compareTo);
    }

    @Builder
    @Data
    public static class Access {
        private final Authority.Role role;
    }

    @Builder
    @Data
    @JsonInclude(NON_EMPTY)
    public static class Authority implements Comparable<Authority> {

        @NotNull
        private final Group group;

        @NotNull
        private final Role role;

        @Override
        public int compareTo(Authority authority) {
            return role.getImportance() - authority.role.getImportance();
        }

        public enum Group {
            G1,
            G2;

            private static final Map<String, Group> MAP = Stream.of(Group.values()).collect(toMap(Enum::name, identity()));

            public static Group fromValue(String value) {
                return MAP.get(value.toUpperCase());
            }
        }

        @RequiredArgsConstructor
        public enum Role {
            R1(1),
            R2(2);

            @Getter
            private final int importance;

            private static final Map<String, Role> MAP = Stream.of(Role.values()).collect(toMap(Enum::name, identity()));

            public static Role fromValue(String value) {
                return MAP.get(value.toUpperCase());
            }
        }
    }
}
