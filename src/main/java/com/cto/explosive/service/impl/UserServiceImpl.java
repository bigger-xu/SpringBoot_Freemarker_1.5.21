package com.cto.explosive.service.impl;

import com.cto.explosive.dao.UserMapper;
import com.cto.explosive.entity.User;
import com.cto.explosive.entity.vo.UserVo;
import com.cto.explosive.service.UserService;
import com.cto.explosive.service.base.BaseServiceImpl;
import com.cto.explosive.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Yongwei
 * @version 1.0
 * @date 2019-03-20
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserMapper getNameSpace() {
        return userMapper;
    }

    @Override
    public User selectByUserName(String userName) {
        return userMapper.selectByUserName(userName);
    }

    @Override
    public Page<User> selectPage(UserVo userVo) {
        Page<User> page = new Page<>(userMapper.selectPageCount(userVo), userVo.getPageSize(), userVo.getPageNum());
        List<User> result = userMapper.selectPageList(userVo);
        page.setRows(result == null ? new ArrayList<>() : result);
        return page;
    }
}
