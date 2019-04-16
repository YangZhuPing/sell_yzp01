package com.example.sell_demo04.common;

import lombok.Getter;

@Getter
public enum ResultEnums {
    SUCCESS(0,"成功"),
    FAIL(1,"失败"),
    PRODUCR_UP(0,"正常"),
    PRODUCR_DOWN(1,"商品下架");
    private int code;
    private String msg;
    ResultEnums(int code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
