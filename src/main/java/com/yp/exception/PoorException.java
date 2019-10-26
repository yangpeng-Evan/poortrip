package com.yp.exception;

import com.yp.enums.PoorEnum;
import lombok.Getter;

@Getter
public class PoorException extends RuntimeException {

    private Integer code;

    public PoorException(PoorEnum poorEnum) {
        super(poorEnum.getMsg());
        this.code = poorEnum.getCode();
    }
}
