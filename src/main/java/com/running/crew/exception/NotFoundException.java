package com.running.crew.exception;

import com.running.crew.constant.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundException extends BusinessException {
    private String message;

    public NotFoundException(String message) {
        super(ErrorCode._BAD_REQUEST);
        this.message = message;
    }

    public NotFoundException(ErrorCode errorCode, String message) {
        super(errorCode);
        this.message = message;
    }

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
