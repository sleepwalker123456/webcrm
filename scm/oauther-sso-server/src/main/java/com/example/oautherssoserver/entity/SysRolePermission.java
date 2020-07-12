package com.example.oautherssoserver.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author sleepwalker
 */
@Entity
@Table(schema = "sleepwalker", name = "sys_role_permission")
public class SysRolePermission implements Serializable {

    private static final long serialVersionUID = 9141929384589005222L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "permission_id")
    private Integer permissionId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}
