package com.github.fosin.cdp.platformapi.repository;

import com.github.fosin.cdp.platformapi.entity.CdpSysVersionRolePermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Lazy;
/**
 * 系统版本角色权限表(cdp_sys_version_role_permission)表数据库访问层
 *
 * @author fosin
 * @date 2018-11-18 17:26:40
 */
@Repository
@Lazy
public interface CdpSysVersionRolePermissionRepository extends JpaRepository<CdpSysVersionRolePermissionEntity, Long>,JpaSpecificationExecutor<CdpSysVersionRolePermissionEntity>{
}