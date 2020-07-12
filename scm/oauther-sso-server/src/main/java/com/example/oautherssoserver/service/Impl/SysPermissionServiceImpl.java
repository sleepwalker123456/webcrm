package com.example.oautherssoserver.service.Impl;

import com.example.oautherssoserver.entity.SysPermission;
import com.example.oautherssoserver.entity.SysRolePermission;
import com.example.oautherssoserver.entity.SysUserRole;
import com.example.oautherssoserver.registry.SysPermissionRepository;
import com.example.oautherssoserver.registry.SysRolePermissionRepository;
import com.example.oautherssoserver.registry.SysUserRoleRepository;
import com.example.oautherssoserver.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sleepwalker
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService{

    @Autowired
    private SysPermissionRepository sysPermissionRepository;

    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;

    @Autowired
    private SysRolePermissionRepository sysRolePermissionRepository;

    @Override
    public List<SysPermission> findByUserId(Integer user_id) {
        List<SysPermission> sysPermissions = new ArrayList<>();

        List<SysUserRole> sysUserRoles = sysUserRoleRepository.findAllByUserId(user_id);

        if(sysUserRoles.isEmpty()){
            return sysPermissions;
        }

        List<Integer> roleIds = sysUserRoles.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());

        if(roleIds.isEmpty()){
            return sysPermissions;
        }

        List<SysRolePermission> sysRolePermissions = sysRolePermissionRepository.findAllByRoleId(roleIds);

        if(sysRolePermissions.isEmpty()){
            return sysPermissions;
        }

        List<Integer> permissionIds = sysRolePermissions.stream().map(SysRolePermission::getPermissionId).collect(Collectors.toList());

        if(permissionIds.isEmpty()){
            return sysPermissions;
        }

        sysPermissions = sysPermissionRepository.findByIds(permissionIds);

        return sysPermissions;
    }
}
