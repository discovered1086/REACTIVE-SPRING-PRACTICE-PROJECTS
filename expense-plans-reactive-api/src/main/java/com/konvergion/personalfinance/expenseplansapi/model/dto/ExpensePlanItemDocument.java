package com.konvergion.personalfinance.expenseplansapi.model.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.konvergion.personalfinance.expenseplansapi.model.dto.serialization.DateDeSerializer;
import com.konvergion.personalfinance.expenseplansapi.model.dto.serialization.DateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor // Required for JPA
@AllArgsConstructor
@Document(collection = "expenseplans")
public class ExpensePlanItemDocument {

    @Id
    private String id;

    private String itemId;

    private String itemDescription;

    private String itemLinkUrl;

    private int itemPriority;

    private String itemCategory;

    private BigDecimal estimatedAmount;

    private BigDecimal actualAmount;

    private String currencyCode;

    private int expenseStatus;
}
