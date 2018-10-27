package com.github.fosin.cdp.platformapi.service.inter;


import com.github.fosin.cdp.mvc.service.ICrudBatchService;
import com.github.fosin.cdp.platformapi.entity.CdpSysRolePermissionEntity;

import java.util.Collection;
import java.util.List;

/**
 *  2017/12/29.
 * Time:12:37
 * @author fosin
 */
public interface IRolePermissionService extends ICrudBatchService<CdpSysRolePermissionEntity,Long> {
    List<CdpSysRolePermissionEntity> findByRoleId(Long roleId);

    long countByPermissionId(Long permissionId);

    List<CdpSysRolePermissionEntity> updateInBatch(Long roleId, Collection<CdpSysRolePermissionEntity> entities);
}