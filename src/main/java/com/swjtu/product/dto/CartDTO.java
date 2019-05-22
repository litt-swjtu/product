package com.swjtu.product.dto;

import lombok.Data;

/**
 * @author 李天峒
 * @date 2019/5/21 22:58
 */
@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
