package com.konvergion.personalfinance.expenseplansapi.web;

import com.konvergion.personalfinance.expenseplansapi.model.dto.ExpensePlanItemDocument;
import com.konvergion.personalfinance.expenseplansapi.service.IExpensePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v2/")
public class ExpensePlanController {

    @Autowired
    private IExpensePlanService expensePlanService;

    @GetMapping("/expense-plan-items/{expensePlanItemId}")
    public Mono<ExpensePlanItemDocument> getExpensePlanItem(
            @PathVariable("expensePlanItemId") String expensePlanItemId){
        return expensePlanService.getSingleExpensePlanItem(expensePlanItemId);
    }

    @GetMapping("/expense-plan-items")
    public Flux<ExpensePlanItemDocument> getAllExpensePlanItems() {
        return expensePlanService.getAllExpensePlanItems();
    }
}
