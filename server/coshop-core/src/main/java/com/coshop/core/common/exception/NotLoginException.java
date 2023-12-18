package com.coshop.core.common.exception;

import com.coshop.core.common.enums.ResponseCode;
import lombok.Getter;

/**
 * @author dixiey
 * @version 1.0
 * @description: TODO
 * @date 2023/11/26 15:57
 */
@Getter
public class NotLoginException extends RuntimeException{

    private final ResponseCode code;

    public NotLoginException(ResponseCode userNotExist) {
        this.code = userNotExist;
    }
}
