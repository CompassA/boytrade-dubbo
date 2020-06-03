package org.study.util;

/**
 * @author fanqie
 * @date 2020/6/2
 */
public final class RedisKeyCenter {

    private RedisKeyCenter() { throw new RuntimeException("illegal call!"); }

    public static String getProductInfoKey(int id) {
        return "btd:product:info:" + id;
    }
}
