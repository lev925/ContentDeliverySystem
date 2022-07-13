package org.cds.model;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ApiModel
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @ApiModelProperty(
            value = "GUID",
            name = "guid",
            dataType = "UUID",
            example = "748d4942-165d-49b3-9acb-f7eed77b7523")
    private UUID guid;
    @Column(name = "systemname")
    @ApiModelProperty(
            value = "System Name",
            name = "systemName",
            dataType = "String",
            example = "Alex")
    private String systemName;
    @Column
    @ApiModelProperty(
            value = "Email",
            name = "email",
            dataType = "String",
            example = "NEWS")
    private String email;
    @Column
    @ApiModelProperty(
            value = "Phone",
            name = "page",
            dataType = "String",
            example = "45-96-85")
    private String phone;
}
