package umc.umcspring.web.dto;

import lombok.Getter;

import java.util.List;

public class StoreRequestDTO {

    @Getter
    public static class AddDto{
        String name;
        String roadAddress;
        String detailAddress;
        Integer storeType;
        List<OperatingHourDTO> operatingHours;
    }
}
