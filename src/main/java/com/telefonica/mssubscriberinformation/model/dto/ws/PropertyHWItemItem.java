package com.telefonica.mssubscriberinformation.model.dto.ws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyHWItemItem implements Serializable {

    private static final long serialVersionUID = 1L;
    private String idParameter;
    private String valueParameter;
}