package com.yp.vo;

import com.yp.enums.PoorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ResultVO {

    private Integer code;

    private String msg;

    private Object data;

    public ResultVO(){}

    public ResultVO(PoorEnum poorEnum){
        this.code = poorEnum.getCode();
        this.msg = poorEnum.getMsg();
    }

}
