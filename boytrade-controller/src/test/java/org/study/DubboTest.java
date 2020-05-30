package org.study;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.study.controller.TestController;

/**
 * @author fanqie
 * @date 2020/5/30
 */
public class DubboTest extends BaseTest {

    @Autowired
    private TestController testController;

    @Test
    public void rpcConnectionTest() {
        Assert.assertEquals("server echo: hello world", testController.echoString("hello world"));
    }
}
