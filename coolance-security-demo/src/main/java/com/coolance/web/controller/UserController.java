package com.coolance.web.controller;

import com.coolance.dto.User;
import com.coolance.dto.UserQueryCondition;
import com.coolance.security.app.social.AppSignUpUtils;
import com.coolance.security.core.properties.SecurityProperties;
import com.fasterxml.jackson.annotation.JsonView;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserController
 * @Description UserAPI
 * @Author Coolance
 * @Version
 * @Date 2019/8/17 8:55
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @Autowired
    private AppSignUpUtils appSignUpUtils;

    @Autowired
    private SecurityProperties securityProperties;

    @PostMapping("/browser/register")
    public void browserRegister(User user, HttpServletRequest request) {
        providerSignInUtils.doPostSignUp(user.getUsername(), new ServletWebRequest(request));
    }

    @PostMapping("/app/register")
    public void appRegister(User user, HttpServletRequest request) {
        appSignUpUtils.doPostSignUp(user.getUsername(), new ServletWebRequest(request));
    }

    @GetMapping("/me1")
    public Authentication getCurrentUser(Authentication authentication, HttpServletRequest request) throws UnsupportedEncodingException {
        String header = request.getHeader("Authorization");
        String token = StringUtils.substringAfter(header, "bearer ");
        Claims claims = Jwts.parser().setSigningKey(securityProperties.getOauth2().getJwtSigningKey().getBytes("UTF-8"))
                .parseClaimsJws(token).getBody();
        log.info("--->" + claims.get("company"));

        return authentication;
        //return SecurityContextHolder.getContext().getAuthentication();
    }

    @GetMapping("/me")
    public UserDetails getCurrentUser(@AuthenticationPrincipal UserDetails user) {
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable("id") String id) {
        System.out.println(id);
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {

        if(errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
                FieldError fieldError = (FieldError)error;
                String message = fieldError.getField() + ":" + error.getDefaultMessage();
                System.out.println(message);
            });
        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        return user;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user/*, BindingResult errors*/) {
        /*
        if(errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        */
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    @ApiOperation(value = "用户查询服务", notes = "查询用户")
    public List<User> query(UserQueryCondition condition,
                            @PageableDefault(page = 2, size = 17, sort = "username,asc") Pageable pageable) {
        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    @ApiOperation(value = "根据id查询用户服务")
    public User getInfo(@ApiParam(value = "用户id")@PathVariable("id") String id) {
        //throw new UserNotExistException(id);
        System.out.println(System.getProperty("user.dir"));
        System.out.println("UserController.getInfo()");
        User user = new User();
        user.setUsername("coolance");
        return user;
    }
}
