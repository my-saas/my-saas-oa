package com.stef.oa.controller;

import com.stef.oa.entity.User;
import com.stef.oa.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stef.oa.common.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 用户表
 *
 * @author stef
 * @date 2021-05-05
 */
@RestController
@RequestMapping("//user")
@Api(value = "//user", tags = "用户表管理")
public class UserController {

    @Autowired
    private  UserService userService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param user 用户表
     * @return RespBean
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public RespBean getUserControllerPage(Page page, User user) {
        return RespBean.ok(userService.page(page, Wrappers.query(user)));
    }


    /**
     * 通过id查询用户表
     * @param id id
     * @return RespBean
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    public RespBean getById(@PathVariable("id" ) Long id) {
        return RespBean.ok(userService.getById(id));
    }

    /**
     * 新增用户表
     * @param user 用户表
     * @return RespBean
     */
    @ApiOperation(value = "新增用户表", notes = "新增用户表")
    @PostMapping
    public RespBean save(@RequestBody User  user) {
        return RespBean.ok(userService.save(user));
    }

    /**
     * 修改用户表
     * @param user 用户表
     * @return RespBean
     */
    @ApiOperation(value = "修改用户表", notes = "修改用户表")
    @PutMapping
    public RespBean updateById(@RequestBody User  user) {
        return RespBean.ok(userService.updateById(user));
    }

    /**
     * 通过id删除用户表
     * @param id id
     * @return RespBean
     */
    @ApiOperation(value = "通过id删除用户表", notes = "通过id删除用户表")
    @DeleteMapping("/{id}" )
    public RespBean removeById(@PathVariable Long id) {
        return RespBean.ok(userService.removeById(id));
    }

}
