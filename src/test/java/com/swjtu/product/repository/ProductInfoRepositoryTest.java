package com.swjtu.product.repository;

import com.swjtu.product.dataobject.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.rmi.runtime.Log;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;

/**
 * @author 李天峒
 * @date 2019/4/9 21:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> productInfoList = repository.findByProductStatus(0);
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void saveTest() {

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("10003");
        productInfo.setProductName("机械键盘");
        productInfo.setProductPrice(new BigDecimal(400));
        productInfo.setProductStock(50);
        productInfo.setProductDescription("茶轴机械键盘");
        productInfo.setProductIcon("https://detail.tmall.com/item.htm?spm=a220m.1000858.1000725.6.200b7664bjuPbd&id=581155881013&skuId=3882849309406&user_id=4205584977&cat_id=2&is_b=1&rn=27e9d639e5f625c524d01dac78bbce42");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(0);

        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductIdIn() throws Exception{
        List<ProductInfo> productInfoList = repository.findByProductIdIn(Arrays.asList("10000","10001"));
        log.info("【商品信息】, list={}" ,productInfoList);
        Assert.assertNotNull(productInfoList);
    }
}