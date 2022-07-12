package org.cds.model.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
@Data
public class WebContent implements Serializable {
    @ApiModelProperty(
            value = "guid",
            name = "guid",
            dataType = "UUID",
            example = "d0844183-bc7f-4594-a225-3d1579295d60")
    private UUID guid;
    @ApiModelProperty(
            value = "Data",
            name = "data",
            dataType = "String",
            example = "{\"header\": \"example\", \"backgroundImg\": \"img.img\",\"text\": \"cat\"}")
    private String data;
}
