package com.swjtu.product.enums;

import lombok.Getter;

/**
 * @author 李天峒
 * @date 2019/5/21 23:05
 */
@Getter
public enum ResultEnums {
    /**
     * 商品状态
     */
    PRODUCT_NOT_EXIST(1,"商品不存在"),
    PRODUCT_STOCK_ERROR(2,"商品存库不足")
    ;

    private Integer code;
    private String message;

    ResultEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
