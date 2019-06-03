package com.swjtu.product.common;

import lombok.Data;

/**
 * @author 李天峒
 * @date 2019/6/3 14:50
 */
@Data
public class DecreaseStockInput {
    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
