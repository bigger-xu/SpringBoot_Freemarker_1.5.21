/*
 * @(#)  RoleMenuVo.java    2019-06-05 10:16:11
 * Project  :Spring boot 代码生产系统
 * Company  :http://www.594cto.com
 */
package com.cto.explosive.service;

import com.cto.explosive.entity.RoleMenu;
import com.cto.explosive.service.base.BaseService;
import com.cto.explosive.utils.Page;

/**
 * 文件名 RoleMenuService.java
 * 
 * @author 1
 * @date 2019-06-05 10:16:11
 */
public interface RoleMenuService extends BaseService<RoleMenu> {
    /**
     * 查询分页
     * @param roleMenu
     * @return
     */
    Page<RoleMenu> selectPage(RoleMenu roleMenu);

    /**
     * 根据权限ID删除
     * @param id
     */
    void deleteByRoleId(Long id);
}
