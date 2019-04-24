package com.swjtu.product.service.impl;

import com.swjtu.product.dataobject.ProductCategory;
import com.swjtu.product.repository.ProductCategoryRepository;
import com.swjtu.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李天峒
 * @date 2019/4/10 17:57
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }
}
