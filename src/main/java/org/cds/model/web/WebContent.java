package org.cds.model.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class WebContent implements Serializable {
    @ApiModelProperty(
            value = "Data of content",
            name = "data",
            dataType = "String",
            example = "text")
    private String data;
    @ApiModelProperty(
            value = "User guid",
            name = "userGuid",
            dataType = "String",
            example = "123e4567-e89b-42d3-a456-556642440000")
    private String userGuid;
}
