package com.bs.boot.webstore.validators;

import com.bs.boot.webstore.domain.User;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Blazej on 01.11.2018.
 */
@Component
public class PasswordValidator implements ConstraintValidator<IMatchingPassword, User> {
    @Override
    public void initialize(IMatchingPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
