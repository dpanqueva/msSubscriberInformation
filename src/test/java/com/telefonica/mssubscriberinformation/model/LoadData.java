package com.telefonica.mssubscriberinformation.model;

import com.telefonica.mssubscriberinformation.model.dto.SubscriberProductItemDescDTO;
import com.telefonica.mssubscriberinformation.model.dto.SubscriberProductItemsDTO;
import com.telefonica.mssubscriberinformation.model.dto.SubscriberWrapperDTO;
import com.telefonica.mssubscriberinformation.model.dto.ws.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadData {


    public Response dataMatchValueRspBodyNull(String netWorkResourceIdCh) {
        return new Response(null);
    }

    public Response dataMatchValueSuscriberGDLItemNull(String netWorkResourceIdCh) {

        SuscriberGDLItemItem suscriberGDLItemItem = new SuscriberGDLItemItem();
        suscriberGDLItemItem.setPrimaryOfferingItem(new PrimaryOfferingItem("20213o", null
                , "Plan Voz Ilimitado Nacional para Trio_20213", null));

        SubscriberInformationItem subscriberInformationItem = new SubscriberInformationItem();
        subscriberInformationItem.setNetworkResourceIdCH(netWorkResourceIdCh);

        suscriberGDLItemItem.setSubscriberInformationItem(subscriberInformationItem);

        PrimaryOfferingItem primaryOfferingItem = new PrimaryOfferingItem();
        primaryOfferingItem.setIdProductOffering("20213o");
        primaryOfferingItem.setNameProductOffering("Plan Voz Ilimitado Nacional para Trio_20213");

        suscriberGDLItemItem.setPrimaryOfferingItem(primaryOfferingItem);

        RspBodyGSD1Item rspBodyGSD1Item = new RspBodyGSD1Item();
        rspBodyGSD1Item.setSuscriberGDLItem(null);

        return new Response(rspBodyGSD1Item);
    }

    public Response dataMatchValueSuscriberGDLItemEmpty(String netWorkResourceIdCh) {
        List<SuscriberGDLItemItem> lstSuscriberGDLItemItems = new ArrayList<>();
        SuscriberGDLItemItem suscriberGDLItemItem = new SuscriberGDLItemItem();
        suscriberGDLItemItem.setPrimaryOfferingItem(new PrimaryOfferingItem("20213o", null
                , "Plan Voz Ilimitado Nacional para Trio_20213", null));

        SubscriberInformationItem subscriberInformationItem = new SubscriberInformationItem();
        subscriberInformationItem.setNetworkResourceIdCH(netWorkResourceIdCh);

        suscriberGDLItemItem.setSubscriberInformationItem(subscriberInformationItem);

        PrimaryOfferingItem primaryOfferingItem = new PrimaryOfferingItem();
        primaryOfferingItem.setIdProductOffering("20213o");
        primaryOfferingItem.setNameProductOffering("Plan Voz Ilimitado Nacional para Trio_20213");

        suscriberGDLItemItem.setPrimaryOfferingItem(primaryOfferingItem);

        RspBodyGSD1Item rspBodyGSD1Item = new RspBodyGSD1Item();
        rspBodyGSD1Item.setSuscriberGDLItem(lstSuscriberGDLItemItems);

        return new Response(rspBodyGSD1Item);
    }

    public Response dataMatchValue2(String netWorkResourceIdCh) {
        List<SuscriberGDLItemItem> lstSuscriberGDLItemItems = new ArrayList<>();
        SuscriberGDLItemItem suscriberGDLItemItem = new SuscriberGDLItemItem();
        suscriberGDLItemItem.setPrimaryOfferingItem(new PrimaryOfferingItem("20213o", null
                , "Plan Voz Ilimitado Nacional para Trio_20213", null));
        lstSuscriberGDLItemItems.add(suscriberGDLItemItem);

        SubscriberInformationItem subscriberInformationItem = new SubscriberInformationItem();
        subscriberInformationItem.setNetworkResourceIdCH(netWorkResourceIdCh);

        suscriberGDLItemItem.setSubscriberInformationItem(subscriberInformationItem);

        PrimaryOfferingItem primaryOfferingItem = new PrimaryOfferingItem();
        primaryOfferingItem.setIdProductOffering("20213o");
        primaryOfferingItem.setNameProductOffering("Plan Voz Ilimitado Nacional para Trio_20213");

        suscriberGDLItemItem.setPrimaryOfferingItem(primaryOfferingItem);

        RspBodyGSD1Item rspBodyGSD1Item = new RspBodyGSD1Item();
        rspBodyGSD1Item.setSuscriberGDLItem(lstSuscriberGDLItemItems);

        return new Response(rspBodyGSD1Item);
    }

    public Map<String, Object> loadMockSP200(Integer error) {
        Map<String, Object> mapSPInfo200 = new HashMap<>();
        mapSPInfo200.put("v_codigoError", error);
        mapSPInfo200.put("v_OfferingCode", "INTO v_OfferingCode");
        mapSPInfo200.put("v_OfferingName", "Plan Voz Ilimitado Nacional 30 Min LDI para Duo");
        return mapSPInfo200;
    }

    public SubscriberWrapperDTO loadDataSubscriber(){
        SubscriberWrapperDTO subscriberWrapperDTO = new SubscriberWrapperDTO();
        SubscriberProductItemsDTO subscriberProductItemsDTO = new SubscriberProductItemsDTO();
        List<SubscriberProductItemDescDTO> subscriberProductItemDescDTOList = new ArrayList<>();
        SubscriberProductItemDescDTO subscriberProductItemDescDTO = new SubscriberProductItemDescDTO();
        subscriberProductItemsDTO.setActiveDate("2021-01-01");
        subscriberProductItemsDTO.setPlanName("Trio Voz Ilimitada Nacional Internet 5Mbps TV Diamante_S384");
        subscriberProductItemsDTO.setPlanCode("11798o");
        subscriberProductItemsDTO.setSubscriberProductItemDesc(subscriberProductItemDescDTOList);

        subscriberWrapperDTO.setSubscriberProductItem(subscriberProductItemsDTO);

        return subscriberWrapperDTO;
    }
}
