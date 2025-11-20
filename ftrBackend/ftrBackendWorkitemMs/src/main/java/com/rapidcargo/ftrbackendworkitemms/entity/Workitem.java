package com.rapidcargo.ftrbackendworkitemms.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rapidcargo.ftrbackendworkitemms.dto.WorkitemDTO;

@Entity
@Table(name = "ftr_workitems")
public class Workitem {
    @Id
    private String workitemId;
    private Long userId;
    private String itemName;
    private String itemType;
    private String itemDescription;
    private String messageToRecipient;
    private String quantity;
    private String sourceCountry;
    private String destinationCountry;
    private String originHarborLocation;
    private String selectedHarborLocation;
    private Date shippingDate;
    private Integer amount;

    public String getWorkitemId() { return this.workitemId; }
    public void setWorkitemId(String workitemId) { this.workitemId = workitemId; }

    public Long getUserId() { return this.userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getItemName() { return this.itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getItemType() { return this.itemType; }
    public void setItemType(String itemType) { this.itemType = itemType; }

    public String getItemDescription() { return this.itemDescription; }
    public void setItemDescription(String itemDescription) { this.itemDescription = itemDescription; }

    public String getMessageToRecipient() { return this.messageToRecipient; }
    public void setMessageToRecipient(String messageToRecipient) { this.messageToRecipient = messageToRecipient; }

    public String getQuantity() { return this.quantity; }
    public void setQuantity(String quantity) { this.quantity = quantity; }

    public String getSourceCountry() { return this.sourceCountry; }
    public void setSourceCountry(String sourceCountry) { this.sourceCountry = sourceCountry; }

    public String getDestinationCountry() { return this.destinationCountry; }
    public void setDestinationCountry(String destinationCountry) { this.destinationCountry = destinationCountry; }

    public String getOriginHarborLocation() { return this.originHarborLocation; }
    public void setOriginHarborLocation(String originHarborLocation) { this.originHarborLocation = originHarborLocation; }

    public String getSelectedHarborLocation() { return this.selectedHarborLocation; }
    public void setSelectedHarborLocation(String selectedHarborLocation) { this.selectedHarborLocation = selectedHarborLocation; }

    public Date getShippingDate() { return this.shippingDate; }
    public void setShippingDate(Date shippingDate) { this.shippingDate = shippingDate; }

    public Integer getAmount() { return this.amount; }
    public void setAmount(Integer amount) { this.amount = amount; }

    public static Workitem toEntity(WorkitemDTO dto) {
        Workitem entity = new Workitem();
        entity.setAmount(dto.getAmount());
        entity.setDestinationCountry(dto.getDestinationCountry());
        entity.setItemDescription(dto.getItemDescription());
        entity.setWorkitemId(dto.getWorkitemId());
        entity.setItemName(dto.getItemName());
        entity.setItemType(dto.getItemType());
        entity.setMessageToRecipient(dto.getMessageToRecipient());
        entity.setOriginHarborLocation(dto.getOriginHarborLocation());
        entity.setQuantity(dto.getQuantity());
        entity.setSelectedHarborLocation(dto.getSelectedHarborLocation());
        entity.setShippingDate(dto.getShippingDate());
        entity.setSourceCountry(dto.getSourceCountry());
        entity.setUserId(dto.getUserId());
        return entity;
    }
}
