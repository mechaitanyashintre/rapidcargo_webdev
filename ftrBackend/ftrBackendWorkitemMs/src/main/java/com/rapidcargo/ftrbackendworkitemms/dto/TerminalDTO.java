// TerminalDTO.java
package com.infosys.ftrbackendworkitemms.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TerminalDTO {
    private String terminalId;

    @NotEmpty(message = "terminalName must not be empty")
    @Size(min = 3, max = 20, message = "terminalName invalid")
    private String terminalName;

    @NotEmpty(message = "country must not be empty")
    @Size(min = 3, max = 20, message = "country invalid")
    private String country;

    @NotEmpty(message = "itemType must not be empty")
    @Size(min = 3, max = 30, message = "itemType invalid")
    private String itemType;

    @NotEmpty(message = "terminalDescription must not be empty")
    private String terminalDescription;

    @NotNull(message = "capacity must not be null")
    @Max(value = 99999, message = "capacity invalid")
    private Integer capacity;

    @NotNull(message = "availableCapacity must not be null")
    @Max(value = 99999, message = "availableCapacity invalid")
    private Integer availableCapacity;

    @NotEmpty(message = "status must not be empty")
    private String status;

    private String harborLocation;

    public String getTerminalId() { return terminalId; }
    public void setTerminalId(String terminalId) { this.terminalId = terminalId; }

    public String getTerminalName() { return terminalName; }
    public void setTerminalName(String terminalName) { this.terminalName = terminalName; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getItemType() { return itemType; }
    public void setItemType(String itemType) { this.itemType = itemType; }

    public String getTerminalDescription() { return terminalDescription; }
    public void setTerminalDescription(String terminalDescription) { this.terminalDescription = terminalDescription; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public Integer getAvailableCapacity() { return availableCapacity; }
    public void setAvailableCapacity(Integer availableCapacity) { this.availableCapacity = availableCapacity; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getHarborLocation() { return harborLocation; }
    public void setHarborLocation(String harborLocation) { this.harborLocation = harborLocation; }
}
