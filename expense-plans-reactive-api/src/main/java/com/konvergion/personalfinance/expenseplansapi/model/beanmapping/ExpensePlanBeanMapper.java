package com.konvergion.personalfinance.expenseplansapi.model.beanmapping;


import com.konvergion.personalfinance.expenseplansapi.model.dto.ExpensePlanItemDTO;
import com.konvergion.personalfinance.expenseplansapi.model.entities.ExpensePlanItemEntity;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
@DecoratedWith(ExpensePlanMappingDecorator.class)
public interface ExpensePlanBeanMapper {

    @Mapping(target="targetExpenseTimeFrame", ignore = true)
    @Mapping(target="itemPriority", ignore = true)
    @Mapping(target="expenseStatus", ignore = true)
    @Mapping(target="currencyEntity", ignore = true)
    ExpensePlanItemEntity convertDtoToEntity(ExpensePlanItemDTO expensePlanItemDTO);

    @Mapping(target="targetExpenseDate", ignore = true)
    @Mapping(target="itemPriority", ignore = true)
    @Mapping(target="expenseStatus", ignore = true)
    @Mapping(target="currencyCode", ignore = true)
    ExpensePlanItemDTO convertEntityToDto(ExpensePlanItemEntity expensePlanItemEntity);
}
