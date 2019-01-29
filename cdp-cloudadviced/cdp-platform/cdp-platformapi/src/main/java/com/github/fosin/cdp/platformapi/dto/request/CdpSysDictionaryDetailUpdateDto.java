package com.github.fosin.cdp.platformapi.dto.request;

import java.util.Date;

import com.github.fosin.cdp.util.RegexUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import com.github.fosin.cdp.util.DateTimeUtil;

/**
 * 系统通用字典明细表(CdpSysDictionaryDetail)更新DTO
 *
 * @author fosin
 * @date 2019-01-27 18:34:14
 * @since 1.0.0
 */
@Data
@ApiModel(value = "系统通用字典明细表更新DTO", description = "表(cdp_sys_dictionary_detail)的对应的更新DTO")
public class CdpSysDictionaryDetailUpdateDto implements Serializable {
    private static final long serialVersionUID = -77524205114983893L;

    @NotNull
    @ApiModelProperty(value = "字典明细ID", example = "Long", required = true)
    private Long id;

    @NotNull
    @ApiModelProperty(value = "字典明细键，不能重复，字典内明细项唯一代码", example = "Long", required = true)
    private Long name;

    @ApiModelProperty(value = "字典明细值表示字面意义", example = "String")
    @Pattern(regexp = RegexUtil.SPECIAL, message = "字典明细值不能包含特殊字符")
    private String value;

    @NotNull
    @ApiModelProperty(value = "取值于字典明细表cdp_sys_dictionary.id", example = "Long", required = true)
    private Long dictionaryId;

    @NotNull
    @ApiModelProperty(value = "顺序，用于显示数据时的顺序，数值越小越靠前", example = "Integer", required = true)
    private Integer sort;

    @NotNull
    @ApiModelProperty(value = "使用状态：0=启用，1=禁用，具体取值于字典表cdp_sys_dictionary.id=11", example = "Integer", required = true)
    private Integer status;

    @ApiModelProperty(value = "标准代码，该字段通常用于对接标准字典", example = "String")
    @Pattern(regexp = RegexUtil.SPECIAL, message = "标准代码不能包含特殊字符")
    private String scode;

    @ApiModelProperty(value = "作用域，用于字典明细项的作用域", example = "String")
    @Pattern(regexp = RegexUtil.SPECIAL, message = "作用域不能包含特殊字符")
    private String scope;
}