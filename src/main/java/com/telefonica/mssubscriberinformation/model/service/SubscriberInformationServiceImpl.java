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
    public SubscriberWrapperDTO consumeClient(String accountId) {
        SubscriberWrapperDTO subscriberWrapperDTO = subscriberListClient.consumeSubscriberList(accountId);
        Map<String, Object> spValues = subscriberInfoRepository.consumeSP(accountId, 0, 1);
        subscriberWrapperDTO = extDataCliToObjUtil.extValuesSP(subscriberWrapperDTO, spValues);
        return subscriberWrapperDTO;
    }

}
