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
public class SubscriberInformationItem {

    private String primaryTelephoneNumber;
    private String iDCustomer;
    private String partyRoleIdCustomer;
    private String customerStatusTime;
    private String customerSubSsegment;
    private String startDateTimeTimePeriod;
    private String cityGeographicAddress;
    private String interactionStatusResponse;
    private String iccdValue;
    private String descriptionPaymentMethod;
    private String networkResourceIdCH;
    private String ctiAccessCodeInfo;
    private String interactionStatusBusinessInteraction;
    private String ctiAccessCodeFlagInfo;
    private String alphabetNameLanguage;
    private String customerSegment;
    private String iDProductSpecCharacteristic;
    private List<PropertyHWItemItem> propertyHWItem;
    private String secondReqFlag;
    private String secondReqAuxFlag;
    private InstallationAddressQSPItem installationAddressQSPItem;

}