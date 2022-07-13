package org.cds.model.web;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.cds.model.Page;


import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;
@Data
@Builder
public class WebTargetASM implements Serializable {
    @ApiModelProperty(
            value = "User",
            name = "userId",
            dataType = "UUID",
            example = "03a9abd9-d579-4a6b-b13f-1531e35fcc79")
    private UUID userId;
    @ApiModelProperty(
            value = "Content",
            name = "contentId",
            dataType = "UUID",
            example = "af3cfff8-c9ed-411a-aa58-5c3247a2a5a4")
    private UUID contentId;
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
            example = "2012-07-04")
    private Date startDate;
    @ApiModelProperty(
            value = "End Date",
            name = "end_date",
            dataType = "Date",
            example = "2013-02-01")
    private Date endDate;
}
