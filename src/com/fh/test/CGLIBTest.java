package com.fh.test;

import com.fh.interceptor.CGLIBProxy;

/**
 * FIXME : Document this class<br>
 *
 * @author hanfajie (jet@xmjr.com)<br>
 * @since 8/9/16 5:28 PM<br>
 * <p/>
 * Copyright (c) 2016，2116,北京小马金融服务有限公司 All Rights Reserved.
 * LICENSE INFORMATION
 */
public class CGLIBTest
{
    /**
     * @param args
     */
    public static void main(String[] args) {

        CGLIBProxy proxy = new CGLIBProxy();

        //生成子类，创建代理类
        CGLIBUserServiceImpl impl = (CGLIBUserServiceImpl)proxy.getProxy(CGLIBUserServiceImpl.class);
        impl.sayHello();

    }
}
