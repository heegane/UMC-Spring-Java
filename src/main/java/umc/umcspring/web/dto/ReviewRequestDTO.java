package umc.umcspring.web.dto;

import lombok.AccessLevel;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class ReviewRequestDTO {

    @Getter(AccessLevel.PUBLIC)
    public static class AddDto{

        @NotNull(message = "점수를 입력해주세요!")
        Integer score;

        @Size(min = 1, max = 500, message = "리뷰 내용은 1 ~ 500자 이어야 합니다!")
        @NotEmpty
        String content;

        List<String> imgUrl;
    }
}
