package com.github.fosin.anan.pojo.dto.request;

import com.github.fosin.anan.util.DateTimeUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户表(AnanUser)查询DTO
 *
 * @author fosin
 * @date 2019-01-27 18:27:19
 * @since 1.0.0
 */
@Data
@ApiModel(value = "系统用户表查询DTO", description = "表(anan_user)的对应的查询DTO")
public class AnanUserRetrieveDto implements Serializable {
    private static final long serialVersionUID = -24340282458700184L;

    @ApiModelProperty(value = "用户ID, 主键", example = "Long")
    private Long id;

    @ApiModelProperty(value = "机构ID", example = "Long")
    private Long organizId;

    @ApiModelProperty(value = "用户工号", example = "String")
    private String usercode;

    @ApiModelProperty(value = "用户姓名", example = "String")
    private String username;

    @ApiModelProperty(value = "传入原始密码，后台会对原始密码进行加密后再存储", example = "String")
    private String password;

    @DateTimeFormat(pattern = DateTimeUtil.DATETIME_PATTERN)
    @ApiModelProperty(value = "生日", example = "Date")
    private Date birthday;

    @ApiModelProperty(value = "使用状态：具体取值于字典表anan_dictionary.code=15", example = "Integer")
    private Integer sex;

    @ApiModelProperty(value = "电子邮箱", example = "String")
    private String email;

    @ApiModelProperty(value = "手机号码", example = "String")
    private String phone;

    @ApiModelProperty(value = "使用状态：0=启用，1=禁用，具体取值于字典表anan_dictionary.code=11", example = "Integer")
    private Integer status;

    @ApiModelProperty(value = "头像", example = "String")
    private String avatar;

    @DateTimeFormat(pattern = DateTimeUtil.DATETIME_PATTERN)
    @ApiModelProperty(value = "过期时间，账户过期后用户被锁定切不能登录系统", example = "Date")
    private Date expireTime;

}
