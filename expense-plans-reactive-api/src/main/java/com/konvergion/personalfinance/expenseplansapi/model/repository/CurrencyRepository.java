package com.konvergion.personalfinance.expenseplansapi.model.repository;

import com.konvergion.personalfinance.expenseplansapi.model.entities.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, String> {

    CurrencyEntity findByCurrencyCode(String currencyCode);
}
