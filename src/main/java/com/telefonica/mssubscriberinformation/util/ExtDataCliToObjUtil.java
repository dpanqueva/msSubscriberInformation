package com.telefonica.mssubscriberinformation.util;

import com.telefonica.mssubscriberinformation.common.exception.InternalErrorException;
import com.telefonica.mssubscriberinformation.common.exception.NotContentException;
import com.telefonica.mssubscriberinformation.model.dto.SubscriberProductItemDescDTO;
import com.telefonica.mssubscriberinformation.model.dto.SubscriberProductItemsDTO;
import com.telefonica.mssubscriberinformation.model.dto.SubscriberWrapperDTO;
import com.telefonica.mssubscriberinformation.model.dto.ws.Response;
import com.telefonica.mssubscriberinformation.model.dto.ws.RspBodyGSD1Item;
import com.telefonica.mssubscriberinformation.model.dto.ws.SuscriberGDLItemItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author dpanquev
 * @version 2021-10-14
 */
@Slf4j
@Component
public class ExtDataCliToObjUtil {


    @Value("${values.for.match.type.plan}")
    private String valueMatch;

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
        subscriberWrapperDTO.setSubscriberProductItem(subscriberProductItemsDTO);
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

    /**
     * Method for extract information about general plan
     *
     * @param spValues
     * @param subscriberWrapperDTO
     * @return
     */
    public SubscriberWrapperDTO extValuesSP(SubscriberWrapperDTO subscriberWrapperDTO, Map<String, Object> spValues) {
        /** evaluate error SP*/
        Integer codeError = (spValues.get("v_codigoError") != null) ? (Integer) spValues.get("v_codigoError") : 204;
        if (codeError == 200) {
            String planCode = (spValues.get("v_OfferingCode") != null) ? (String) spValues.get("v_OfferingCode") : "";
            String planName = (spValues.get("v_OfferingName") != null) ? (String) spValues.get("v_OfferingName") : "";
            subscriberWrapperDTO.getSubscriberProductItem().setPlanCode(planCode);
            subscriberWrapperDTO.getSubscriberProductItem().setPlanName(planName);
            subscriberWrapperDTO.getSubscriberProductItem().setPlanType(matchValueTypePlan(planName));
        } else if (codeError == 204) {
            throw new NotContentException("No data found for this search by ODS");
        } else {
            throw new InternalErrorException("Internal server error by ODS");
        }
        return subscriberWrapperDTO;
    }

    private String matchValueTypePlan(String typePlan) {
        String nTypePlan = "";
        if (!typePlan.equalsIgnoreCase("")) {
            String[] splitValues = valueMatch.split(",");
            for (String splitValue : splitValues) {
                String[] splitMatchVal = splitValue.split(":");
                if (typePlan.contains(splitMatchVal[0])) {
                    nTypePlan = splitMatchVal[1];
                    break;
                }
            }
            log.info("verificando");
        }
        return nTypePlan;

    }

}
