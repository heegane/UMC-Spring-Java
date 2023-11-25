package umc.umcspring.web.dto;

import lombok.Getter;


@Getter
public class OperatingHourDTO {
    private Integer dayOfWeek;
    private String openHour;
    private String openMin;
    private String closeHour;
    private String closeMin;
}
