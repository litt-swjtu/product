package com.swjtu.product.service.impl;

import com.swjtu.product.common.DecreaseStockInput;
import com.swjtu.product.dataobject.ProductInfo;
import com.swjtu.product.enums.ProductStatusEnums;
import com.swjtu.product.enums.ResultEnums;
import com.swjtu.product.exception.ProductException;
import com.swjtu.product.repository.ProductInfoRepository;
import com.swjtu.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<ProductInfo> findListById(List<String> productId) {
        List<ProductInfo> productInfoList = repository.findByProductIdIn(productId);
        return productInfoList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        for(DecreaseStockInput decreaseStockInput : decreaseStockInputList){
            Optional<ProductInfo> productInfoOptional = repository.findById(decreaseStockInput.getProductId());
            //判断商品是否存在
            if(!productInfoOptional.isPresent()){
                throw new ProductException(ResultEnums.PRODUCT_NOT_EXIST);
            }
            //判断库存是否足够
            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if(result <= 0){
                throw new ProductException(ResultEnums.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }
}
