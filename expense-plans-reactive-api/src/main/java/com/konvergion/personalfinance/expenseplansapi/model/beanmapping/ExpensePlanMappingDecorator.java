package com.konvergion.personalfinance.expenseplansapi.model.beanmapping;

import com.konvergion.personalfinance.expenseplansapi.model.dto.ExpensePlanItemDTO;
import com.konvergion.personalfinance.expenseplansapi.model.entities.ExpensePlanItemEntity;
import com.konvergion.personalfinance.expenseplansapi.model.repository.CurrencyRepository;
import com.konvergion.personalfinance.expenseplansapi.model.repository.ExpenseStatusRepository;
import com.konvergion.personalfinance.expenseplansapi.model.repository.ItemPriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class ExpensePlanMappingDecorator implements ExpensePlanBeanMapper {

    @Autowired
    @Qualifier("delegate")
    private ExpensePlanBeanMapper beanMapper;

    @Autowired
    private ExpenseStatusRepository expenseStatusRepository;

    @Autowired
    private ItemPriorityRepository itemPriorityRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public ExpensePlanItemEntity convertDtoToEntity(ExpensePlanItemDTO expensePlanItemDTO) {
        ExpensePlanItemEntity expensePlanItemEntity = beanMapper.convertDtoToEntity(expensePlanItemDTO);
        expensePlanItemEntity.setTargetExpenseTimeFrame(expensePlanItemDTO.getTargetExpenseDate()
                .format(DateTimeFormatter.ofPattern("MMMM yyyy")));
        expensePlanItemEntity.setExpenseStatus(
                expenseStatusRepository.findById(expensePlanItemDTO.getExpenseStatus()).orElseGet(() ->
                        expenseStatusRepository.findExpenseStatusEntityByStatusValueLike("NOT P")));
        expensePlanItemEntity.setItemPriority(itemPriorityRepository.findById(expensePlanItemDTO.getItemPriority())
                .orElseGet(() -> itemPriorityRepository.findItemPriorityEntityByPriorityValueIsLike("VERY L")));
        expensePlanItemEntity.setCurrencyEntity(currencyRepository.findByCurrencyCode(expensePlanItemDTO.getCurrencyCode()));
        return expensePlanItemEntity;
    }

    @Override
    public ExpensePlanItemDTO convertEntityToDto(ExpensePlanItemEntity expensePlanItemEntity) {
        ExpensePlanItemDTO planItemDTO = beanMapper.convertEntityToDto(expensePlanItemEntity);
        planItemDTO.setCurrencyCode(expensePlanItemEntity.getCurrencyEntity().getCurrencyCode());
        planItemDTO.setItemPriority(expensePlanItemEntity.getItemPriority().getPriorityId());
        return planItemDTO;
    }
}
