package com.example.oautherssoserver.service;

import com.example.oautherssoserver.entity.SysPermission;

import java.util.List;

/**
 * @author sleepwalker
 */
public interface SysPermissionService {

    List<SysPermission> findByUserId(Integer user_id);


}
