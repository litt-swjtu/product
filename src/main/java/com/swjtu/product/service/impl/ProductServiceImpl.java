package com.swjtu.product.service.impl;

import com.swjtu.product.dataobject.ProductInfo;
import com.swjtu.product.enums.ProductStatusEnums;
import com.swjtu.product.repository.ProductInfoRepository;
import com.swjtu.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李天峒
 * @date 2019/4/9 23:31
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public List<ProductInfo> findUpAll() {
        List<ProductInfo> productInfoList = repository.findByProductStatus(ProductStatusEnums.UP.getCode());
        return productInfoList;
    }
}
