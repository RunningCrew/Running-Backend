package com.running.crew.exception;

import com.running.crew.constant.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/** 비즈니스 로직 예외 처리 통합 관리용 부모 객체입니다 */
@Getter
@AllArgsConstructor
public class BusinessException extends RuntimeException {
    private final ErrorCode errorCode;
}