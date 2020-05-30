package org.study.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.study.boytrade.test.BoyTradePrintService;
import org.study.config.ApiPath;

/**
 * @author fanqie
 * @date 2020/5/30
 */
@RestController
public class TestController {

    private BoyTradePrintService boyTradePrintService;

    @PostMapping(ApiPath.Test.ECHO)
    public String echoString(@RequestBody String body) {
        return boyTradePrintService.printString(body);
    }
}
