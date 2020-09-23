package com.adamborowski.forumapp.validator;

import com.adamborowski.forumapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class LoginValidator implements ConstraintValidator<NotExistingLogin, String> {
    @Autowired
    private UserService usersService;

    public void initialize(NotExistingLogin notExistingLogin) {
    }

    public boolean isValid(String login, ConstraintValidatorContext constraintValidatorContext) {
        return !usersService.isLoginExist(login);
    }
}
