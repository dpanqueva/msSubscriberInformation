package com.telefonica.mssubscriberinformation.model.dto.ws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NameCustomerAltItem {
    private String secondLastNameCustomer;
    private String firstNameCustomer;
    private String lastNameCustomer;
    private String middleNameCustomer;
}