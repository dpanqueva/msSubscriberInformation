package com.telefonica.mssubscriberinformation.model.dto.ws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO for describe primary products
 * @author dpanquev
 * @version 2021-10-14
 * */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriberProductItemDescDTO {

    /**
     * tipo de producto
     * **/
    private String netWorkType;

    private String offeringId;

    private String offeringName;
}
