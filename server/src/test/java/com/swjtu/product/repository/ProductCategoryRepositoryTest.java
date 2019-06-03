package com.swjtu.product.repository;

import com.swjtu.product.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


/**
 * @author 李天峒
 * @date 2019/4/9 23:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1);
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(1);
        repository.save(productCategory);

    }
    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory>  productCategoryList = repository.findByCategoryTypeIn(Arrays.asList(1,2,3));
        Assert.assertNotNull(productCategoryList);
    }
}