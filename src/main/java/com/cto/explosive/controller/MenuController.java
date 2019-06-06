/*
 * @(#)  MenuController.java    2019-06-06 12:08:40
 * Project  :Spring boot 代码生产系统
 * Company  :http://www.594cto.com
 */
package com.cto.explosive.controller;

import com.cto.explosive.entity.Menu;
import com.cto.explosive.entity.vo.MenuVo;
import com.cto.explosive.service.MenuService;
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
 * 文件名MenuController.java
 *
 * @author Zhang Yongwei
 * @date 2019-06-06 12:08:40
 */
@Controller
@RequestMapping("menu")
public class MenuController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);
    @Autowired
    private MenuService menuService;

    /**
     * 获取系统菜单表列表页
     * @return
     */
    @RequestMapping
    public String index(Model model) {
        return "menu/index";
    }

    /**
     * 获取系统菜单表分页数据
     *
     * @param search 查询条件
     * @return
     */
    @RequestMapping("page")
    @ResponseBody
    public Object list(MenuVo search) {
        try {
            //TODO 设置查询属性
            return menuService.selectPage(search);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }

    }


    /**
     * 获取系统菜单表添加页
     * @return
     */
    @RequestMapping(value = "/add")
    public String add(Model model) {
        return "menu/add";
    }

    /**
     * 获取系统菜单表编辑页
     * @return
     */
    @RequestMapping(value = "/edit")
    public String edit(Long id,Model model) {
        if(id != null){
            Menu menu = menuService.selectEntityById(id);
            model.addAttribute("menu", menu);
        }
        return "menu/edit";
    }

    /**
     * 创建或者更新系统菜单表
     * @param menu 系统菜单表对象
     * @return
     */
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Object saveOrUpdate(Menu menu) {
        try {
            if (menu.getId() == null) {
                menu.setAddTime(new Date());
                menuService.insert(menu);
            } else {
                menu.setUpdateTime(new Date());
                menuService.updateBySelective(menu);
            }
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }
    }

    /**
     * 删除指定ID的系统菜单表信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(Long id, Model model) {
        try {
            menuService.deleteById(id);
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }
    }
}
