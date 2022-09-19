package com.konvergion.personalfinance.expenseplansapi.service;



import com.konvergion.personalfinance.expenseplansapi.model.dto.ExpensePlanItemDTO;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IExpensePlanService {
	
	List<ExpensePlanItemDTO> getAllExpensePlanItems();
	
	ExpensePlanItemDTO getSingleExpensePlanItem(String planItemId);
}
