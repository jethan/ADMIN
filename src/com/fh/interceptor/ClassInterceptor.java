package com.fh.interceptor;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGlib 通过拦截器实现动态代理<br>
 *
 * @author hanfajie (jet@xmjr.com)<br>
 * @since 8/9/16 2:54 PM<br>
 * <p/>
 * Copyright (c) 2016，2116 All Rights Reserved.
 * LICENSE INFORMATION
 */
public class ClassInterceptor implements MethodInterceptor
{
    //这里Enhancer类是CGLib中的一个字节码增强器，它可以方便的对你想要处理的类进行扩展
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){

        //首先将被代理类clazz设置成父类
        enhancer.setSuperclass(clazz);
        //然后设置拦截器ClassInterceptor
        enhancer.setCallback(this);

        //通过字节码技术动态创建代理类实例
        return enhancer.create();
    }

    /**
     * 所有的方法都会被这个方法所拦截。该类实现了创建子类的方法与代理的方法。
     * getProxy(SuperClass.class)方法通过入参即父类的字节码，通过扩展父类的class来创建代理对象。
     * intercept()方法拦截所有目标类方法的调用，obj表示目标类的实例，method为目标类方法的反射对象，
     * args为方法的动态入参，proxy为代理类实例。
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args,
        MethodProxy methodproxy) throws Throwable {

        System.out.println("cglib实现的前置代理："+method);

        //通过代理类调用父类中的方法
        Object result = methodproxy.invokeSuper(obj, args);

        System.out.println("cglib实现的后置代理："+method);
        return result;
    }
}
