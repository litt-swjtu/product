package com.swjtu.product.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author 李天峒
 * @date 2019/4/9 22:13
 */
@Entity
@Data
@DynamicUpdate
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //自增的写法
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;
}
