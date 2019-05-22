package com.swjtu.product.service;

import com.swjtu.product.dataobject.ProductInfo;
import com.swjtu.product.dto.CartDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李天峒
 * @date 2019/4/9 23:27
 */
@Component
public interface ProductService {

    /**
     *查询所有在架商品列表
     * @return 商品信息列表
     * */
    List<ProductInfo> findUpAll();

    /**
     *根据Id查询商品信息
     * @param productId
     * @return 商品信息列表
     */
    List<ProductInfo> findListById(List<String> productId);

    /**
     * 扣库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
