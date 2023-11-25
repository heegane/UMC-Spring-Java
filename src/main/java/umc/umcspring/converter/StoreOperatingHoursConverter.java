package umc.umcspring.converter;

import umc.umcspring.domain.Store;
import umc.umcspring.domain.StoreOperatingHours;
import umc.umcspring.domain.enums.Week;
import umc.umcspring.web.dto.StoreRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StoreOperatingHoursConverter {

    public static List<StoreOperatingHours> toStoreOperatingHoursList(Store store, StoreRequestDTO.AddDto request) {

        return request.getOperatingHours().stream()
                .map(dto -> {
                    Week week = null;

                    switch (dto.getDayOfWeek()) {
                        case 1:
                            week = Week.SUN;
                            break;
                        case 2:
                            week = Week.MON;
                            break;
                        case 3:
                            week = Week.TUE;
                            break;
                        case 4:
                            week = Week.WED;
                            break;
                        case 5:
                            week = Week.THU;
                            break;
                        case 6:
                            week = Week.FRI;
                            break;
                        case 7:
                            week = Week.SAT;
                            break;
                    }

                    return StoreOperatingHours.builder()
                            .store(store)
                            .week(week)
                            .openingTime(dto.getOpenHour()+":"+ dto.getOpenMin())
                            .closingTime(dto.getCloseHour()+":"+dto.getCloseMin())
                            .build();
                }).collect(Collectors.toList());
    }
}
