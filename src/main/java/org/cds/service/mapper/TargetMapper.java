package org.cds.service.mapper;

import org.cds.model.Target;
import org.cds.model.web.WebTarget;
import org.cds.model.web.WebTargetASM;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TargetMapper {
    TargetMapper INSTANCE = Mappers.getMapper(TargetMapper.class);
    @Mappings({
            @Mapping(target = "userId", source = "user.guid"),
            @Mapping(target = "contentId", source = "content.guid")
    })
    WebTargetASM targetToWebTargetASM(Target target);
    WebTarget targetToWebTarget(Target target);

    Target webTargetToTarget(WebTarget webTarget);

}