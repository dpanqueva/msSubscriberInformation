package com.telefonica.mssubscriberinformation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PKSubscriberInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String vOfferingCode;

    private String vOfferingName;
}
