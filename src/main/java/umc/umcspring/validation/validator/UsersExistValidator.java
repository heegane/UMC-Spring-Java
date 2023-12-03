package umc.umcspring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.umcspring.apiPayload.code.status.ErrorStatus;
import umc.umcspring.service.UserService.UserCommandService;
import umc.umcspring.validation.annotation.ExistUsers;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class UsersExistValidator implements ConstraintValidator<ExistUsers, Integer>{

    private final UserCommandService userCommandService;

    @Override
    public void initialize(ExistUsers constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer userId, ConstraintValidatorContext context) {

        boolean isValid = userCommandService.isUserExists(userId);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.USER_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
