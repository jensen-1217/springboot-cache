package com.itheima.cache.mapper;

import com.itheima.cache.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Entity com.itheima.cache.model.Role
 */
@Mapper
public interface RoleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> findAll();

}




