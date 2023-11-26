package umc.umcspring.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class MissionRequestDTO {

    @Getter
    public static class AddDto{

        @NotNull(message = "미션 포인트를 입력해주세요!")
        Integer point;

        @Size(min = 1, max = 500, message = "미션 내용은 1 ~ 500자 이어야 합니다!")
        @NotEmpty
        String content;

        @NotNull(message = "미션 마감일의 년도를 입력해주세요!(YYYY)")
        Integer deadYear;

        @NotNull(message = "미션 마감일의 해당 월을 입력해주세요!(MM)")
        Integer deadMonth;

        @NotNull(message = "미션 마감일의 해당 일을 입력해주세요!(DD)")
        Integer deadDay;
    }
}
