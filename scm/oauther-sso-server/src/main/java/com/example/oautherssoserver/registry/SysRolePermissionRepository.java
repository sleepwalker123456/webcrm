package com.example.oautherssoserver.registry;

import com.example.oautherssoserver.entity.SysRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SysRolePermissionRepository extends JpaRepository<SysRolePermission,Integer>,JpaSpecificationExecutor<SysRolePermission>{

    @Query(value = "SELECT * FROM sys_role_permission WHERE role_id in (:roleIds)",nativeQuery = true)
    List<SysRolePermission> findAllByRoleId(@Param("roleIds") List<Integer> roleIds);

}
