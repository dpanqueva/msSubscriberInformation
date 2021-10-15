package com.telefonica.mssubscriberinformation.common.exception;


import com.telefonica.mssubscriberinformation.common.enums.EResponseType;
import com.telefonica.mssubscriberinformation.model.dto.ResponseDTO;
import com.telefonica.mssubscriberinformation.model.dto.SubscriberWrapperDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.text.ParseException;

/**
 * @author dpanquev
 * @version 2021-09-14
 */
@ControllerAdvice
@Slf4j
public class ExceptionsHandler {

    /**
     * Method obtain error for NotContentException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NotContentException.class)
    public ResponseEntity<Object> notContentException(Exception e) {
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseDTO<>(response(), EResponseType.NO_CONTENT, e.getMessage(), "204"));
    }

    /**
     * Method obtain error for BadRequestException
     *
     * @param e
     * @return
     */
    @ExceptionHandler({BadRequestException.class, ConstraintViolationException.class, MissingRequestHeaderException.class})
    public ResponseEntity<ResponseDTO<SubscriberWrapperDTO>> batRequestException(Exception e) {
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO<>(response(), EResponseType.BAD_REQUEST, e.getMessage(), "400"));
    }

    /**
     * Method obtain error for INTERNAL_SERVER_ERROR
     *
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class, InternalErrorException.class, RuntimeException.class, IOException.class, ParseException.class})
    public final ResponseEntity<ResponseDTO<SubscriberWrapperDTO>> exceptionsGeneral(Exception e) {
        log.info(e.getClass().getName());
        log.error(e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO<>(response(), EResponseType.ERROR, "Se ha presentado un error inesperado", "500"));
    }

    /**
     * Method obtain error for INTERNAL_SERVER_ERROR from client fsGetSubscriberList
     *
     * @param e
     * @return
     */
    @ExceptionHandler({HttpServerErrorException.class})
    public final ResponseEntity<ResponseDTO<Object>> exceptionsClientInternalServerError(Exception e) {
        log.info(e.getClass().getName());
        log.error(e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO<>(response(), EResponseType.ERROR, "Internal server error by FsGetSubscriberList", "500"));
    }

    /**
     * Method obtain error for BAD_REQUEST from client fsGetSubscriberList
     *
     * @param e
     * @return
     */
    @ExceptionHandler({HttpClientErrorException.class})
    public final ResponseEntity<ResponseDTO<SubscriberWrapperDTO>> exceptionsClientBadRequest(Exception e) {
        log.info(e.getClass().getName());
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO<>(response(), EResponseType.ERROR, "Bad Request by FsGetSubscriberList", "400"));
    }


    private SubscriberWrapperDTO response() {
        return new SubscriberWrapperDTO();
    }
}
