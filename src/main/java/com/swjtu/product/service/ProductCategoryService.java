package com.swjtu.product.service;

import com.swjtu.product.dataobject.ProductCategory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 李天峒
 * @date 2019/4/10 17:56
 */
@Component
public interface ProductCategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
