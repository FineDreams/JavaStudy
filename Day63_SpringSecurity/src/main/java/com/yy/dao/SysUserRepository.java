package com.yy.dao;

import com.yy.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser,Long>{

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    SysUser findByUsername(String username);

}
