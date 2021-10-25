package com.telefonica.mssubscriberinformation.model.service;

import com.telefonica.mssubscriberinformation.model.dto.SubscriberWrapperDTO;

/**
 * @author dpanquev
 * @version 2021-10-14
 * */
public interface ISubscriberInformationService {

    public SubscriberWrapperDTO obtainInformation(String accountId);

}
