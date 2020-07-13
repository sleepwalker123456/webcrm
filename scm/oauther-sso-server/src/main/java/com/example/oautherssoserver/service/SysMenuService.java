package com.example.oautherssoserver.service;

import com.example.oautherssoserver.entity.SysMenu;

import java.util.List;

/**
 * @author 40671
 */
public interface SysMenuService {

    List<SysMenu> findByUserName(String username);

}
