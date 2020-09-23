package com.adamborowski.forumapp.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LoginValidator.class)
@Documented
public @interface NotExistingLogin {
    String message() default "Login already exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
