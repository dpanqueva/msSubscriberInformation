package com.telefonica.mssubscriberinformation.util;

import com.telefonica.mssubscriberinformation.common.exception.BadRequestException;
import com.telefonica.mssubscriberinformation.common.exception.InternalErrorException;
import com.telefonica.mssubscriberinformation.common.exception.NotContentException;
import com.telefonica.mssubscriberinformation.model.dto.ws.Response;
import com.telefonica.mssubscriberinformation.model.dto.ws.RspBodyGSD1Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


/**
 * @author dpanquev
 * @version 2021-10-14
 * */
@Component
@Slf4j
public class ResponseValidator {

    /**
     * Method by validate errors
     *
     * @param code
     */
    public void validateStatus(String code) {
        switch (code) {
            case "204":
                throw new NotContentException("No data found for this search by FsGetSubscriberList");
            case "400":
                throw new BadRequestException("Bad Request by FsGetSubscriberList");
            case "200":
                log.info("Its OK");
                break;
            default:
                throw new InternalErrorException("Internal server error by FsGetSubscriberList");

        }
    }

    /**
     * Method by validate errors
     *
     * @param response
     */
    public void validateBody(ResponseEntity<Response> response) {
        Response bodyResponse = (response.getBody() != null) ? response.getBody(): null;
        if (bodyResponse == null) {
            throw new NotContentException("No data found for this search by FsGetSubscriberList");
        }
        if(bodyResponse.getRspBodyGSD1Item() == null){
            throw new NotContentException("No data found for this search by FsGetSubscriberList");
        }
        if(bodyResponse.getRspBodyGSD1Item().getSuscriberGDLItem() == null){
            throw new NotContentException("No data found for this search by FsGetSubscriberList");
        }
        if(bodyResponse.getRspBodyGSD1Item().getSuscriberGDLItem().isEmpty()){
            throw new NotContentException("No data found for this search by FsGetSubscriberList");
        }
    }


}
