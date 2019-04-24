package com.swjtu.product.repository;

import com.swjtu.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 李天峒
 * @date 2019/4/9 21:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
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
        productInfo.setProductId("12349");
        productInfo.setProductName("老坛酸菜");
        productInfo.setProductPrice(new BigDecimal(5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("正宗康师傅老坛酸菜面");
        productInfo.setProductIcon("http://xxxx");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(0);

        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }
}