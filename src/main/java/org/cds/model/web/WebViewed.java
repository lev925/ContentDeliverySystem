package org.cds.model.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cds.model.Content;
import org.cds.model.User;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class WebViewed implements Serializable {
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
