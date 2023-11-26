package umc.umcspring.web.dto;

import lombok.Getter;

import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class AddDto{
        Integer score;
        String content;
        List<String> imgUrl;
    }
}
