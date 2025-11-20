package com.infosys.ftrbackendterminalms.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.infosys.ftrbackendterminalms.entity.Terminal;

public class TerminalDTO {

    private String terminalId;

    @NotEmpty(message = "{terminal.terminalName.must}")
    @Size(min = 3, max = 20, message = "{terminal.terminalName.invalid}")
    private String terminalName;

    @NotEmpty(message = "{terminal.country.must}")
    @Size(min = 3, max = 20, message = "{terminal.country.invalid}")
    private String country;

    @NotEmpty(message = "{terminal.itemType.must}")
    @Size(min = 3, max = 30, message = "{terminal.itemType.invalid}")
    private String itemType;

    @NotEmpty(message = "{terminal.terminalDescription.must}")
    private String terminalDescription;

    @NotNull(message = "{terminal.capacity.must}")
    @Max(value = 99999, message = "{terminal.capacity.invalid}")
    private Integer capacity;

    @NotNull(message = "{terminal.capacity-must}")
    @Max(value = 99999, message = "{terminal.capacity.invalid}")
    private Integer availableCapacity;

    @NotEmpty(message = "{terminal.status.must}")
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

    public static TerminalDTO toDto(Terminal terminal) {
        TerminalDTO dto = new TerminalDTO();
        dto.setTerminalId(terminal.getTerminalId());
        dto.setTerminalName(terminal.getTerminalName());
        dto.setCountry(terminal.getCountry());
        dto.setItemType(terminal.getItemType());
        dto.setTerminalDescription(terminal.getTerminalDescription());
        dto.setCapacity(terminal.getCapacity());
        dto.setAvailableCapacity(terminal.getAvailableCapacity());
        dto.setStatus(terminal.getStatus());
        dto.setHarborLocation(terminal.getHarborLocation());
        return dto;
    }
}
