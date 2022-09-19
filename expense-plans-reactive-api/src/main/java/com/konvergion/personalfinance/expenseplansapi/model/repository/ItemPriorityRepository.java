package com.konvergion.personalfinance.expenseplansapi.model.repository;

import com.konvergion.personalfinance.expenseplansapi.model.entities.ItemPriorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPriorityRepository extends JpaRepository<ItemPriorityEntity, Integer> {

    ItemPriorityEntity findItemPriorityEntityByPriorityValueIsLike(String priorityValueText);
}
