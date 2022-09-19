package com.konvergion.personalfinance.expenseplansapi.web;

import com.konvergion.personalfinance.expenseplansapi.model.dto.ExpensePlanItemDTO;
import com.konvergion.personalfinance.expenseplansapi.service.IExpensePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v2/")
public class ExpensePlanController {

    @Autowired
    private IExpensePlanService expensePlanService;

    @GetMapping("/expense-plan-items/{expensePlanItemId}")
    public Mono<ExpensePlanItemDTO> getExpensePlanItem(
            @PathVariable("expensePlanItemId") String expensePlanItemId){
        return Mono.just(expensePlanService.getSingleExpensePlanItem(expensePlanItemId));
    }

    @GetMapping("/expense-plan-items")
    public Flux<ExpensePlanItemDTO> getAllExpensePlanItems() {
        return Flux.fromIterable(expensePlanService.getAllExpensePlanItems());
    }
}
