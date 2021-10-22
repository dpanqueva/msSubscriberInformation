package com.telefonica.mssubscriberinformation.model.service;

import com.telefonica.mssubscriberinformation.client.ConsumeFsGetSubscriberListClient;
import com.telefonica.mssubscriberinformation.model.dto.SubscriberWrapperDTO;
import com.telefonica.mssubscriberinformation.util.LogsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    /**
     * Method for consume client webservice
     *
     * @param accountId
     * @return
     */
    @Override
    public SubscriberWrapperDTO consumeClient(String accountId) {
        return subscriberListClient.consumeSubscriberList(accountId);
    }

}
