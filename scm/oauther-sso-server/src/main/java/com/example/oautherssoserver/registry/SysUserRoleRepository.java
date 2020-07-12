package com.example.oautherssoserver.registry;

import com.example.oautherssoserver.entity.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author 40671
 */
public interface SysUserRoleRepository extends JpaRepository<SysUserRole,Integer>,JpaSpecificationExecutor<SysUserRole>{

    @Query(value = "SELECT * FROM sys_user_role WHERE user_id = (:userId)",nativeQuery = true)
    List<SysUserRole> findAllByUserId(@Param("userId") Integer userId);


}
