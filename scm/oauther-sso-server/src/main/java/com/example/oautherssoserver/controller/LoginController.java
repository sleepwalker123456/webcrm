package com.example.oautherssoserver.controller;

import com.example.oautherssoserver.entity.MyUser;
import com.example.oautherssoserver.entity.SysMenu;
import com.example.oautherssoserver.service.SysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.expression.Lists;
import org.thymeleaf.util.ListUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sleepwalker
 */
@Controller
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String index(Principal user) {
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<GrantedAuthority> simpleGrantedAuthorities = userDetails.getAuthorities();
        List<String> roles = simpleGrantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        logger.info("当前登陆的用户: " + user.getName());
        List<SysMenu> sysMenus = sysMenuService.findByUserName(user.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sysMenus",sysMenus);
        return "index";
    }

    @RequestMapping("/login-error.html")
    public String loginError(HttpServletRequest request, HttpServletResponse response, final Model model) {
        HttpSession session = request.getSession();
        AuthenticationException authenticationException = (AuthenticationException) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        logger.info("/login-error.html : " + authenticationException.getMessage());
        model.addAttribute("loginError", true);
        return "login";
    }

}
