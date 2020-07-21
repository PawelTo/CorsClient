package pl.pawel.app.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pawel.app.domain.models.Account;
import pl.pawel.app.domain.models.Privilege;
import pl.pawel.app.domain.models.User;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;
import static pl.pawel.app.domain.models.User.*;

@RequiredArgsConstructor
@Service
public class UserRepository {

    private final AccountRepository accountRepository;

    public Optional<User> findByCorporateId(String corporateId) {
        Account account = accountRepository.findByCorporateId(corporateId).stream().findFirst().orElse(null);
        if (account == null) return Optional.empty();
        List<Privilege> privileges = account.getPrivileges();
        List<Authority> authorities = authoritiesFromPrivilege(privileges);
        return Optional.ofNullable(builder()
                .authorities(authorities)
                .corporateID(corporateId)
                .name(account.getName())
                .surname(account.getSurname())
                .build());
    }

    private List<Authority> authoritiesFromPrivilege(List<Privilege> privileges) {
        return privileges.stream().map(this::toAuthority).collect(toList());
    }

    private Authority toAuthority(Privilege privilege) {
        if (nonNull(privilege)) {
            String[] splittedPrivilege = privilege.getValue().split(":");
            return Authority.builder()
                    .group(Authority.Group.fromValue(splittedPrivilege[0]))
                    .role(Authority.Role.fromValue(splittedPrivilege[1]))
                    .build();
        }
        return null;
    }
}
