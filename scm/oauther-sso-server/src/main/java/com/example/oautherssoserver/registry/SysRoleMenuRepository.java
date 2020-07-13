package com.example.oautherssoserver.registry;

import com.example.oautherssoserver.entity.SysRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author 40671
 */
public interface SysRoleMenuRepository extends JpaRepository<SysRoleMenu,Integer>, JpaSpecificationExecutor<SysRoleMenu> {

    @Query(value = "select * from sys_role_menu where role_id in (:roleIds)",nativeQuery = true)
    List<SysRoleMenu> findAllByRoleId(@Param("roleIds") List<Integer> roleIds);

}
