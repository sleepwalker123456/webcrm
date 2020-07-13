package com.example.oautherssoserver.registry;

import com.example.oautherssoserver.entity.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author 40671
 */
public interface SysMenuRepository extends JpaRepository<SysMenu,Integer> , JpaSpecificationExecutor<SysMenu> {

    @Query(value = "select * from sys_menu where id in (:Ids)",nativeQuery = true)
    List<SysMenu> findAllById(@Param("Ids") List<Integer> Ids);

}
