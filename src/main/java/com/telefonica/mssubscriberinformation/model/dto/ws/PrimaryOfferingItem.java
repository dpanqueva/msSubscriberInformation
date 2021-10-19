package com.telefonica.mssubscriberinformation.model.dto.ws;

import java.io.Serializable;
import java.util.List;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PrimaryOfferingItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idProductOffering;
	private ContractItem contractItem;
	private String nameProductOffering;
	private List<PropertyHWItemItem> propertyHWItem;
}