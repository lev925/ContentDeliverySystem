package org.cds.model.web;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.cds.model.Page;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class WebTargetFilter implements Serializable {

    @ApiModelProperty(
            value = "User guid",
            name = "userGuid",
            dataType = "UUID",
            example = "9ca106ba-b5da-4c0e-b996-7a555a37dd4d")
    UUID userGuid;

    @ApiModelProperty(
            value = "PageName",
            name = "pageName",
            dataType = "Page",
            example = "NEWS")
    Page pageName;
}
