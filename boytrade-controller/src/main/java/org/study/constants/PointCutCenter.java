package org.study.constants;

/**
 * @author fanqie
 * Created on 2020.08.23
 */
public final class PointCutCenter {

    private PointCutCenter() {
    }

    public static final String HTTP_LOG = "execution(public * org.study.controller.*.*(..))";

    public static final String PRODUCT_CACHE =
            "execution(public * org.study.controller.ProductController.getProductInfo(..))";
}
