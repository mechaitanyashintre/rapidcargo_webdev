package com.rapidcargo.ftrbackendterminalms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rapidcargo.ftrbackendterminalms.dto.TerminalDTO;

@Entity
@Table(name = "ftr_terminals")
public class Terminal {

    @Id
    private String terminalId;

    private String terminalName;
    private String country;
    private String itemType;
    private String terminalDescription;
    private Integer capacity;
    private Integer availableCapacity;
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

    public static Terminal toEntity(TerminalDTO dto) {
        Terminal terminal = new Terminal();
        terminal.setTerminalId(dto.getTerminalId());
        terminal.setTerminalName(dto.getTerminalName());
        terminal.setCountry(dto.getCountry());
        terminal.setItemType(dto.getItemType());
        terminal.setTerminalDescription(dto.getTerminalDescription());
        terminal.setCapacity(dto.getCapacity());
        terminal.setAvailableCapacity(dto.getAvailableCapacity());
        terminal.setStatus(dto.getStatus());
        terminal.setHarborLocation(dto.getHarborLocation());
        return terminal;
    }
}
