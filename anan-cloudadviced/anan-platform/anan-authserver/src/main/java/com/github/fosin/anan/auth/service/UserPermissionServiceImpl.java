package com.github.fosin.anan.auth.service;

import com.github.fosin.anan.auth.service.inter.UserPermissionService;
import com.github.fosin.anan.platformapi.constant.TableNameConstant;
import com.github.fosin.anan.platformapi.entity.AnanUserPermissionEntity;
import com.github.fosin.anan.platformapi.repository.UserPermissionRepository;
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
public class UserPermissionServiceImpl implements UserPermissionService {
    @Autowired
    private UserPermissionRepository userPermissionRepository;

    @Override
    @Cacheable(value = TableNameConstant.ANAN_USER_PERMISSION, key = "#userId")
    public List<AnanUserPermissionEntity> findByUserId(Long userId) {
        return userPermissionRepository.findByUserId(userId);
    }
}