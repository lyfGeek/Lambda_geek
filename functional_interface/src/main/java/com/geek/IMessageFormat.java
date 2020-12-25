package com.geek;

/**
 * 消息传输格式化接口。
 *
 * @author geek
 */
@FunctionalInterface
public interface IMessageFormat {

    /**
     * 消息合法性验证。
     *
     * @param msg 要验证的消息。
     * @return 结果。
     */
    static boolean verifyMessage(String msg) {
        return msg != null;
    }

    /**
     * 消息转换方法。
     *
     * @param message 要转换的消息。
     * @param format  转换的格式[xml/json...]
     * @return 返回转换后的数据。
     */
    String format(String message, String format);

    // 自己定义的方法。
//    void test();
    // Multiple non-overriding abstract methods found in interface com.geek.IMessageFormat

    // 如果是 Object 的方法，编译通过。
    @Override
    String toString();

}
