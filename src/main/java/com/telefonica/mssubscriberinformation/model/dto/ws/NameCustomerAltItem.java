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
public class NameCustomerAltItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private String secondLastNameCustomer;
    private String firstNameCustomer;
    private String lastNameCustomer;
    private String middleNameCustomer;
}