package com.itheima.cache.controller;

import com.itheima.cache.common.R;
import com.itheima.cache.model.Role;
import com.itheima.cache.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * @author itheima
 * code
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @PostMapping("/add")
    public R add(@RequestBody Role role) {
        return roleService.add(role);
    }

    @DeleteMapping("/delete")
    public R delete(Integer id) {
        Integer count = roleService.delete(id);
        return R.ok(count);
    }

    @PutMapping("/update")
    public R update(@RequestBody Role role) {
        Assert.notNull(role.getId(),"Id is not null");
        Role roleResult = roleService.update(role);
        return R.ok(roleResult);
    }

    @GetMapping("/findById")
    public R findById1(@RequestParam Integer id) {
        Role role = roleService.findById(id);
        return R.ok(role);
    }

    @GetMapping("/findAll")
    public R findAll() {
        return roleService.findAllRole();
    }
}
