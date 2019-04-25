package com.github.fosin.anan.platform.service;

import com.github.fosin.anan.jpa.repository.IJpaRepository;
import com.github.fosin.anan.mvc.module.PageModule;
import com.github.fosin.anan.mvc.result.Result;
import com.github.fosin.anan.mvc.result.ResultUtils;
import com.github.fosin.anan.platform.service.inter.PermissionService;
import com.github.fosin.anan.platform.service.inter.RolePermissionService;
import com.github.fosin.anan.platform.service.inter.UserPermissionService;
import com.github.fosin.anan.platformapi.constant.TableNameConstant;
import com.github.fosin.anan.platformapi.dto.request.AnanPermissionCreateDto;
import com.github.fosin.anan.platformapi.dto.request.AnanPermissionUpdateDto;
import com.github.fosin.anan.platformapi.entity.AnanPermissionEntity;
import com.github.fosin.anan.platformapi.repository.PermissionRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Objects;

/**
 * 2017/12/29.
 * Time:12:38
 *
 * @author fosin
 */
@Service
@Lazy
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserPermissionService userPermissionService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Override
    @CachePut(value = TableNameConstant.ANAN_PERMISSION, key = "#result.id")
    public AnanPermissionEntity create(AnanPermissionCreateDto entity) {
        Assert.notNull(entity, "传入的创建数据实体对象不能为空!");

        AnanPermissionEntity createEntity = new AnanPermissionEntity();
        BeanUtils.copyProperties(entity, createEntity);
        Long pId = entity.getPId();

        int level = 1;
        if (pId != 0) {
            AnanPermissionEntity parentEntity = permissionRepository.findById(pId).orElse(null);
            Assert.notNull(parentEntity, "传入的创建数据实体找不到对于的父节点数据!");
            level = parentEntity.getLevel() + 1;
        }
        createEntity.setLevel(level);
        return permissionRepository.save(createEntity);
    }

    @Override
    @CachePut(value = TableNameConstant.ANAN_PERMISSION, key = "#entity.id")
    public AnanPermissionEntity update(AnanPermissionUpdateDto entity) {
        Assert.notNull(entity, "传入了空对象!");
        Long id = entity.getId();
        Assert.notNull(id, "传入了空ID!");

        AnanPermissionEntity updateEntity = permissionRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(entity, Objects.requireNonNull(updateEntity, "通过ID：" + id + "未能找到对应的数据!"));
        Long pId = entity.getPId();
        if (!updateEntity.getPId().equals(pId)) {
            AnanPermissionEntity parentEntity = permissionRepository.findById(pId).orElse(null);
            Assert.notNull(parentEntity, "传入的创建数据实体找不到对于的父节点数据!");
            updateEntity.setLevel(parentEntity.getLevel() + 1);
        }

        return permissionRepository.save(updateEntity);
    }


    @Override
    @CacheEvict(value = TableNameConstant.ANAN_PERMISSION, key = "#id")
    public AnanPermissionEntity deleteById(Long id) {
        Assert.notNull(id, "传入了空ID!");
        AnanPermissionEntity entity = permissionRepository.findById(id).orElse(null);
        deleteById(id, Objects.requireNonNull(entity, "通过ID：" + id + "未能找到对应的数据!"));
        return null;
    }

    private void deleteById(Long id, AnanPermissionEntity entity) {
        long countByPermissionId = rolePermissionService.countByPermissionId(id);
        Assert.isTrue(countByPermissionId == 0, "还有角色在使用该权限，不能直接删除!");
        countByPermissionId = userPermissionService.countByPermissionId(id);
        Assert.isTrue(countByPermissionId == 0, "还有用户在使用该权限，不能直接删除!");
        List<AnanPermissionEntity> entities = findByPId(id);
        Assert.isTrue(entities == null || entities.size() == 0, "该节点还存在子节点不能直接删除!");
        permissionRepository.delete(entity);
    }

    @Override
    @CacheEvict(value = TableNameConstant.ANAN_PERMISSION, key = "#entity.id")
    public AnanPermissionEntity deleteByEntity(AnanPermissionEntity entity) {
        Assert.notNull(entity, "传入了空对象!");
        Long id = entity.getId();
        Assert.notNull(id, "传入了空ID!");
        deleteById(id, entity);
        return entity;
    }

    @Override
    public Result findAllByPageSort(PageModule pageModule) {
        PageRequest pageable = PageRequest.of(pageModule.getPageNumber() - 1, pageModule.getPageSize(), Sort.Direction.fromString(pageModule.getSortOrder()), pageModule.getSortName());
        String searchCondition = pageModule.getSearchText();

        Specification<AnanPermissionEntity> condition = (Specification<AnanPermissionEntity>) (root, query, cb) -> {
            if (StringUtils.isBlank(searchCondition)) {
                return query.getRestriction();
            }
            Path<String> name = root.get("name");
            Path<String> code = root.get("code");
            Path<String> url = root.get("url");
            Path<String> type = root.get("type");
            return cb.or(cb.like(name, "%" + searchCondition + "%"), cb.like(code, "%" + searchCondition + "%"), cb.like(url, "%" + searchCondition + "%"), cb.like(type, "%" + searchCondition + "%"));
        };
        //分页查找
        Page<AnanPermissionEntity> page = permissionRepository.findAll(condition, pageable);

        return ResultUtils.success(page.getTotalElements(), page.getContent());
    }

    @Override
    @Cacheable(value = TableNameConstant.ANAN_PERMISSION, key = "#id")
    public AnanPermissionEntity findById(Long id) {
        return permissionRepository.findById(id).orElse(null);
    }

    @Override
    public List<AnanPermissionEntity> findByPId(Long pId) {
        Sort sort = new Sort(Sort.Direction.fromString("ASC"), "sort");
        return permissionRepository.findByPId(pId, sort);
    }

    @Override
    public List<AnanPermissionEntity> findByPId(Long pId, Long versionId) {
        return permissionRepository.findByPId(pId, versionId);
    }

    @Override
    public List<AnanPermissionEntity> findByType(Integer type) {
        return permissionRepository.findByType(type);
    }

    @Override
    public List<AnanPermissionEntity> findByAppName(String appName) {
        return permissionRepository.findByAppName(appName);
    }

    @Override
    public IJpaRepository<AnanPermissionEntity, Long> getRepository() {
        return permissionRepository;
    }
}