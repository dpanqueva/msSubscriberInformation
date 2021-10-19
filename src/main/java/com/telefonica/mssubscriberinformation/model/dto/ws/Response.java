package com.telefonica.mssubscriberinformation.model.dto.ws;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Response implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("RspBodyGSD1Item")
	private RspBodyGSD1Item rspBodyGSD1Item;
}