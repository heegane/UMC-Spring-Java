package umc.umcspring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.umcspring.apiPayload.code.status.ErrorStatus;
import umc.umcspring.service.StoreService.StoreCommandService;
import umc.umcspring.validation.annotation.ExistStoreTypes;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class StoreTypesExistValidator implements ConstraintValidator<ExistStoreTypes,Integer> {

    private final StoreCommandService storeCommandService;

    @Override
    public void initialize(ExistStoreTypes constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer storeTypeId, ConstraintValidatorContext context) {

        boolean isValid = storeCommandService.isStoreTypeExists(storeTypeId);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_TYPE_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
