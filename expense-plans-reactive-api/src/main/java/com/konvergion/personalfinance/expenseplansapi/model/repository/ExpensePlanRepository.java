package com.konvergion.personalfinance.expenseplansapi.model.repository;


import com.konvergion.personalfinance.expenseplansapi.model.dto.ExpensePlanItemDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ExpensePlanRepository extends ReactiveMongoRepository<ExpensePlanItemDocument, String> {

}
