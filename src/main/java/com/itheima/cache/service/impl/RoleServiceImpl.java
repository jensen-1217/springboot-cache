package com.itheima.cache.service.impl;

import com.itheima.cache.common.R;
import com.itheima.cache.mapper.RoleMapper;
import com.itheima.cache.model.Role;
import com.itheima.cache.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author itheima
 */
@Service
@CacheConfig(cacheNames = "role")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Cacheable(key = "#id")
    @Override
    public Role findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    @Cacheable(key = "#root.methodName")
    public R findAllRole() {
        List<Role> roleList = roleMapper.findAll();
        return R.ok(roleList);
    }

    @Override
    @CacheEvict(key = "#id")
    public Integer delete(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    @CachePut(key = "#result.id")
    @CacheEvict(key = "'findAllRole'")
    public Role update(Role role) {
        roleMapper.updateByPrimaryKey(role);
        return role;
    }

    @Override
    @Caching(
            cacheable = {
                    @Cacheable(key = "#role.rolename")

            },
            put = {
                    @CachePut(key = "#role.id"),
                    @CachePut(key = "#role.rolecode")
            },
            evict = {
                    @CacheEvict(key = "10")
            }
    )
    public R add(Role role) {
        try {
            roleMapper.insert(role);
        } catch (Exception e) {
            return R.error();
        }
        return R.ok(role.getId());
    }

}
