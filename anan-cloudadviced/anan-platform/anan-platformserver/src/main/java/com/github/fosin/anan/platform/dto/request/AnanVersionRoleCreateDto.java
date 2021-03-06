package com.github.fosin.anan.platform.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 系统版本角色表(AnanVersionRole)创建DTO
 *
 * @author fosin
 * @date 2019-02-19 18:14:31
 * @since 1.0.0
 */
@Data
@ApiModel(value = "系统版本角色表创建DTO", description = "表(anan_version_role)的对应的创建DTO")
public class AnanVersionRoleCreateDto implements Serializable {
    private static final long serialVersionUID = 119134079116880378L;

    @NotNull(message = "版本ID" + "{javax.validation.constraints.NotNull.message}")
    @ApiModelProperty(value = "版本ID", example = "Long", required = true)
    private Long versionId;

    @NotBlank(message = "角色名称" + "{javax.validation.constraints.NotBlank.message}")
    @ApiModelProperty(value = "角色名称", example = "String", required = true)
    private String name;

    @NotBlank(message = "角色标识" + "{javax.validation.constraints.NotBlank.message}")
    @ApiModelProperty(value = "角色标识", example = "String", required = true)
    private String value;

    @ApiModelProperty(value = "角色说明", example = "String")
    private String tips;

    @NotNull(message = "使用状态：0=启用，1=禁用，具体取值于字典表anan_dictionary.code=11" + "{javax.validation.constraints.NotNull.message}")
    @ApiModelProperty(value = "使用状态：0=启用，1=禁用，具体取值于字典表anan_dictionary.code=11", example = "Integer", required = true)
    private Integer status;

}
