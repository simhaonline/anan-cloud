package com.github.fosin.cdp.platformapi.entity;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import com.github.fosin.cdp.util.DateTimeUtil;
/**
 * 系统版本角色权限表(CdpSysVersionRolePermission)实体类
 *
 * @author fosin
 * @date 2018-11-18 17:28:24
 * @since 1.0.0
 */
@Data
@Entity
@DynamicUpdate
@Table(name = "cdp_sys_version_role_permission")
@ApiModel(value = "系统版本角色权限表实体类", description = "表(cdp_sys_version_role_permission)的对应的实体类")
public class CdpSysVersionRolePermissionEntity implements Serializable {
    private static final long serialVersionUID = -76333948871944145L;
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "主键，系统自动生成,角色权限ID")
    private Long id;
    
    @Basic
    @NotNull
    @Column(name = "role_id")
    @ApiModelProperty(value = "角色ID")
    private Long roleId;
    
    @Basic
    @NotNull
    @Column(name = "permission_id")
    @ApiModelProperty(value = "权限ID")
    private Long permissionId;
    
    @Basic
    @DateTimeFormat(pattern = DateTimeUtil.DATETIME_PATTERN)
    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    
    @Basic
    @NotNull
    @Column(name = "create_by")
    @ApiModelProperty(value = "创建人，该值由后台维护，更改数据时前端不需要关心，取值于cdp_sys_user.id")
    private Long createBy;
    
}