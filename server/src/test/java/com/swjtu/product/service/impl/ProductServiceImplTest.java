package com.swjtu.product.service.impl;

import com.swjtu.product.ProductApplicationTests;
import com.swjtu.product.common.CartDTO;
import com.swjtu.product.dataobject.ProductInfo;
import com.swjtu.product.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 李天峒
 * @date 2019/4/9 23:55
 */
@Component
public class ProductServiceImplTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        assertTrue(productInfoList.size()>0);
    }

    @Test
    public void decreaseStock(){
        CartDTO cartDTO = new CartDTO("10004" , 10);
        productService.decreaseStock(Arrays.asList(cartDTO));
    }
}