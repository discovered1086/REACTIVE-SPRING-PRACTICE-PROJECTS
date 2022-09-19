package com.konvergion.personalfinance.expenseplansapi.model.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.konvergion.personalfinance.expenseplansapi.model.dto.serialization.DateDeSerializer;
import com.konvergion.personalfinance.expenseplansapi.model.dto.serialization.DateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor // Required for JPA
@AllArgsConstructor
public class ExpensePlanItemDTO {

    private String itemId;

    @NotNull(message = "The item description can't be empty")
    private String itemDescription;

    private String itemLinkUrl;

    @Max(value = 5, message = "The itemPriority can't be greater than 5")
    @Min(value = 1, message = "The itemPriority can't be less than 1")
    private int itemPriority;

    @NotNull(message = "Item category can't be blank")
    private String itemCategory;

    @JsonDeserialize(using = DateDeSerializer.class)
    @JsonSerialize(using = DateSerializer.class)
    private LocalDate targetExpenseDate;

    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeSerializer.class)
    private LocalDate actualPurchaseDate;

    private BigDecimal estimatedAmount;

    private BigDecimal actualAmount;

    private String currencyCode;

    private int expenseStatus;

    private String createdBy;
}
