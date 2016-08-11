package com.fh.test;

import com.fh.interceptor.ClassHandler;
import com.fh.interceptor.ClassInterceptor;

import java.lang.reflect.Proxy;

/**
 * 动态代理测试类<br>
 *
 * @author hanfajie (jet@xmjr.com)<br>
 * @since 8/9/16 5:28 PM<br>
 * <p/>
 * Copyright (c) 2016，2116 All Rights Reserved.
 * LICENSE INFORMATION
 */
public class CGLIBTest
{
    public static void main(String[] args) {

        System.out.println("----------->>实现MethodInterceptor接口，设置动态代理");
        ClassInterceptor proxy1 = new ClassInterceptor();

        //生成子类，创建代理类
        CGLIBUserServiceImpl impl = (CGLIBUserServiceImpl)proxy1.getProxy(CGLIBUserServiceImpl.class);
        impl.sayHello();


        System.out.println("----------->>实现InvocationHandler接口，设置动态代理");
        //业务对象
        CGLIBUserService obj = new CGLIBUserServiceImpl();

        //目标对象
        ClassHandler classHandler = new ClassHandler(obj);

        //返回业务对象的代理对象
        CGLIBUserService proxy2 =(CGLIBUserService) Proxy.newProxyInstance(obj.getClass().getClassLoader(),
            obj.getClass().getInterfaces(), classHandler);

        //通过代理对象执行业务对象的方法
        proxy2.sayBye();

    }
}
