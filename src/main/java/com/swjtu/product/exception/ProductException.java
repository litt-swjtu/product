package com.swjtu.product.exception;

import com.swjtu.product.enums.ResultEnums;
import lombok.Getter;

/**
 * @author 李天峒
 * @date 2019/5/21 23:04
 */
public class ProductException extends RuntimeException{

    private Integer code;

    public ProductException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public ProductException(ResultEnums resultEnums){
        super(resultEnums.getMessage());
        this.code = resultEnums.getCode();
    }
}
