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
public class SupplementaryOfferingItemItem {
    private String idProductOffering;
    private String nameProductOffering;
    private List<PropertyHWItemItem> propertyHWItem;
    private EffectiveModeItem effectiveModeItem;
}