package com.itheima.cache;

import com.itheima.cache.common.R;
import com.itheima.cache.model.Role;
import com.itheima.cache.service.IRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CacheApplicationTests {

    @Autowired
    private IRoleService roleService;

    /**
     * @Description 缓存测试
     */
    @Test
    public void test3(){
        Role role = roleService.findById(2);
        System.out.println(role);
    }

    /**
     * @Description
     */
    @Test
    public void test4(){
        R allRole = roleService.findAllRole();
        System.out.println(allRole);
    }

    /**
     * @Description 更新缓存
     */
    @Test
    public void testUpdate(){
        Role role = Role.builder().id(100).rolecode("100").rolename("100Role").introduce("100Introduce").build();
        Role update = roleService.update(role);
        System.out.println(role);
    }

    /**
     * 测试缓存淘汰
     * 剔除缓存数据
     */
    @Test
    public void testDelete(){
        Integer count = roleService.delete(2);
        System.out.println(count);
    }

    /**
     * @Description 测试@Caching复合缓存操作
     */
    @Test
    public void testCaching(){
        Role role = Role.builder().id(15).rolecode("150").rolename("150Role").introduce("150Introduce").build();
        roleService.add(role);
    }

}
