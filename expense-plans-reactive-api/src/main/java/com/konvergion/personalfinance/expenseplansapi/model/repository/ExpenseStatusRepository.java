package com.konvergion.personalfinance.expenseplansapi.model.repository;

import com.konvergion.personalfinance.expenseplansapi.model.entities.ExpenseStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseStatusRepository extends JpaRepository<ExpenseStatusEntity, Integer> {

    ExpenseStatusEntity findExpenseStatusEntityByStatusValueLike(String statusValueText);
}
