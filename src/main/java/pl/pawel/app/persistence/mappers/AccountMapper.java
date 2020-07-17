package pl.pawel.app.persistence.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.pawel.app.domain.models.Account;
import pl.pawel.app.persistence.entity.AccountEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "repository", ignore = true)
    Account mapToDomain(AccountEntity accountEntity);

    List<Account> mapToDomain(List<AccountEntity> accounts);

    @Mapping(target = "createdTimestamp", ignore = true)
    @Mapping(target = "updatedTimestamp", ignore = true)
    AccountEntity mapToPersistence(Account account);
}
