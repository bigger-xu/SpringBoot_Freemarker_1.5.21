/*
 * @(#)  RoleUserController.java    2019-06-06 12:08:40
 * Project  :Spring boot 代码生产系统
 * Company  :http://www.594cto.com
 */
package com.cto.explosive.controller;

import com.cto.explosive.entity.RoleUser;
import com.cto.explosive.entity.vo.RoleUserVo;
import com.cto.explosive.service.RoleUserService;
import com.cto.explosive.utils.Result;
import com.cto.explosive.utils.SessionUtil;
import com.cto.explosive.controller.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 文件名RoleUserController.java
 *
 * @author Zhang Yongwei
 * @date 2019-06-06 12:08:40
 */
@Controller
@RequestMapping("roleUser")
public class RoleUserController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleUserController.class);
    @Autowired
    private RoleUserService roleUserService;

    /**
     * 获取用户角色对应关系列表页
     * @return
     */
    @RequestMapping
    public String index(Model model) {
        return "roleUser/index";
    }

    /**
     * 获取用户角色对应关系分页数据
     *
     * @param search 查询条件
     * @return
     */
    @RequestMapping("page")
    @ResponseBody
    public Object list(RoleUserVo search) {
        try {
            //TODO 设置查询属性
            return roleUserService.selectPage(search);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }

    }


    /**
     * 获取用户角色对应关系添加页
     * @return
     */
    @RequestMapping(value = "/add")
    public String add(Model model) {
        return "roleUser/add";
    }

    /**
     * 获取用户角色对应关系编辑页
     * @return
     */
    @RequestMapping(value = "/edit")
    public String edit(Long id,Model model) {
        if(id != null){
            RoleUser roleUser = roleUserService.selectEntityById(id);
            model.addAttribute("roleUser", roleUser);
        }
        return "roleUser/edit";
    }

    /**
     * 创建或者更新用户角色对应关系
     * @param roleUser 用户角色对应关系对象
     * @return
     */
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Object saveOrUpdate(RoleUser roleUser) {
        try {
            if (roleUser.getId() == null) {
                roleUser.setAddTime(new Date());
                roleUserService.insert(roleUser);
            } else {
                roleUser.setUpdateTime(new Date());
                roleUserService.updateBySelective(roleUser);
            }
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }
    }

    /**
     * 删除指定ID的用户角色对应关系信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(Long id, Model model) {
        try {
            roleUserService.deleteById(id);
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }
    }
}
