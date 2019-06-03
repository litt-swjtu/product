package com.swjtu.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李天峒
 * @date 2019/4/23 0:06
 */
@RestController
@RequestMapping(value = "/product")
public class ServiceController {

    @GetMapping("/Msg")
    public String Msg(){
        return "This is Product`s service!";
    }
}
