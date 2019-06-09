/*
 * @(#)  RoleVo.java    2019-06-05 10:16:11
 * Project  :Spring boot 代码生产系统
 * Company  :http://www.594cto.com
 */
package com.cto.explosive.service.impl;

import com.cto.explosive.dao.RoleMapper;
import com.cto.explosive.entity.Role;
import com.cto.explosive.service.RoleService;
import com.cto.explosive.service.base.BaseServiceImpl;
import com.cto.explosive.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件名 RoleServiceImpl.java 
 * 
 * @author 1
 * @date 2019-06-05 10:16:11
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public RoleMapper getNameSpace() {
        return roleMapper;
    }

    @Override
    public Page<Role> selectPage(Role role) {
        Page<Role> page = new Page<>(roleMapper.selectPageCount(role), role.getPageSize(), role.getPageNum());
        List<Role> result = roleMapper.selectPageList(role);
        page.setRows(result == null ? new ArrayList<>() : result);
        return page;
    }

    @Override
    public List<Role> selectListByUserId(Long id) {
        return roleMapper.selectListByUserId(id);
    }

    @Override
    public Role selectEntityByCode(String userType) {
        return roleMapper.selectEntityByCode(userType);
    }
}