package com.telefonica.mssubscriberinformation.model.dto.ws;

import java.util.List;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PrimaryOfferingItem{
	private String idProductOffering;
	private ContractItem contractItem;
	private String nameProductOffering;
	private List<PropertyHWItemItem> propertyHWItem;
}