package com.swjtu.product.repository;

import com.swjtu.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 李天峒
 * @date 2019/4/9 21:13
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * 根据商品状态查询商品信息
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

    /**
     * 根据商品Id列表来查询商品信息列表
     * @param productId
     * @return
     */
    List<ProductInfo> findByProductIdIn(List<String> productId);
}
