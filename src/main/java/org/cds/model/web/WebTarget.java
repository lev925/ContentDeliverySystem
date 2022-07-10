package org.cds.model.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.cds.model.Content;
import org.cds.model.Page;
import org.cds.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Data
@Builder
@ApiModel
public class WebTarget implements Serializable {

    private User user;

    private Content content;
    @ApiModelProperty(
            value = "Page",
            name = "page",
            dataType = "Page",
            example = "NEWS")
    private Page page;
    @ApiModelProperty(
            value = "Priority",
            name = "priority",
            dataType = "int",
            example = "3")
    private int priority;
    @ApiModelProperty(
            value = "Begin Date",
            name = "begin_date",
            dataType = "Date",
            example = "2012-07-04 18:13:56.000000")
    private Date startDate;
    @ApiModelProperty(
            value = "End Date",
            name = "end_date",
            dataType = "Date",
            example = "2013-02-01 11:12:56.000000")
    private Date endDate;



}
