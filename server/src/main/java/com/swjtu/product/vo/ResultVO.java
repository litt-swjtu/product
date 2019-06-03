package com.swjtu.product.vo;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * @author 李天峒
 * @date 2019/4/11 17:46
 */
@Data
public class ResultVO<T> {

    /** 错误码.*/
    private  Integer code;

    /** 提示信息.*/
    private String message;

    /** 返回内容.*/
    private T Data;

}
