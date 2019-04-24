package com.swjtu.product.enums;

import lombok.Getter;

/**
 * @author 李天峒
 * @date 2019/4/9 23:44
 */
@Getter
public enum ProductStatusEnums {

    /*商品在架状态*/
    UP(0,"在架"),
    /*商品下架状态*/
    DOWN(1, "下架");

    private Integer code;

    private String message;

    ProductStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
