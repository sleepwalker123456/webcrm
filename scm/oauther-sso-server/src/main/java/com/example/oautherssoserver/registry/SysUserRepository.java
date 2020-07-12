package com.example.oautherssoserver.registry;

import com.example.oautherssoserver.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @author 40671
 */
public interface SysUserRepository extends JpaRepository<SysUser,Integer>,JpaSpecificationExecutor<SysUser>{

    @Query(value = "SELECT * FROM sys_user WHERE username = ?1",nativeQuery = true)
    SysUser findSysUserByUsername(String username);


}
