package com.telefonica.mssubscriberinformation.model;

import com.telefonica.mssubscriberinformation.model.dto.ws.*;

import java.util.ArrayList;
import java.util.List;

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

}
