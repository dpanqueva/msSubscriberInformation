package com.telefonica.mssubscriberinformation.model.dto.ws;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RspBodyGSD1Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("suscriberGDLItem")
    private List<SuscriberGDLItemItem> suscriberGDLItem;
}