package com.rapidcargo.ftrbackendworkitemms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rapidcargo.ftrbackendworkitemms.dto.HarborDTO;

@Entity
@Table(name = "ftr_harbor")
public class Harbor {
    @Id
    private String country;
    private String availableHarborLocations;

    public String getCountry() { return this.country; }
    public void setCountry(String country) { this.country = country; }

    public String getAvailableHarborLocations() { return this.availableHarborLocations; }
    public void setAvailableHarborLocations(String availableHarborLocations) { this.availableHarborLocations = availableHarborLocations; }

    public static Harbor toEntity(HarborDTO harborDTO) {
        Harbor harbor = new Harbor();
        harbor.setAvailableHarborLocations(harborDTO.getAvailableHarborLocations());
        harbor.setCountry(harborDTO.getCountry());
        return harbor;
    }
}
