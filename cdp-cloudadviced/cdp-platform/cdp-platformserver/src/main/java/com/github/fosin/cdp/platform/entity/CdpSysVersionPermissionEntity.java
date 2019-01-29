package com.github.fosin.cdp.platform.entity;

import com.github.fosin.cdp.jpa.entity.AbstractCreateJpaEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
/**
 * 系统版本权限表(CdpSysVersionPermission)实体类
 *
 * @author fosin
 * @date 2019-01-28 12:50:38
 * @since 1.0.0
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@DynamicUpdate
@Table(name = "cdp_sys_version_permission")
@ApiModel(value = "系统版本权限表实体类", description = "表(cdp_sys_version_permission)的对应的实体类")
public class CdpSysVersionPermissionEntity extends AbstractCreateJpaEntity implements Serializable {
    private static final long serialVersionUID = 117455991817648863L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "版本权限ID, 主键，一般系统自动生成")
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @ApiModelProperty(value = "版本ID", required = true)
    @Column(name = "version_id", nullable = false)
    private Long versionId;

    @Basic
    @ApiModelProperty(value = "权限ID", required = true)
    @Column(name = "permission_id", nullable = false)
    private Long permissionId;

}