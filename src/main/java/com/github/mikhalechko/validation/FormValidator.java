package com.github.mikhalechko.validation;

import com.github.mikhalechko.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class FormValidator implements Validator {


    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "error.name");
        ValidationUtils.rejectIfEmpty(errors, "login", "error.login");
        ValidationUtils.rejectIfEmpty(errors, "password", "error.password");
    }
}
