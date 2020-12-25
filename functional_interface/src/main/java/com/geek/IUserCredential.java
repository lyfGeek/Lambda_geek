package com.geek;

/**
 * 用户身份认证标记接口。
 *
 * @author geek
 */
@FunctionalInterface
public interface IUserCredential {

    static String getCredential(String username) {
        if ("admin".equals(username)) {
            return "admin ~ 系统管理员";
        } else if ("manager".equals(username)) {
            return "manager ~ 用户管理员";
        } else {
            return "commons ~ 普通会员用户";
        }
    }

//    boolean test();
    // Multiple non-overriding abstract methods found in interface com.geek.IUserCredential

    /**
     * 通过用户账号，验证用户身份信息。
     *
     * @param username 要验证的用户账号。
     * @return 身份信息[系统管理员，用户管理员、普通用户。]
     */
    String verifyUser(String username);

}
