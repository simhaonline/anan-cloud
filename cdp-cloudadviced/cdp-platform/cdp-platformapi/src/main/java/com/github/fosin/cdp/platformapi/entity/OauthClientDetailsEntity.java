package com.github.fosin.cdp.platformapi.entity;

import com.github.fosin.cdp.mvc.constant.RegExpConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import com.github.fosin.cdp.util.DateTimeUtil;
/**
 * (OauthClientDetails)实体类
 *
 * @author fosin
 * @date 2018-11-29 18:07:27
 * @since 1.0.0
 */
@Data
@Entity
@DynamicUpdate
@Table(name = "oauth_client_details")
@ApiModel(value = "$tableInfo.comment实体类", description = "表(oauth_client_details)的对应的实体类")
public class OauthClientDetailsEntity implements Serializable {
    private static final long serialVersionUID = -51110701713375430L;
    
    @Id
    @Column(name = "client_id")
    @ApiModelProperty(value = "主键")
    @Pattern(regexp = RegExpConstant.USERCODE + "{1,64}", message = "客户端ID只能大小写字母、数字、下杠(_)、中杠(-)组合而成,长度不超过64位")
    private String clientId;
    
    @Basic
    @Column(name = "resource_ids")
    @ApiModelProperty(value = "${column.comment}")
    private String resourceIds;
    
    @Basic
    @Column(name = "client_secret")
    @ApiModelProperty(value = "${column.comment}")
    private String clientSecret;
    
    @Basic
    @Column(name = "scope")
    @ApiModelProperty(value = "${column.comment}")
    private String scope;
    
    @Basic
    @Column(name = "authorized_grant_types")
    @ApiModelProperty(value = "${column.comment}")
    private String authorizedGrantTypes;
    
    @Basic
    @Column(name = "web_server_redirect_uri")
    @ApiModelProperty(value = "${column.comment}")
    private String webServerRedirectUri;
    
    @Basic
    @Column(name = "authorities")
    @ApiModelProperty(value = "${column.comment}")
    private String authorities;
    
    @Basic
    @Column(name = "access_token_validity")
    @ApiModelProperty(value = "${column.comment}")
    private Integer accessTokenValidity;
    
    @Basic
    @Column(name = "refresh_token_validity")
    @ApiModelProperty(value = "${column.comment}")
    private Integer refreshTokenValidity;
    
    @Basic
    @Column(name = "additional_information")
    @ApiModelProperty(value = "${column.comment}")
    private String additionalInformation;
    
    @Basic
    @Column(name = "autoapprove")
    @ApiModelProperty(value = "${column.comment}")
    private String autoapprove;
    
}