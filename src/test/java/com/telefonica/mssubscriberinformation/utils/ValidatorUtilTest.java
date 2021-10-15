package com.telefonica.mssubscriberinformation.utils;


import com.telefonica.mssubscriberinformation.common.exception.BadRequestException;
import com.telefonica.mssubscriberinformation.common.exception.InternalErrorException;
import com.telefonica.mssubscriberinformation.common.exception.NotContentException;
import com.telefonica.mssubscriberinformation.model.LoadData;
import com.telefonica.mssubscriberinformation.model.dto.ws.Response;
import com.telefonica.mssubscriberinformation.model.dto.ws.RspBodyGSD1Item;
import com.telefonica.mssubscriberinformation.util.ResponseValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class ValidatorUtilTest {

    @InjectMocks
    private ResponseValidator responseValidatorUtil;

    private ResponseEntity<Response> response;
    private ResponseEntity<Response> responseRspBodyNull;
    private ResponseEntity<Response> responseSuscriberGDLNull;
    private ResponseEntity<Response> responseSuscriberGDLItemEmpty;

    @BeforeEach
    public void before() {
        LoadData loadData = new LoadData();
        response = new ResponseEntity(HttpStatus.OK);
        responseRspBodyNull = new ResponseEntity(loadData.dataMatchValueRspBodyNull("2"), HttpStatus.OK);
        responseSuscriberGDLNull = new ResponseEntity(loadData.dataMatchValueSuscriberGDLItemNull("2"), HttpStatus.OK);
        responseSuscriberGDLItemEmpty = new ResponseEntity(loadData.dataMatchValueSuscriberGDLItemEmpty("2"), HttpStatus.OK);
    }


    @Test
    void validNoContent() {
        Assertions.assertThrows(NotContentException.class, () -> {
            responseValidatorUtil.validateStatus("204");
        });
    }

    @Test
    void validInternalError() {
        Assertions.assertThrows(InternalErrorException.class, () -> {
            responseValidatorUtil.validateStatus("500");
        });
    }

    @Test
    void validBadRequest() {
        Assertions.assertThrows(BadRequestException.class, () -> {
            responseValidatorUtil.validateStatus("400");
        });
    }

    @Test
    void validOk() {
        Assertions.assertDoesNotThrow(() -> responseValidatorUtil.validateStatus("200"));
    }


    @Test
    void validateBody() {
        Assertions.assertThrows(NotContentException.class, () -> {
            responseValidatorUtil.validateBody(response);
        });
    }

    @Test
    void validateBodyRspBodyGSD1Item() {
        Assertions.assertThrows(NotContentException.class, () -> {
            responseValidatorUtil.validateBody(responseRspBodyNull);
        });
    }

    @Test
    void validateBodyRspResponseSuscriberGDLNull() {
        Assertions.assertThrows(NotContentException.class, () -> {
            responseValidatorUtil.validateBody(responseSuscriberGDLNull);
        });
    }

    @Test
    void validateBodyRspResponseSuscriberGDLEmpty() {
        Assertions.assertThrows(NotContentException.class, () -> {
            responseValidatorUtil.validateBody(responseSuscriberGDLItemEmpty);
        });
    }
}

