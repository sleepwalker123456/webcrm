package com.example.oautherssoserver.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 40671
 */
@Entity
@Table(schema = "sleepwalker",name = "sys_role_menu")
public class SysRoleMenu implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "menu_id")
    private Integer menuId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}
