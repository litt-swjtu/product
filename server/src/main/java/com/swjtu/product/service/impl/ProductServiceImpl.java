package com.swjtu.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.tools.json.JSONUtil;
import com.swjtu.product.common.DecreaseStockInput;
import com.swjtu.product.common.ProductInfoOutput;
import com.swjtu.product.dataobject.ProductInfo;
import com.swjtu.product.enums.ProductStatusEnums;
import com.swjtu.product.enums.ResultEnums;
import com.swjtu.product.exception.ProductException;
import com.swjtu.product.repository.ProductInfoRepository;
import com.swjtu.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author 李天峒
 * @date 2019/4/9 23:31
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Autowired
    private AmqpTemplate amqpTemplate;

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
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = decreaseStockProcess(decreaseStockInputList);

        //发送MQ消息
        List<ProductInfoOutput> productInfoOutputList = productInfoList.stream().map(e ->{
            ProductInfoOutput productInfoOutput = new ProductInfoOutput();
            BeanUtils.copyProperties(e, productInfoOutput);
            return productInfoOutput;
        }).collect(Collectors.toList());
        amqpTemplate.convertAndSend("productInfo", JSON.toJSON(productInfoOutputList).toString());
    }


    /**
     * 执行扣库存过程
     * @param decreaseStockInputList
     * @return
     */
    @Transactional()
    public List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = new ArrayList<>();
        for (DecreaseStockInput decreaseStockInput : decreaseStockInputList) {
            Optional<ProductInfo> productInfoOptional = repository.findById(decreaseStockInput.getProductId());
            //判断商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnums.PRODUCT_NOT_EXIST);
            }
            //判断库存是否足够
            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if (result <= 0) {
                throw new ProductException(ResultEnums.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            repository.save(productInfo);
            productInfoList.add(productInfo);
        }
        return productInfoList;
    }
}
