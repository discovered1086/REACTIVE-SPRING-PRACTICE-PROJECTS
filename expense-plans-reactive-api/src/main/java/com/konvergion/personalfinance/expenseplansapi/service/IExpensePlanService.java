package com.konvergion.personalfinance.expenseplansapi.service;



import com.konvergion.personalfinance.expenseplansapi.model.dto.ExpensePlanItemDTO;

import java.util.List;

public interface IExpensePlanService {

	ExpensePlanItemDTO addExpensePlan(ExpensePlanItemDTO expensePlanItemDTO);
	
	void deleteExpensePlanItem(String itemId);
	
	List<ExpensePlanItemDTO> getAllExpensePlanItems();
	
	ExpensePlanItemDTO getSingleExpensePlanItem(String planItemId);
}
