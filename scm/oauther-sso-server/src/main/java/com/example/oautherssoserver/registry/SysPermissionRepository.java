package com.example.oautherssoserver.registry;

import com.example.oautherssoserver.entity.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * @author 40671
 */
public interface SysPermissionRepository extends JpaRepository<SysPermission, Integer>,JpaSpecificationExecutor<SysPermission> {


    @Query(value = "SELECT * FROM sys_permission WHERE id IN (:ids)",nativeQuery = true)
    List<SysPermission> findByIds(@Param("ids") List<Integer> ids);

}
