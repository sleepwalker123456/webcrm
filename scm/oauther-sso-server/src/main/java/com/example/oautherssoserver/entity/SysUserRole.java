package com.example.oautherssoserver.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @author sleepwalker
 */
@Entity
@Table(schema = "sleepwalker", name = "sys_user_role")
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 2507421379318311961L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "role_id")
    private Integer roleId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
