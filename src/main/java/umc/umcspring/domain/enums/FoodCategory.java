package umc.umcspring.domain.enums;

public enum FoodCategory {
    KOREAN("한식"),
    JAPANESE("일식"),
    CHINESE("중식"),
    WESTERN("양식"),
    CHICKEN("치킨"),
    SNACKS("분식"),
    GRILLED_MEAT("고기/구이"),
    LUNCH_BOX("도시락"),
    NIGHT_SNACK("야식"),
    FAST_FOOD("패스트푸드"),
    DESSERT("디저트"),
    ASIAN_FOOD("아시안푸드");

    private final String krName;

    FoodCategory(String krName) {
        this.krName = krName;
    }

    public String getKrName() {
        return krName;
    }

}
