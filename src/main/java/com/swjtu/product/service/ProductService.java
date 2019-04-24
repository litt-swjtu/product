package com.swjtu.product.service;

import com.swjtu.product.dataobject.ProductInfo;
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
     * */
    List<ProductInfo> findUpAll();
}
