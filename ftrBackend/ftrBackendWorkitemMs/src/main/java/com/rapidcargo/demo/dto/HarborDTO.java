// HarborDTO.java
package com.infosys.ftrbackendworkitemms.dto;

import com.infosys.ftrbackendworkitemms.entity.Harbor;

public class HarborDTO {
    private String country;
    private String availableHarborLocations;

    public String getCountry() { return this.country; }
    public void setCountry(String country) { this.country = country; }

    public String getAvailableHarborLocations() { return this.availableHarborLocations; }
    public void setAvailableHarborLocations(String availableHarborLocations) { this.availableHarborLocations = availableHarborLocations; }

    public static HarborDTO toDTO(Harbor harbor) {
        HarborDTO dto = new HarborDTO();
        dto.setAvailableHarborLocations(harbor.getAvailableHarborLocations());
        dto.setCountry(harbor.getCountry());
        return dto;
    }
}
