/*
 * @(#)  AdminUserVo.java    2019-06-05 10:16:11
 * Project  :Spring boot 代码生产系统
 * Company  :http://www.594cto.com
 */
package com.cto.explosive.dao;

import com.cto.explosive.dao.base.BaseDao;
import com.cto.explosive.entity.AdminUser;
import com.cto.explosive.entity.vo.AdminUserVo;
import org.springframework.stereotype.Repository;

/**
 * 文件名 AdminUserMapper.java
 *
 * @author 1
 * @date 2019-06-05 10:16:11
 */
@Repository
public interface AdminUserMapper extends BaseDao<AdminUser> {

    /**
     * 根据名称获取用户
     * @param userName
     * @return
     */
    AdminUserVo getByUserName(String userName);
}