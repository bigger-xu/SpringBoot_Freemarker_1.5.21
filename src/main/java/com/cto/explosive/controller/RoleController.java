/*
 * @(#)  RoleController.java    2019-06-05 10:16:11
 * Project  :Spring boot 代码生产系统
 * Company  :http://www.594cto.com
 */
package com.cto.explosive.controller;

import com.cto.explosive.entity.Role;
import com.cto.explosive.entity.vo.RoleVo;
import com.cto.explosive.service.RoleService;
import com.cto.explosive.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 文件名RoleController.java
 *
 * @author 1
 * @date 2019-06-05 10:16:11
 */
@Controller
@RequestMapping("role")
public class RoleController{
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private RoleService roleService;

    /**
     * 获取角色表列表页
     * @return
     */
    @RequestMapping
    public String index(Model model) {
        return "role/index";
    }

    /**
     * 获取角色表分页数据
     *
     * @param search 查询条件
     * @return
     */
    @RequestMapping("page")
    @ResponseBody
    public Object list(RoleVo search) {
        try {
            //TODO 设置查询属性
            return roleService.selectPage(search);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }

    }

    /**
     * 创建或者更新角色表
     * @param role 角色表对象
     * @return
     */
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Object saveOrUpdate(Role role) {
        try {
            if (role.getId() == null) {
                role.setAddTime(new Date());
                roleService.insert(role);
            } else {
                role.setUpdateTime(new Date());
                roleService.updateBySelective(role);
            }
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }
    }


    /**
     * 删除指定ID的角色表信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{uuid}")
    @ResponseBody
    public Object delete(@PathVariable("uuid") String id, Model model) {
        try {
            roleService.deleteByUUId(id);
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }
    }
}
