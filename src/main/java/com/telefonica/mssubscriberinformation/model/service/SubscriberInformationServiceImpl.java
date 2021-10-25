package com.telefonica.mssubscriberinformation.model.service;

import com.telefonica.mssubscriberinformation.client.ConsumeFsGetSubscriberListClient;
import com.telefonica.mssubscriberinformation.model.dto.SubscriberWrapperDTO;
import com.telefonica.mssubscriberinformation.model.repository.ISubscriberInfoRepository;
import com.telefonica.mssubscriberinformation.util.ExtDataCliToObjUtil;
import com.telefonica.mssubscriberinformation.util.LogsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * @author dpanquev
 * @version 2021-10-14
 */
@Service
public class SubscriberInformationServiceImpl implements ISubscriberInformationService {

    @Autowired
    private ConsumeFsGetSubscriberListClient subscriberListClient;

    @Autowired
    private LogsUtils logsUtils;

    @Autowired
    private ISubscriberInfoRepository subscriberInfoRepository;

    @Autowired
    private ExtDataCliToObjUtil extDataCliToObjUtil;


    /**
     * Method for consume client webservice
     *
     * @param accountId
     * @return
     */
    @Override
    public SubscriberWrapperDTO obtainInformation(String accountId) {

        return consumeSPHomePlan(consumeClientSubscriberList(accountId), accountId);
    }

    private SubscriberWrapperDTO consumeClientSubscriberList(String accountId) {
        return subscriberListClient.consumeSubscriberList(accountId);
    }

    private SubscriberWrapperDTO consumeSPHomePlan(SubscriberWrapperDTO subscriberWrapperDTO, String accountId) {
        return extDataCliToObjUtil.extValuesSP(subscriberWrapperDTO
                , subscriberInfoRepository.consumeSP(accountId, 0612334421, 2));
    }

}
