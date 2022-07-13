package org.cds.model.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;
@Data
@Builder
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
public class WebViewed implements Serializable {
    @ApiModelProperty(
            value = "User id",
            name = "userID",
            dataType = "UUID",
            example = "ccde47e7-7139-400f-8a65-6320d9156f68")
    private UUID userId;
    @ApiModelProperty(
            value = "Content id",
            name = "contentID",
            dataType = "UUID",
            example = "46f85973-64ed-4aa3-9164-e455448b9028")
    private UUID contentId;
}
