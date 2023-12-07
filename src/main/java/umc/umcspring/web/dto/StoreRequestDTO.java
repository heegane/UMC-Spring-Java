package umc.umcspring.web.dto;

import lombok.AccessLevel;
import lombok.Getter;
import umc.umcspring.validation.annotation.ExistStoreTypes;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


public class StoreRequestDTO {

    @Getter(AccessLevel.PUBLIC)
    public static class AddDto{

        @NotBlank(message = "가게 이름을 입력해주세요!")
        String name;

        @Size(min = 5, max = 50)
        @NotEmpty(message = "가게의 도로명 주소를 입력해주세요!")
        String roadAddress;

        @Size(max = 12)
        String detailAddress;

        @ExistStoreTypes
        @NotNull(message = "가게 유형을 입력해주세요!")
        Integer storeType;

        @NotEmpty(message = "가게의 운영시간을 입력해주세요!")
        List<OperatingHourDTO> operatingHours;
    }


}
