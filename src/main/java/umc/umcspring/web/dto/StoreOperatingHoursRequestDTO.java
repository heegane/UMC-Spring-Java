package umc.umcspring.web.dto;

import java.util.List;

public class StoreOperatingHoursRequestDTO {
    private List<OperatingHourDTO> operatingHours;

    public List<OperatingHourDTO> getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(List<OperatingHourDTO> operatingHours) {
        this.operatingHours = operatingHours;
    }
}
