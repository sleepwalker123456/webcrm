package com.example.oautherssoserver.service.Impl;

import com.example.oautherssoserver.entity.*;
import com.example.oautherssoserver.registry.SysMenuRepository;
import com.example.oautherssoserver.registry.SysRoleMenuRepository;
import com.example.oautherssoserver.registry.SysUserRepository;
import com.example.oautherssoserver.registry.SysUserRoleRepository;
import com.example.oautherssoserver.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 40671
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuRepository sysMenuRepository;

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;

    @Autowired
    private SysRoleMenuRepository sysRoleMenuRepository;

    @Override
    public List<SysMenu> findByUserName(String username) {
        SysUser sysUser = sysUserRepository.findSysUserByUsername(username);
        List<SysUserRole> sysUserRoles = sysUserRoleRepository.findAllByUserId(sysUser.getId());
        List<Integer> roleIds = sysUserRoles.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        List<SysRoleMenu> sysRoleMenus = sysRoleMenuRepository.findAllByRoleId(roleIds);
        List<Integer> menuIds = sysRoleMenus.stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
        List<SysMenu> sysMenus = sysMenuRepository.findAllById(menuIds);
        return sysMenus;
    }
}
