package com.konvergion.personalfinance.expenseplansapi.model.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.konvergion.personalfinance.expenseplansapi.model.dto.serialization.DateDeSerializer;
import com.konvergion.personalfinance.expenseplansapi.model.dto.serialization.DateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor // Required for JPA
@AllArgsConstructor
public class ExpensePlanItemDTO {

    private String itemId;

    private String itemDescription;

    private String itemLinkUrl;

    private int itemPriority;


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
