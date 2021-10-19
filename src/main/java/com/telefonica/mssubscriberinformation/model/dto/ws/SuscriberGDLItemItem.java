package com.telefonica.mssubscriberinformation.model.dto.ws;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SuscriberGDLItemItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("primaryOfferingItem")
    private PrimaryOfferingItem primaryOfferingItem;
    @JsonProperty("userCustomerGSDItem")
    private UserCustomerGSDItem userCustomerGSDItem;
    @JsonProperty("supplementaryOfferingItem")
    private List<SupplementaryOfferingItemItem> supplementaryOfferingItem;
    @JsonProperty("subscriberInformationItem")
    private SubscriberInformationItem subscriberInformationItem;
}