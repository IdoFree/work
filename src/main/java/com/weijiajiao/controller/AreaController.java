package com.weijiajiao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by junli on 2017/5/25.
 */

@RestController
@RequestMapping("area")
@Api(value = "/area", description = "区域相关的操作")
public class AreaController {

    @GetMapping("/cities")
    @ApiOperation(value = "获取所有开通的城市")
    public String fetchAllCities(){
       return "获取开通的城市";
    }
}
