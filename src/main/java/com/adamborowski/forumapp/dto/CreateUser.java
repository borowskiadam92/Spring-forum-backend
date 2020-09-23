package com.adamborowski.forumapp.dto;

import com.adamborowski.forumapp.validator.NotExistingLogin;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data

public class CreateUser {

    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String email;
    @NotNull
    //@NotExistingLogin
    private String login;
    @NotNull
    private String password;
    @NotNull

    private String confirmPassword;

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public void setMatchingPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        checkPassword();
    }

    private void checkPassword() {
        if (this.password == null || this.confirmPassword == null) {
            return;
        } else if (!this.password.equals(confirmPassword)) {
            this.confirmPassword = null;
        }
    }
}
