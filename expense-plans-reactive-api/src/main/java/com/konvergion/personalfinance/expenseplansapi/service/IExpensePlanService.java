package com.konvergion.personalfinance.expenseplansapi.service;



import com.konvergion.personalfinance.expenseplansapi.model.dto.ExpensePlanItemDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IExpensePlanService {
	
	Flux<ExpensePlanItemDocument> getAllExpensePlanItems();
	
	Mono<ExpensePlanItemDocument> getSingleExpensePlanItem(String planItemId);
}
