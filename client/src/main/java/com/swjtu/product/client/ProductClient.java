package com.swjtu.product.client;

import com.swjtu.product.common.CartDTO;
import com.swjtu.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author 李天峒
 * @date 2019/6/3 14:34
 */
@FeignClient(value = "product")
public interface ProductClient {

    /**
     * 获取商品列表
     * @param productIdList
     * @return
     */
    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> getListForOrder(@RequestBody List<String> productIdList);

    /**
     * 删除库存
     * @param cartDTOList
     */
    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);
}
