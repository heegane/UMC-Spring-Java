package umc.umcspring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.umcspring.apiPayload.code.status.ErrorStatus;
import umc.umcspring.service.StoreService.StoreCommandService;
import umc.umcspring.validation.annotation.ExistStores;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class StoresExistValidator implements ConstraintValidator<ExistStores, Integer> {

    private final StoreCommandService storeCommandService;

    @Override
    public void initialize(ExistStores constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer storeId, ConstraintValidatorContext context) {

        boolean isValid = storeCommandService.isStoreExists(storeId);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
