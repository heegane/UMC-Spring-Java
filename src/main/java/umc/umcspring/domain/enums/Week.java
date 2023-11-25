package umc.umcspring.domain.enums;

public enum Week {
    SUN("일"),
    MON("월"),
    TUE("화"),
    WED("수"),
    THU("목"),
    FRI("금"),
    SAT("토");

    private final String krName;

    Week(String krName) {
        this.krName = krName;
    }

    public String getKrName() {
        return krName;
    }
}
