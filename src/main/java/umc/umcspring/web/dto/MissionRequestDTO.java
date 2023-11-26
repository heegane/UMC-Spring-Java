package umc.umcspring.web.dto;

import lombok.Getter;


public class MissionRequestDTO {

    @Getter
    public static class AddDto{
        Integer point;
        String content;
        Integer deadYear;
        Integer deadMonth;
        Integer deadDay;
    }
}
