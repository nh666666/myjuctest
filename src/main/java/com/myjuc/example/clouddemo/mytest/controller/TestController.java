package com.myjuc.example.clouddemo.mytest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: niehan
 * @Description:
 * @Date:Create：in 2020/5/13 16:30
 */
@RestController
@RequestMapping("/test")
@Api(value = "测试 控制器", tags = "API-测试控制器")
public class TestController {

    @PostMapping(value = "/testPost")
    @ApiOperation(value = "测试")
    public String addDrone(@RequestBody String test) {
        System.out.println(test);
        return test;
    }

    @GetMapping(value = "/testWjk")
    @ApiOperation(value = "测试")
    public String testWjk() {
        return "wjkkarry 是很好看的 boy 说的对 最好看";
    }

}
