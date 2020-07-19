package pl.pawel.app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class User {

    private Access access;

    private Authority authority;

    private String name;

    private String surname;

    public class Access {
        Authority.Role role;
    }

    @Builder
    public static class Authority {

        private Group group;

        private Role role;

        @AllArgsConstructor
        enum Group {
            G1(1),
            G2(2);

            int importance;
        }

        enum Role {
            R1,
            R2
        }
    }
}
