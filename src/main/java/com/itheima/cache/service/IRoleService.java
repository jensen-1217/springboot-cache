package com.itheima.cache.service;

import com.itheima.cache.common.R;
import com.itheima.cache.model.Role;

/**
 * @author itheima
 * code
 */
public interface IRoleService {
    R add(Role role);

    Integer delete(Integer id);

    Role update(Role role);

    Role findById(Integer id);

    R findAllRole();
}
