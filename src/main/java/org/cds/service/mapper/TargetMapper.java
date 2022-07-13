package org.cds.service.mapper;

import org.cds.model.Target;
import org.cds.model.web.WebTarget;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TargetMapper {
    TargetMapper INSTANCE = Mappers.getMapper(TargetMapper.class);

    WebTarget targetToWebTarget(Target target);

    Target webTargetToTarget(WebTarget webTarget);
}