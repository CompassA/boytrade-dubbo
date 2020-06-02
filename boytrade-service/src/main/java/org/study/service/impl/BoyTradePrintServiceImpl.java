package org.study.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.study.boytrade.test.BoyTradePrintService;

/**
 * @author fanqie
 * @date 2020/5/30
 */
@Service
public class BoyTradePrintServiceImpl implements BoyTradePrintService {

    @Override
    public String printString(String str) {
        return String.format("server echo: %s", str);
    }
}
