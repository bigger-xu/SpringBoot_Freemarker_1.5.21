/*
 * @(#)  AdminUserVo.java    2019-06-05 10:16:11
 * Project  :Spring boot 代码生产系统
 * Company  :http://www.594cto.com
 */
package com.cto.explosive.service.impl;

import com.cto.explosive.dao.AdminUserMapper;
import com.cto.explosive.entity.AdminUser;
import com.cto.explosive.entity.vo.AdminUserVo;
import com.cto.explosive.service.AdminUserService;
import com.cto.explosive.service.base.BaseServiceImpl;
import com.cto.explosive.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件名 AdminUserServiceImpl.java 
 * 
 * @author 1
 * @date 2019-06-05 10:16:11
 */
@Service
public class AdminUserServiceImpl extends BaseServiceImpl<AdminUser> implements AdminUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;
    @Override
    public AdminUserMapper getNameSpace() {
        return adminUserMapper;
    }

    @Override
    public Page<AdminUser> selectPage(AdminUser adminUser) {
        Page<AdminUser> page = new Page<>(adminUserMapper.selectPageCount(adminUser), adminUser.getPageSize(), adminUser.getPageNum());
        List<AdminUser> result = adminUserMapper.selectPageList(adminUser);
        page.setRows(result == null ? new ArrayList<>() : result);
        return page;
    }

    @Override
    public AdminUserVo getByUserName(String userName) {
        return adminUserMapper.getByUserName(userName);
    }
}