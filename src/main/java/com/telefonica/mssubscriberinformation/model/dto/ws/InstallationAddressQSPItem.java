package com.telefonica.mssubscriberinformation.model.dto.ws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InstallationAddressQSPItem {
    private String addressFlag;
    private String formattedRespSplitAddress;
    private String addressComplement;
    private String streetViaSuffix;
    private String townIdGeographicAddress;
    private String stateOrProvinceGeographicAddress;
    private String suburbNameGeographicAddress;
    private String postalCodeAddress;
    private String localityUrbanPropertyAddress;
    private String formattedRespAddressSubsidy;
    private String formattedRespAddress;
    private String addressTypeAddress;
    private String socialLevel;
    private String formattedSubAddress;
    private String suburbRespCodeGeographicAddress;
    private String blockGeographicAddress;
    private String formattedRespGeoAddress;
}