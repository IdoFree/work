package com.weijiajiao.controller;

import com.weijiajiao.logcat.SystemLog;
import com.weijiajiao.model.table.Area;
import com.weijiajiao.service.ConfigureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ConfigureService configureService;

    @GetMapping("/cities")
    @ApiOperation(value = "获取所有开通的城市")
    @SystemLog
    public Area[] fetchAllCities(){
       return configureService.getActivityCity();
    }
}
