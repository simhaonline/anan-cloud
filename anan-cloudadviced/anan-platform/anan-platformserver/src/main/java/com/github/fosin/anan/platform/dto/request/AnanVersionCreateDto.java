package com.github.fosin.anan.platform.dto.request;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import com.github.fosin.anan.util.DateTimeUtil;

/**
 * 系统版本表(AnanVersion)创建DTO
 *
 * @author fosin
 * @date 2019-02-19 18:14:31
 * @since 1.0.0
 */
@Data
@ApiModel(value = "系统版本表创建DTO", description = "表(anan_version)的对应的创建DTO")
public class AnanVersionCreateDto implements Serializable {
    private static final long serialVersionUID = 694132641358640789L;

    @NotBlank(message = "版本名称" + "{javax.validation.constraints.NotBlank.message}")
    @ApiModelProperty(value = "版本名称", example = "String", required = true)
    private String name;

    @NotNull(message = "版本类型" + "{javax.validation.constraints.NotNull.message}")
    @ApiModelProperty(value = "版本类型：0=收费版 1=免费版 2=开发版", example = "Integer", required = true)
    private Integer type;

    @NotNull(message = "版本价格" + "{javax.validation.constraints.NotNull.message}")
    @ApiModelProperty(value = "版本价格", example = "Double", required = true)
    private Double price;

    @ApiModelProperty(value = "活动开始日期", example = "Date", required = true)
    @DateTimeFormat(pattern = DateTimeUtil.DATETIME_PATTERN)
    private Date beginTime;

    @ApiModelProperty(value = "活动结束日期", example = "Date", required = true)
    @DateTimeFormat(pattern = DateTimeUtil.DATETIME_PATTERN)
    private Date endTime;

    @NotNull(message = "有效期" + "{javax.validation.constraints.NotNull.message}")
    @ApiModelProperty(value = "有效期：一般按天计算", example = "Integer", required = true)
    private Integer validity;

    @NotNull(message = "到期后保护期" + "{javax.validation.constraints.NotNull.message}")
    @ApiModelProperty(value = "到期后保护期", example = "Integer", required = true)
    private Integer protectDays;

    @NotNull(message = "最大机构数" + "{javax.validation.constraints.NotNull.message}")
    @ApiModelProperty(value = "最大机构数：0=无限制 n=限制数", example = "Integer", required = true)
    private Integer maxOrganizs;

    @NotNull(message = "最大机构数" + "{javax.validation.constraints.NotNull.message}")
    @ApiModelProperty(value = "最大机构数：0=无限制 n=限制数", example = "Integer", required = true)
    private Integer maxUsers;

    @NotNull(message = "是否试用" + "{javax.validation.constraints.NotNull.message}")
    @ApiModelProperty(value = "是否试用：0=不试用 1=试用", example = "Integer", required = true)
    private Integer tryout;

    @NotNull(message = "试用天数" + "{javax.validation.constraints.NotNull.message}")
    @ApiModelProperty(value = "试用天数", example = "Integer", required = true)
    private Integer tryoutDays;

    @NotNull(message = "启用状态" + "{javax.validation.constraints.NotNull.message}")
    @ApiModelProperty(value = "启用状态：0=启用，1=禁用", example = "Integer", required = true)
    private Integer status;

    @ApiModelProperty(value = "版本描述", example = "String")
    private String description;

}
