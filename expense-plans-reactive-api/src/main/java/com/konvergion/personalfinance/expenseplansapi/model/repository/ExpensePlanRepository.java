package com.konvergion.personalfinance.expenseplansapi.model.repository;



import com.konvergion.personalfinance.expenseplansapi.model.entities.ExpensePlanItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensePlanRepository extends JpaRepository<ExpensePlanItemEntity, String> {

}
