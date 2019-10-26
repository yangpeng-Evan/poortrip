package com.yp.enums;

import lombok.Getter;

@Getter
public enum PoorEnum {
    PARAM_ERROR(1,"参数错误!!"),
    USER_USERNAME_ERROR(2,"用户名错误!!"),
    USER_PASSWORD_ERROR(3,"密码错误!!"),
    USERNAMEORPASSWORD_ERROR(11,"用户名或密码错误"),
    UPLOAD_FILE_BAD_ERROR(20,"图片损坏"),
    UPLOAD_FILE_TYPE_ERROR(21,"图片类型错误，请上传正确类型的图片"),
    UPLOAD_FILE_SIZE_ERROR(22,"图片过大，请上传5M以内的图片"),
    UPLOAD_FILE_ERROR(23,"图片不能为空");

    private Integer code;

    private String msg;

    PoorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
