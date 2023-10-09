package com.running.crew.config;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseResponse {
    private final String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    private final boolean success = false;
    private int status = 200;
    private Object result;

    public static BaseResponse of(int status, Object result) {
        return new BaseResponse(status, result);
    }
}
