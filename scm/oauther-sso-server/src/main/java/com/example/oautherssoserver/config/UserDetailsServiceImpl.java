package com.example.oautherssoserver.config;

import com.example.oautherssoserver.entity.SysPermission;
import com.example.oautherssoserver.entity.SysUser;
import com.example.oautherssoserver.registry.SysUserRepository;
import com.example.oautherssoserver.service.SysPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sleepwalker
 */
@Slf4j
@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysPermissionService sysPermissionService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserRepository.findSysUserByUsername(username);
        if (null == sysUser) {
            throw new UsernameNotFoundException(username);
        }
        List<SysPermission> sysPermissionList = sysPermissionService.findByUserId(sysUser.getId());
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (SysPermission sysPermission : sysPermissionList){
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(sysPermission.getCode()));
        }
        return new User(sysUser.getUsername(),passwordEncoder.encode(sysUser.getPassword()),simpleGrantedAuthorities);
    }
}
