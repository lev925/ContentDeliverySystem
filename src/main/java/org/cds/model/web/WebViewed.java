package org.cds.model.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.cds.model.Content;
import org.cds.model.User;

import java.util.UUID;

@Data
@Builder
@ApiModel
public class WebViewed {
    @ApiModelProperty(
            value = "User",
            name = "user",
            dataType = "User")
    private User user;
    @ApiModelProperty(
            value = "Content",
            name = "content",
            dataType = "Content")
    private Content content;
}
