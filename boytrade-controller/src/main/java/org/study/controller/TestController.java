package org.study.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.study.boytrade.service.test.BoyTradePrintService;
import org.study.config.ApiPath;

/**
 * @author fanqie
 * @date 2020/5/30
 */
@RestController
public class TestController {

    @Reference
    private BoyTradePrintService boyTradePrintService;

    @GetMapping(ApiPath.Test.ECHO)
    public String echoString(@RequestParam("param") String param) {
        return boyTradePrintService.printString(param);
    }
}
