package com.telefonica.mssubscriberinformation.client;

import com.telefonica.mssubscriberinformation.model.dto.SubscriberWrapperDTO;
import com.telefonica.mssubscriberinformation.model.dto.ws.Response;
import com.telefonica.mssubscriberinformation.util.ExtDataCliToObjUtil;
import com.telefonica.mssubscriberinformation.util.ResponseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;


/**
 * Class for configuration and consume fsGetSubscriberList
 *
 * @author dpanquev
 * @version 2021-10-01
 */
@Component
@Slf4j
public class ConsumeFsGetSubscriberListClient {

    @Value("${int.url.fgs}")
    private String urlFsGetSubscriberList;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ResponseValidator validator;

    @Autowired
    private ExtDataCliToObjUtil extDataCliToObjUtil;

    /**Metodo para consumir getSubscriberList
     * */
    public SubscriberWrapperDTO consumeSubscriberList(String accountId) {
        String url = urlFsGetSubscriberList;/**.concat("/").concat(accountId);*/
        var headers = new HttpHeaders();
        headers.set("originator", "app-detail-information-local");
        headers.set("execId", "s");
        headers.set("timestamp", new Timestamp(System.currentTimeMillis()).toString());
        var requestEntity = new HttpEntity<>(null, headers);
        log.info(url + "/" + accountId);
        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");

        ResponseEntity<Response> responseWS = restTemplate.exchange(url, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<Response>() {
        });

        validator.validateStatus(String.valueOf(responseWS.getStatusCodeValue()));
        validator.validateBody(responseWS);

        return extDataCliToObjUtil.evaluateInfo(responseWS.getBody());
    }


}
