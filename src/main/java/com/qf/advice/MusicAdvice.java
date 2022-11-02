package com.qf.advice;

/**
 * @author yangl
 * @version 1.0
 * @date 2022/10/31 16:29
 *
 * 通知类，根据需要编写增强的代码
 */
public class MusicAdvice {

    public void after_returning(){
        System.out.println("后置通知，发生异常则不执行");
    }
}
