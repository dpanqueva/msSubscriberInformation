package com.telefonica.mssubscriberinformation.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.telefonica.mssubscriberinformation.common.enums.EResponseType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author dpanquev
 * @version 0.0.1
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO<T> {

    private T serviceResponse;
    private EResponseType type;
    private String message;
    private String code;

}
