package com.konvergion.personalfinance.expenseplansapi.service;


import com.konvergion.personalfinance.expenseplansapi.model.dto.ExpensePlanItemDocument;
import com.konvergion.personalfinance.expenseplansapi.model.repository.ExpensePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class IExpensePlanServiceImpl implements IExpensePlanService {

    private final ExpensePlanRepository expensePlanRepository;

    @Autowired
    public IExpensePlanServiceImpl(ExpensePlanRepository expensePlanRepository) {
        this.expensePlanRepository = expensePlanRepository;
    }

    @Override
    public Flux<ExpensePlanItemDocument> getAllExpensePlanItems() {
       return expensePlanRepository.findAll();
    }

    @Override
    public Mono<ExpensePlanItemDocument> getSingleExpensePlanItem(String planItemId) {
        return expensePlanRepository.findById(planItemId);
    }

    @Override
    public Mono<ExpensePlanItemDocument> addExpensePlan(ExpensePlanItemDocument document) {
        return expensePlanRepository.save(document);
    }
}
