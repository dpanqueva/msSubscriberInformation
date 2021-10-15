package com.telefonica.mssubscriberinformation.util;

import com.telefonica.mssubscriberinformation.model.dto.SubscriberProductItemsDTO;
import com.telefonica.mssubscriberinformation.model.dto.SubscriberWrapperDTO;
import com.telefonica.mssubscriberinformation.model.dto.ws.Response;
import com.telefonica.mssubscriberinformation.model.dto.ws.RspBodyGSD1Item;
import com.telefonica.mssubscriberinformation.model.dto.ws.SubscriberProductItemDescDTO;
import com.telefonica.mssubscriberinformation.model.dto.ws.SuscriberGDLItemItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dpanquev
 * @version 2021-10-14
 * */
@Component
public class ExtDataCliToObjUtil {

    /**
     * Method for evaluate info from client fsGetSubscriberList for extract
     * info that we need in subscriberInformation about HU DPH
     *
     * @param responseCl
     * @return
     */
    public SubscriberWrapperDTO evaluateInfo(Response responseCl) {
        SubscriberWrapperDTO subscriberWrapperDTO = new SubscriberWrapperDTO();

        SubscriberProductItemsDTO subscriberProductItemsDTO = new SubscriberProductItemsDTO();
        List<SubscriberProductItemDescDTO> lstSubscriberProductItemDesc = new ArrayList<>();

        RspBodyGSD1Item rspBodyGSD1Item = responseCl.getRspBodyGSD1Item();
        List<SuscriberGDLItemItem> suscriberGDLItem = rspBodyGSD1Item.getSuscriberGDLItem();

        /**
         * iterator for obtain information about primary products
         * */
        suscriberGDLItem.forEach(s -> {
            SubscriberProductItemDescDTO subscriberProductItemDescDTO =
                    new SubscriberProductItemDescDTO(
                            matchValue(s.getSubscriberInformationItem().getNetworkResourceIdCH())
                            , s.getPrimaryOfferingItem().getIdProductOffering()
                            , s.getPrimaryOfferingItem().getNameProductOffering());
            lstSubscriberProductItemDesc.add(subscriberProductItemDescDTO);
        });
        subscriberProductItemsDTO.setSubscriberProductItemDesc(lstSubscriberProductItemDesc);

        return subscriberWrapperDTO;
    }

    /**
     * Method for to take match about description networkresourceIdch
     *
     * @param netWorkResourceIdCH
     * @return
     */
    private String matchValue(String netWorkResourceIdCH) {
        switch (netWorkResourceIdCH) {
            case "1":
                return "GSM";
            case "2":
                return "CDMA";
            case "3":
                return "ADSL";
            case "4":
                return "PSTN";
            case "5":
                return "WiMax";
            case "6":
                return "VOIP";
            case "7":
                return "OTTO VOIP";
            case "8":
                return "IPTV";
            case "9":
                return "Cable TV";
            case "E":
                return "WiFi";
            default:
                return "Not assign";
        }
    }

}
