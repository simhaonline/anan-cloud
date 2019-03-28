package com.github.fosin.cdp.auth.service;

import com.github.fosin.cdp.auth.service.inter.IPermissionService;
import com.github.fosin.cdp.jpa.repository.IJpaRepository;
import com.github.fosin.cdp.platformapi.constant.TableNameConstant;
import com.github.fosin.cdp.platformapi.entity.CdpPermissionEntity;
import com.github.fosin.cdp.platformapi.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2017/12/29.
 * Time:12:38
 *
 * @author fosin
 */
@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    @Cacheable(value = TableNameConstant.CDP_PERMISSION, key = "#id")
    public CdpPermissionEntity findOne(Long id) {
        return permissionRepository.findOne(id);
    }

    @Override
    public List<CdpPermissionEntity> findByAppName(String appName) {
        return permissionRepository.findByAppName(appName);
    }

    @Override
    public IJpaRepository<CdpPermissionEntity, Long> getRepository() {
        return permissionRepository;
    }
}