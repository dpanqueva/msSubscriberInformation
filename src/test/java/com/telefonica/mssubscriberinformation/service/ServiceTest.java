package com.telefonica.mssubscriberinformation.service;


import com.telefonica.mssubscriberinformation.client.ConsumeFsGetSubscriberListClient;
import com.telefonica.mssubscriberinformation.model.LoadData;
import com.telefonica.mssubscriberinformation.model.dto.SubscriberProductItemsDTO;
import com.telefonica.mssubscriberinformation.model.dto.SubscriberWrapperDTO;
import com.telefonica.mssubscriberinformation.model.dto.SubscriberProductItemDescDTO;
import com.telefonica.mssubscriberinformation.model.repository.ISubscriberInfoRepository;
import com.telefonica.mssubscriberinformation.model.service.ISubscriberInformationService;
import com.telefonica.mssubscriberinformation.model.service.SubscriberInformationServiceImpl;
import com.telefonica.mssubscriberinformation.util.ExtDataCliToObjUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class ServiceTest {

    @InjectMocks
    private SubscriberInformationServiceImpl subscriberInformationServiceImpl;

    @Mock
    private ISubscriberInformationService isubscriberInformationService;

    @Mock
    private ISubscriberInfoRepository subscriberInfoRepository;

    @Mock
    private ConsumeFsGetSubscriberListClient subscriberListClient;

    @Mock
    private ExtDataCliToObjUtil extDataCliToObjUtil;

    private SubscriberWrapperDTO subscriberWrapperDTO;

    private Map<String, Object> mapSPInfo200;

    @BeforeEach
    public void before() {
        LoadData loadData = new LoadData();
        mapSPInfo200 = loadData.loadMockSP200(200);
        subscriberWrapperDTO = loadData.loadDataSubscriber();
    }

    @Test
    void consumeClient() {

        when(isubscriberInformationService.obtainInformation("1835"))
                .thenReturn(subscriberWrapperDTO);
        SubscriberWrapperDTO responseDTO = isubscriberInformationService.obtainInformation("1835");
        assertNotNull(responseDTO);
    }

    @Test
    void consumeClientService() {
        String code = "1835";
        when(subscriberListClient.consumeSubscriberList(code)).thenReturn(subscriberWrapperDTO);
        when(subscriberInfoRepository.consumeSP(code, 0612334421, 2))
                .thenReturn(mapSPInfo200);
        when(subscriberInformationServiceImpl.obtainInformation(code)).thenReturn(subscriberWrapperDTO);
        SubscriberWrapperDTO responseDTO = subscriberInformationServiceImpl.obtainInformation(code);
        assertNotNull(responseDTO);
    }

}
