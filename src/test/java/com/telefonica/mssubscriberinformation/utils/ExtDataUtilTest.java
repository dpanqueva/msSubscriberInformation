package com.telefonica.mssubscriberinformation.utils;


import com.telefonica.mssubscriberinformation.model.LoadData;
import com.telefonica.mssubscriberinformation.model.dto.SubscriberWrapperDTO;
import com.telefonica.mssubscriberinformation.model.dto.ws.Response;
import com.telefonica.mssubscriberinformation.util.ExtDataCliToObjUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class ExtDataUtilTest {

    @InjectMocks
    private ExtDataCliToObjUtil extDataCliToObjUtil;

    private Response responseDTOWs0;
    private Response responseDTOWs1;
    private Response responseDTOWs2;
    private Response responseDTOWs3;
    private Response responseDTOWs4;
    private Response responseDTOWs5;
    private Response responseDTOWs6;
    private Response responseDTOWs7;
    private Response responseDTOWs8;
    private Response responseDTOWs9;
    private Response responseDTOWsE;

    @BeforeEach
    public void before() {
        LoadData loadData = new LoadData();
        responseDTOWs0 = loadData.dataMatchValue2("0");
        responseDTOWs1 = loadData.dataMatchValue2("1");
        responseDTOWs2 = loadData.dataMatchValue2("2");
        responseDTOWs3 = loadData.dataMatchValue2("3");
        responseDTOWs4 = loadData.dataMatchValue2("4");
        responseDTOWs5 = loadData.dataMatchValue2("5");
        responseDTOWs6 = loadData.dataMatchValue2("6");
        responseDTOWs7 = loadData.dataMatchValue2("7");
        responseDTOWs8 = loadData.dataMatchValue2("8");
        responseDTOWs9 = loadData.dataMatchValue2("9");
        responseDTOWsE = loadData.dataMatchValue2("E");
    }

    @Test
    void validateExtractInfo0() {
        SubscriberWrapperDTO responseDTO = extDataCliToObjUtil.evaluateInfo(responseDTOWs0);
        assertNotNull(responseDTO);
    }

    @Test
    void validateExtractInfo1() {
        SubscriberWrapperDTO responseDTO = extDataCliToObjUtil.evaluateInfo(responseDTOWs1);
        assertNotNull(responseDTO);
    }

    @Test
    void validateExtractInfo2() {
        SubscriberWrapperDTO responseDTO = extDataCliToObjUtil.evaluateInfo(responseDTOWs2);
        assertNotNull(responseDTO);
    }

    @Test
    void validateExtractInfo3() {
        SubscriberWrapperDTO responseDTO = extDataCliToObjUtil.evaluateInfo(responseDTOWs3);
        assertNotNull(responseDTO);
    }

    @Test
    void validateExtractInfo4() {
        SubscriberWrapperDTO responseDTO = extDataCliToObjUtil.evaluateInfo(responseDTOWs4);
        assertNotNull(responseDTO);
    }

    @Test
    void validateExtractInfo5() {
        SubscriberWrapperDTO responseDTO = extDataCliToObjUtil.evaluateInfo(responseDTOWs5);
        assertNotNull(responseDTO);
    }

    @Test
    void validateExtractInfo6() {
        SubscriberWrapperDTO responseDTO = extDataCliToObjUtil.evaluateInfo(responseDTOWs6);
        assertNotNull(responseDTO);
    }

    @Test
    void validateExtractInfo7() {
        SubscriberWrapperDTO responseDTO = extDataCliToObjUtil.evaluateInfo(responseDTOWs7);
        assertNotNull(responseDTO);
    }

    @Test
    void validateExtractInfo8() {
        SubscriberWrapperDTO responseDTO = extDataCliToObjUtil.evaluateInfo(responseDTOWs8);
        assertNotNull(responseDTO);
    }

    @Test
    void validateExtractInfo9() {
        SubscriberWrapperDTO responseDTO = extDataCliToObjUtil.evaluateInfo(responseDTOWs9);
        assertNotNull(responseDTO);
    }

    @Test
    void validateExtractInfoE() {
        SubscriberWrapperDTO responseDTO = extDataCliToObjUtil.evaluateInfo(responseDTOWsE);
        assertNotNull(responseDTO);
    }

}

