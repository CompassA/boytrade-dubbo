package org.study.config;

/**
 * @author fanqie
 * @date 2020/5/30
 */
public final class ApiPath {

    private ApiPath() {
        throw new RuntimeException("illegal call!");
    }

    public final static class Test {

        public static final String ECHO = "/api/test/echo";

        private Test() { throw new RuntimeException("illegal call!"); }
    }

    public final static class Product {

        public static final String PRODUCT_INFO = "/api/product/info";

        private Product() { throw new RuntimeException("illegal call!");}
    }
}
