package com.telefonica.mssubscriberinformation.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogsUtils {

    @Autowired
    private ObjectMapper objectMapper;

    @SneakyThrows
    public void printLogDic(Object obj, String typeLog) {
        log.info(typeLog);
        log.info(objectMapper.writeValueAsString(obj));
    }
}
