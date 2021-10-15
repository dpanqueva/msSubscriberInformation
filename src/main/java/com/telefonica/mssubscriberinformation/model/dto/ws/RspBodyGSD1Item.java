package com.telefonica.mssubscriberinformation.model.dto.ws;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RspBodyGSD1Item {

    @JsonProperty("suscriberGDLItem")
    private List<SuscriberGDLItemItem> suscriberGDLItem;
}