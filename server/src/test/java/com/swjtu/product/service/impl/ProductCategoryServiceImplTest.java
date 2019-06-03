package com.swjtu.product.service.impl;

import com.swjtu.product.ProductApplicationTests;
import com.swjtu.product.dataobject.ProductCategory;
import com.swjtu.product.service.ProductCategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 李天峒
 * @date 2019/4/11 17:34
 */
@Component
public class ProductCategoryServiceImplTest extends ProductApplicationTests {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void findByCategoryTypeIn() throws Exception{

        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(Arrays.asList(1,2,10));
        System.out.println(productCategoryList);
        assertTrue(productCategoryList.size()>0);
    }

    @Test
    public void save(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("小孩最爱");
        productCategory.setCategoryType(12);
        productCategoryService.save(productCategory);

    }
}