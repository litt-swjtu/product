package com.swjtu.product.controller;

import com.swjtu.product.common.CartDTO;
import com.swjtu.product.dataobject.ProductCategory;
import com.swjtu.product.dataobject.ProductInfo;
import com.swjtu.product.service.ProductCategoryService;
import com.swjtu.product.service.ProductService;
import com.swjtu.product.utils.ResultVOUtil;
import com.swjtu.product.vo.ProductInfoVO;
import com.swjtu.product.vo.ProductVO;
import com.swjtu.product.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 李天峒
 * @date 2019/4/4 17:49
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;
    //1、查询所以商品信息
    //2、查询类目type列表
    //3、查询类目
    //4、构造数据

    /**
     * 获取商品列表
     * */
    @GetMapping("/list")
    public ResultVO<ProductVO> list(){
        //1.查询所有在架商品的信息
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2.获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        //3.从数据库查询类目
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //4.构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    //定义一个商品下属的结构对象（ProductInfoVO）
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    /*普通方式
                    productInfoVO.setProductName(productInfo.getProductName());                  //赋值商品名称
                    productInfoVO.setProductPrice(productInfo.getProductPrice());                //赋值商品价格
                    productInfoVO.setProductDescription(productInfo.getProductDescription());    //赋值商品描述
                    productInfoVO.setProductIcon(productInfo.getProductIcon());                  //赋值商品图片
                    */
                    //特殊方式  Java8语法
                    //一次性直接赋值
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    //将商品信息添加到list中保存
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }

    /**
     * 获取商品信息列表（给订单服务使用）
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody  List<String> productIdList){

        List<ProductInfo> productInfoList = productService.findListById(productIdList);
        return productInfoList;
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList){
        productService.decreaseStock(cartDTOList);
    }
}
