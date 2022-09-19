package com.konvergion.personalfinance.expenseplansapi.web;

import com.konvergion.personalfinance.expenseplansapi.model.dto.ExpensePlanItemDTO;
import com.konvergion.personalfinance.expenseplansapi.service.IExpensePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/")
public class ExpensePlanController {

    @Autowired
    private IExpensePlanService expensePlanService;

    @PostMapping("/expense-plan-item")
    public ResponseEntity<String> addExpensePlan(@RequestBody ExpensePlanItemDTO itemDTO){
        expensePlanService.addExpensePlan(itemDTO);
        return ResponseEntity.ok("An expense plan was added");
    }

    @GetMapping("/expense-plan-item/{expensePlanItemId}")
    public ResponseEntity<ExpensePlanItemDTO> getExpensePlanItem(
            @PathVariable("expensePlanItemId") String expensePlanItemId){
        return ResponseEntity.ok(expensePlanService.getSingleExpensePlanItem(expensePlanItemId));
    }

    @GetMapping("/expense-plan-item")
    public ResponseEntity<List<ExpensePlanItemDTO>> getAllExpensePlanItems(){
        return ResponseEntity.ok(expensePlanService.getAllExpensePlanItems());
    }

    @DeleteMapping("/expense-plan-item/{planItemId}")
    public ResponseEntity<String> removeExpensePlan(@PathVariable String planItemId){
        expensePlanService.deleteExpensePlanItem(planItemId);
        return ResponseEntity.ok(String.format("The expense plan item with id %s has been deleted", planItemId));
    }
}
