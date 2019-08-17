package com.coolance.dto;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author Coolance
 * @Version
 * @Date 2019/8/17 8:56
 */
public class User {

    public interface UserSimpleView {}
    public interface UserDetailView extends UserSimpleView {}

    private String id;
    private String username;
    private String password;
    private Date birthday;

    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserDetailView.class)
    @NotBlank
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
