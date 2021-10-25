package com.telefonica.mssubscriberinformation.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.telefonica.mssubscriberinformation.model.LoadData;
import com.telefonica.mssubscriberinformation.model.dto.SubscriberWrapperDTO;
import com.telefonica.mssubscriberinformation.util.LogsUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class LogsUtilTest {

    @InjectMocks
    private LogsUtils logsUtils;

    @Mock
    private ObjectMapper objectMapper;

    private SubscriberWrapperDTO subscriberWrapperDTO;


    @BeforeEach
    public void before() {
        LoadData loadData = new LoadData();
        subscriberWrapperDTO = loadData.loadDataSubscriber();
    }


    @Test
    void printLog() {
        Assertions.assertDoesNotThrow(() -> logsUtils.printLogDic(subscriberWrapperDTO, "response"));
    }


}

