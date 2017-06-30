package com.jet.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * java.lang.reflect.Proxy,
   Proxy 提供用于创建动态代理类和实例的静态方法.
   newProxyInstance() 返回一个指定接口的代理类实例，该接口可以将方法调用指派到指定的调用处理程序
   java.lang.reflect.InvocationHandler,
   InvocationHandler 是代理实例的调用处理程序 实现的接口。
   invoke() 在代理实例上处理方法调用并返回结果。在与方法关联的代理实例上调用方法时，将在调用处理程序上调用此方法。<br>
 *
 * @author hanfajie (jet@xmjr.com)<br>
 * @since 8/11/16 1:12 PM<br>
 * <p/>
 * Copyright (c) 2016，2116 All Rights Reserved.
 * LICENSE INFORMATION
 */
public class ClassHandler implements InvocationHandler
{
    //目标对象
    private Object targetObject;

    public ClassHandler(Object targetObject){
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println("cglib实现的前置代理："+method);

        //通过代理类调用父类中的方法
        Object result = method.invoke(this.targetObject, args);

        System.out.println("cglib实现的后置代理："+method);

        return result;
    }
}
