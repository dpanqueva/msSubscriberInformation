package com.telefonica.mssubscriberinformation.model.dto.ws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContractItem {
    private List<PropertyHWItemItem> propertyHWItem;
    private String unitsDuration;
    private String durationValueUnits;
}