package com.example.oautherssoserver.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author sleepwalker
 */
public class MyUser extends User {

    private int departmentId;

    private String telephone;


    public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities, int departmentId, String telephone) {
        super(username, password, authorities);
        this.departmentId = departmentId;
        this.telephone = telephone;
    }

    public MyUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, int departmentId, String telephone) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.departmentId = departmentId;
        this.telephone = telephone;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
