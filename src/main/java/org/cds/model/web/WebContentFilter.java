package org.cds.model.web;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class WebContentFilter implements Serializable {

    @ApiModelProperty(
            value = "User guid",
            name = "userGuid",
            dataType = "String",
            example = "123e4567-e89b-42d3-a456-556642440000")
    String userGuid;

    @ApiModelProperty(
            value = "PageName",
            name = "pageName",
            dataType = "String",
            example = "text")
    String pageName;
}
