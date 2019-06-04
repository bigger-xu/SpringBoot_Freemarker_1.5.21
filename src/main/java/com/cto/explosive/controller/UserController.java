package com.cto.explosive.controller;

import com.cto.explosive.entity.User;
import com.cto.explosive.entity.vo.UserVo;
import com.cto.explosive.service.UserService;
import com.cto.explosive.utils.Md5Util;
import com.cto.explosive.utils.Result;
import com.cto.explosive.utils.SessionUtil;
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
 * @author Zhang Yongwei
 * @version 1.0
 * @date 2019-03-21
 */
@Controller
@RequestMapping("user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 获取用户表列表页
     * @return
     */
    @RequestMapping
    public String index(Model model) {
        return "user/index";
    }

    /**
     * 获取用户表分页数据
     *
     * @param search 查询条件
     * @return
     */
    @RequestMapping("page")
    public Object list(UserVo search, Model model) {
        try {
            //TODO 设置查询属性
            return userService.selectPage(search);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }

    }

    /**
     * 创建或者更新用户表
     * @param user 用户表对象
     * @return
     */
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
    public Object saveOrUpdate(User user, HttpServletRequest request) {
        try {
            if (user.getId() == null) {
                user.setCreateTime(new Date());
                userService.insert(user);
            } else {
                user.setUpdateTime(new Date());
                userService.updateBySelective(user);
            }
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }
    }


    /**
     * 删除指定ID的用户表信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}")
    public Object delete(@PathVariable("id") Long id, Model model) {
        try {
            userService.deleteById(id);
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }
    }

    /**
     * 用户登录
     * @param userName
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(value = "login")
    @ResponseBody
    public Result login(String userName, String password, HttpServletRequest request){
        User user = userService.selectByUserName(userName);
        if(user != null){
            if(user.getPassword().equals(Md5Util.compute(password))){
                SessionUtil.setUser(request, user);
                LOGGER.info("用户登录成功,用户名:{}",user.getUserName());
                return Result.ok();
            }else{
                return Result.error();
            }
        }else{
            return Result.error();
        }
    }

}
