package com.geek;

/**
 * @author geek
 */
public class App5 {

    public static void main(String[] args) {
        App5 app = new App5();
        app.lambdaMethod(new Param1() {
            @Override
            public void outInfo(String info) {
                System.out.println(info);
            }
        });

        app.lambdaMethod(new Param2() {
            @Override
            public void outInfo(String info) {
                System.out.println(info);
            }
        });

        /*
        Lambda 表达式存在类型检查 ->自动推到 Lambda 表达式的目标类型。
        lambdaMethod(); 方法是重载方法。
            => Param1 函数式接口。
            => Param2 函数式接口。
            调用方法 => 传递 Lambda 表达式 => 自动推导
                => Param1 | Param2
         */
        // Ambiguous method call.
        // Both lambdaMethod (Param1) in App5
        // and lambdaMethod (Param2) in App5 match
//        app.lambdaMethod((String info) -> {
//            System.out.println(info);
//        });
    }

    // 重载方法。
    public void lambdaMethod(Param1 param) {
        param.outInfo("hello, param1.");
    }

    public void lambdaMethod(Param2 param) {
        param.outInfo("hello, param2.");
    }

    interface Param1 {
        void outInfo(String info);
    }

    interface Param2 {
        void outInfo(String info);
    }

}
