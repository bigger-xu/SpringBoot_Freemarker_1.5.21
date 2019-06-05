/*
 * @(#)  AdminUserController.java    2019-06-05 10:16:11
 * Project  :Spring boot 代码生产系统
 * Company  :http://www.594cto.com
 */
package com.cto.explosive.controller;

import com.cto.explosive.entity.AdminUser;
import com.cto.explosive.entity.vo.AdminUserVo;
import com.cto.explosive.service.AdminUserService;
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
 * 文件名AdminUserController.java
 *
 * @author 1
 * @date 2019-06-05 10:16:11
 */
@Controller
@RequestMapping("adminUser")
public class AdminUserController{
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminUserController.class);
    @Autowired
    private AdminUserService adminUserService;

    /**
     * 获取系统用户表列表页
     * @return
     */
    @RequestMapping
    public String index(Model model) {
        return "adminUser/index";
    }

    /**
     * 获取系统用户表分页数据
     *
     * @param search 查询条件
     * @return
     */
    @RequestMapping("page")
    @ResponseBody
    public Object list(AdminUserVo search) {
        try {
            //TODO 设置查询属性
            return adminUserService.selectPage(search);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }

    }

    /**
     * 创建或者更新系统用户表
     * @param adminUser 系统用户表对象
     * @return
     */
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Object saveOrUpdate(AdminUser adminUser) {
        try {
            if (adminUser.getId() == null) {
                adminUser.setAddTime(new Date());
                adminUserService.insert(adminUser);
            } else {
                adminUser.setUpdateTime(new Date());
                adminUserService.updateBySelective(adminUser);
            }
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }
    }


    /**
     * 删除指定ID的系统用户表信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{uuid}")
    @ResponseBody
    public Object delete(@PathVariable("uuid") String id, Model model) {
        try {
            adminUserService.deleteByUUId(id);
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }
    }
}
