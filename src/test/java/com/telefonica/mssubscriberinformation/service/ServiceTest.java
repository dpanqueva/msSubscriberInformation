package com.telefonica.mssubscriberinformation.service;


import com.telefonica.mssubscriberinformation.client.ConsumeFsGetSubscriberListClient;
import com.telefonica.mssubscriberinformation.model.dto.SubscriberProductItemsDTO;
import com.telefonica.mssubscriberinformation.model.dto.SubscriberWrapperDTO;
import com.telefonica.mssubscriberinformation.model.dto.ws.SubscriberProductItemDescDTO;
import com.telefonica.mssubscriberinformation.model.service.ISubscriberInformationService;
import com.telefonica.mssubscriberinformation.model.service.SubscriberInformationServiceImpl;
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
    private ConsumeFsGetSubscriberListClient consumeFsGetSubscriberListClient;

    private SubscriberWrapperDTO subscriberWrapperDTO;


    @BeforeEach
    public void before() {
        subscriberWrapperDTO = new SubscriberWrapperDTO();
        SubscriberProductItemsDTO subscriberProductItemsDTO = new SubscriberProductItemsDTO();
        List<SubscriberProductItemDescDTO> subscriberProductItemDescDTOList = new ArrayList<>();
        SubscriberProductItemDescDTO subscriberProductItemDescDTO = new SubscriberProductItemDescDTO();
        subscriberProductItemsDTO.setActiveDate("2021-01-01");
        subscriberProductItemsDTO.setPlanName("Trio Voz Ilimitada Nacional Internet 5Mbps TV Diamante_S384");
        subscriberProductItemsDTO.setPlanCode("11798o");
        subscriberProductItemsDTO.setSubscriberProductItemDesc(subscriberProductItemDescDTOList);
    }

    @Test
    void consumeClient() {

        when(isubscriberInformationService.consumeClient("1835"))
                .thenReturn(subscriberWrapperDTO);
        SubscriberWrapperDTO responseDTO = isubscriberInformationService.consumeClient("1835");
        assertNotNull(responseDTO);
    }

    @Test
    void consumeClientService() {

        when(subscriberInformationServiceImpl.consumeClient("1835"))
                .thenReturn(subscriberWrapperDTO);
        SubscriberWrapperDTO responseDTO = subscriberInformationServiceImpl.consumeClient("1835");
        assertNotNull(responseDTO);
    }

}
