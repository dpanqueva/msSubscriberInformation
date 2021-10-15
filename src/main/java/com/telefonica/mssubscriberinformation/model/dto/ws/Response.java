package com.telefonica.mssubscriberinformation.model.dto.ws;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Response{

	@JsonProperty("RspBodyGSD1Item")
	private RspBodyGSD1Item rspBodyGSD1Item;
}