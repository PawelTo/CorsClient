package pl.pawel.app.persistence.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.pawel.app.domain.models.Privilege;
import pl.pawel.app.persistence.entity.PrivilegeEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrivilegeMapper {

    @Mapping(target = "repository", ignore = true)
    Privilege mapToDomain(PrivilegeEntity privilegeEntity);

    List<Privilege> mapToDomain(List<PrivilegeEntity> privileges);

    @Mapping(target = "createdTimestamp", ignore = true)
    @Mapping(target = "updatedTimestamp", ignore = true)
    PrivilegeEntity mapToPersistence(Privilege privilege);
}
