package com.geek.lambda;

/**
 * @author geek
 */
public class Demo00 {

    public static void main(String[] args) {
        // 传统模式下新线程的创建。
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threading..." + Thread.currentThread().getName());
            }
        }).start();

        // Lambda。
        new Thread(() -> System.out.println("threading..." + Thread.currentThread().getName())).start();
    }

}
