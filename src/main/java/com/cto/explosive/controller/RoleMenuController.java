/*
 * @(#)  RoleMenuController.java    2019-06-05 10:16:11
 * Project  :Spring boot 代码生产系统
 * Company  :http://www.594cto.com
 */
package com.cto.explosive.controller;

import com.cto.explosive.entity.RoleMenu;
import com.cto.explosive.entity.vo.RoleMenuVo;
import com.cto.explosive.service.RoleMenuService;
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
 * 文件名RoleMenuController.java
 *
 * @author 1
 * @date 2019-06-05 10:16:11
 */
@Controller
@RequestMapping("roleMenu")
public class RoleMenuController{
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleMenuController.class);
    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * 获取菜单角色对应关系列表页
     * @return
     */
    @RequestMapping
    public String index(Model model) {
        return "roleMenu/index";
    }

    /**
     * 获取菜单角色对应关系分页数据
     *
     * @param search 查询条件
     * @return
     */
    @RequestMapping("page")
    @ResponseBody
    public Object list(RoleMenuVo search) {
        try {
            //TODO 设置查询属性
            return roleMenuService.selectPage(search);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }

    }

    /**
     * 创建或者更新菜单角色对应关系
     * @param roleMenu 菜单角色对应关系对象
     * @return
     */
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Object saveOrUpdate(RoleMenu roleMenu) {
        try {
            if (roleMenu.getId() == null) {
                roleMenu.setAddTime(new Date());
                roleMenuService.insert(roleMenu);
            } else {
                roleMenu.setUpdateTime(new Date());
                roleMenuService.updateBySelective(roleMenu);
            }
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }
    }


    /**
     * 删除指定ID的菜单角色对应关系信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{uuid}")
    @ResponseBody
    public Object delete(@PathVariable("uuid") String id, Model model) {
        try {
            roleMenuService.deleteByUUId(id);
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }
    }
}
