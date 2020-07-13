package com.example.oautherssoserver.entity;

import rx.BackpressureOverflow;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author 40671
 */

@Entity
@Table(schema = "sleepwalker", name = "sys_menu")
public class SysMenu  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "pid")
    private Integer pid;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "uri")
    private String uri;

    @Column(name = "seq")
    private String seq;

    @Column(name = "status")
    private Integer status;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "create_time")
    private LocalDate createTime;

    @Column(name = "update_time")
    private LocalDate updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public LocalDate getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDate updateTime) {
        this.updateTime = updateTime;
    }
}
