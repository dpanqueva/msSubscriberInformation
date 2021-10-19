package com.telefonica.mssubscriberinformation.model.dto.ws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContractItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<PropertyHWItemItem> propertyHWItem;
    private String unitsDuration;
    private String durationValueUnits;
}