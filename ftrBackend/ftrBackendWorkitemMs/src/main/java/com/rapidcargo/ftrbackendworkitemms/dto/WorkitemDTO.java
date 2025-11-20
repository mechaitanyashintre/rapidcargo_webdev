// WorkitemDTO.java
package com.infosys.ftrbackendworkitemms.dto;

import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infosys.ftrbackendworkitemms.entity.Workitem;

public class WorkitemDTO {

    @NotNull(message = "userId must not be null")
    @Max(value = 999999, message = "userId invalid")
    @Min(value = 100000, message = "userId invalid")
    private Long userId;

    @Size(max = 5, message = "workitemId invalid")
    private String workitemId;

    @NotEmpty(message = "itemName must not be empty")
    @Size(max = 5, message = "itemName invalid")
    private String itemName;

    @NotEmpty(message = "itemType must not be empty")
    @Size(min = 3, max = 25, message = "itemType invalid")
    private String itemType;

    @NotEmpty(message = "itemDescription must not be empty")
    @Size(min = 10, max = 45, message = "itemDescription invalid")
    private String itemDescription;

    @NotEmpty(message = "messageToRecipient must not be empty")
    @Size(min = 10, max = 50, message = "messageToRecipient invalid")
    private String messageToRecipient;

    @NotEmpty(message = "quantity must not be empty")
    private String quantity;

    @NotEmpty(message = "sourceCountry must not be empty")
    @Size(min = 5, max = 25, message = "sourceCountry invalid")
    private String sourceCountry;

    @NotEmpty(message = "destinationCountry must not be empty")
    @Size(min = 5, max = 25, message = "destinationCountry invalid")
    private String destinationCountry;

    @NotEmpty(message = "originHarborLocation must not be empty")
    @Size(min = 5, max = 25, message = "originHarborLocation invalid")
    private String originHarborLocation;

    @NotEmpty(message = "selectedHarborLocation must not be empty")
    @Size(min = 5, max = 25, message = "selectedHarborLocation invalid")
    private String selectedHarborLocation;

    @NotNull(message = "shippingDate must not be null")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date shippingDate;

    private Integer amount;

    public String getWorkitemId() { return workitemId; }
    public void setWorkitemId(String workitemId) { this.workitemId = workitemId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getItemType() { return itemType; }
    public void setItemType(String itemType) { this.itemType = itemType; }

    public String getItemDescription() { return itemDescription; }
    public void setItemDescription(String itemDescription) { this.itemDescription = itemDescription; }

    public String getMessageToRecipient() { return messageToRecipient; }
    public void setMessageToRecipient(String messageToRecipient) { this.messageToRecipient = messageToRecipient; }

    public String getQuantity() { return quantity; }
    public void setQuantity(String quantity) { this.quantity = quantity; }

    public String getSourceCountry() { return sourceCountry; }
    public void setSourceCountry(String sourceCountry) { this.sourceCountry = sourceCountry; }

    public String getDestinationCountry() { return destinationCountry; }
    public void setDestinationCountry(String destinationCountry) { this.destinationCountry = destinationCountry; }

    public String getOriginHarborLocation() { return originHarborLocation; }
    public void setOriginHarborLocation(String originHarborLocation) { this.originHarborLocation = originHarborLocation; }

    public String getSelectedHarborLocation() { return selectedHarborLocation; }
    public void setSelectedHarborLocation(String selectedHarborLocation) { this.selectedHarborLocation = selectedHarborLocation; }

    public Date getShippingDate() { return shippingDate; }
    public void setShippingDate(Date shippingDate) { this.shippingDate = shippingDate; }

    public Integer getAmount() { return amount; }
    public void setAmount(Integer amount) { this.amount = amount; }

    public static WorkitemDTO toDto(Workitem workitem) {
        WorkitemDTO dto = new WorkitemDTO();
        dto.setAmount(workitem.getAmount());
        dto.setDestinationCountry(workitem.getDestinationCountry());
        dto.setItemDescription(workitem.getItemDescription());
        dto.setWorkitemId(workitem.getWorkitemId());
        dto.setItemName(workitem.getItemName());
        dto.setItemType(workitem.getItemType());
        dto.setMessageToRecipient(workitem.getMessageToRecipient());
        dto.setOriginHarborLocation(workitem.getOriginHarborLocation());
        dto.setQuantity(workitem.getQuantity());
        dto.setSelectedHarborLocation(workitem.getSelectedHarborLocation());
        dto.setShippingDate(workitem.getShippingDate());
        dto.setSourceCountry(workitem.getSourceCountry());
        dto.setUserId(workitem.getUserId());
        return dto;
    }
}
