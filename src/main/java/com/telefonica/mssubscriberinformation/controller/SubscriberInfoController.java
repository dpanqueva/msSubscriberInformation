package com.telefonica.mssubscriberinformation.controller;

import com.telefonica.mssubscriberinformation.common.enums.EResponseType;
import com.telefonica.mssubscriberinformation.common.headers.BlindHeaders;
import com.telefonica.mssubscriberinformation.model.dto.ResponseDTO;
import com.telefonica.mssubscriberinformation.model.dto.SubscriberWrapperDTO;
import com.telefonica.mssubscriberinformation.model.service.ISubscriberInformationService;
import com.telefonica.mssubscriberinformation.util.LogsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telefonica/customer/v1/subscriberinformation")
@Validated
@Slf4j
public class SubscriberInfoController {

    @Autowired
    private BlindHeaders blindHeaders;

    @Autowired
    private ISubscriberInformationService subscriberInformationService;

    @Autowired
    private LogsUtils logsUtils;

    @GetMapping(path = "/subscriberInfoByAccountId/{accountId}")
    public ResponseEntity<ResponseDTO<SubscriberWrapperDTO>> subscriberInfoByAccountId(@RequestHeader HttpHeaders headers, @PathVariable
            String accountId) {


        logsUtils.printLogDic(accountId, "PathVariable");
        logsUtils.printLogDic(headers, "HeadersEntry");

        log.info("se consumio correctamente");
        headers = blindHeaders.headersInEvaluate(headers);
        logsUtils.printLogDic(headers, "HeaderOut");
        var response = new ResponseDTO<>(subscriberInformationService.obtainInformation(accountId), EResponseType.SUCCESS
                , "SUCCESS", "200");
        logsUtils.printLogDic(response, "response");
        log.info("se consumio correctamente" + accountId);
        return ResponseEntity.ok().headers(headers)
                .body(response);
    }
}
