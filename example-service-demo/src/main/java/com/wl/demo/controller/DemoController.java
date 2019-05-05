package com.wl.demo.controller;


import com.wl.comm.ResBody;
import com.wl.demo.entity.DemoReq;
import com.wl.demo.entity.DemoRes;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * 测试demo 控制器
 * @author wl
 * @description TODO
 * @date 2019/4/30 15:52
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoController  {
    private static Logger log = LoggerFactory.getLogger(DemoController.class);

    @ApiOperation(value = "测试输出demo字符串", notes = "返回msg以及自身的集群信息")
    @ApiParam(name = "msg", value = "get请求参数", required = true)
    @RequestMapping(value = "/hi" ,method = GET)
    public String hello(HttpServletRequest request, @RequestParam String msg){
        long startTime = System.currentTimeMillis();
        
        String resBody = "I am the "+msg+" , ";
        log.info(resBody);
        return resBody;
    }
    @ApiOperation(value = "测试输出demo实体信息", notes = "根据demoReq返回demoRes信息")
    @RequestMapping(value = "/get" ,method = RequestMethod.POST)
    public ResBody  get(@RequestBody DemoReq req){
        long startTime = System.currentTimeMillis();
        DemoRes demoRes=new DemoRes();
        ResBody<DemoRes> resBody = new ResBody<DemoRes>();
        demoRes.setId(1);
        demoRes.setDemoCode("000");
        demoRes.setDemoDesc("请求成功");
        resBody.setRetCode("000000");
        resBody.setRetDesc("SUCCESS");
        resBody.setRspBody(demoRes);
        log.info(resBody.toString());
        return resBody;
    }

}
