package org.cds.service.mapper;

import org.cds.model.Viewed;
import org.cds.model.web.WebViewed;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ViewedMapper {
    ViewedMapper INSTANCE = Mappers.getMapper(ViewedMapper.class);

    WebViewed ViewedToWebViewed(Viewed viewed);

    Viewed WebViewedToViewed(WebViewed webViewed);

}
