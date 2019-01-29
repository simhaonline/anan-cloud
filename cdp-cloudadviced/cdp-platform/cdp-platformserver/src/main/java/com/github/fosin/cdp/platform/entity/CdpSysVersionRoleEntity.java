package com.github.fosin.cdp.platform.entity;

import com.github.fosin.cdp.jpa.entity.AbstractCreateUpdateJpaEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
/**
 * 系统版本角色表(CdpSysVersionRole)实体类
 *
 * @author fosin
 * @date 2019-01-28 12:50:42
 * @since 1.0.0
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@DynamicUpdate
@Table(name = "cdp_sys_version_role")
@ApiModel(value = "系统版本角色表实体类", description = "表(cdp_sys_version_role)的对应的实体类")
public class CdpSysVersionRoleEntity extends AbstractCreateUpdateJpaEntity implements Serializable {
    private static final long serialVersionUID = 490900001033551923L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "角色ID, 主键，一般系统自动生成")
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @ApiModelProperty(value = "版本ID", required = true)
    @Column(name = "version_id", nullable = false)
    private Long versionId;

    @Basic
    @ApiModelProperty(value = "角色名称", required = true)
    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Basic
    @ApiModelProperty(value = "角色标识", required = true)
    @Column(name = "value", nullable = false, length = 64)
    private String value;

    @Basic
    @ApiModelProperty(value = "角色说明")
    @Column(name = "tips", length = 255)
    private String tips;

    @Basic
    @ApiModelProperty(value = "使用状态：0=启用，1=禁用，具体取值于字典表cdp_sys_dictionary.id=11", required = true)
    @Column(name = "status", nullable = false)
    private Integer status;

}