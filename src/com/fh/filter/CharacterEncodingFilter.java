package com.fh.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 没引入spring配置文件时，怎么实现JDK动态代理
 * 情景介绍：如何解决全站中文乱码问题?<br>
 *
 * @author hanfajie (hanfajie@xmjr.com)<br>
 * @since 8/9/16 2:33 PM<br>
 * <p/>
 * Copyright (c) 2016，2116 All Rights Reserved.
 * LICENSE INFORMATION
 */
public class CharacterEncodingFilter implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        // FIXME : Implement!

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException
    {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");	//只能解决Post方式提交的乱码问题，无法解决get提交的乱码

        //可以用包装设计模式，也可以用动态代理技术来解决get请求的乱码问题

        filterChain.doFilter((ServletRequest) Proxy.newProxyInstance(CharacterEncodingFilter.class.getClassLoader()
            , request.getClass().getInterfaces()
            , new InvocationHandler()
        {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable
            {
                //proxy表示：动态代理对象
                //method表示：需要代理的方法
                //args表示需要代理方法的参数
                if (!method.getName().equals("getParameter"))
                {
                    return method.invoke(request, args);
                }
                if (!request.getMethod().equalsIgnoreCase("get"))
                {
                    return method.invoke(request, args);
                }
                //满足要拦截处理的条件了
                String value = (String) method.invoke(request, args);
                if (value == null)
                {
                    return null;
                }
                return new String(value.getBytes("iso8859-1"), "UTF-8");
            }
        }), response);

    }

    @Override
    public void destroy()
    {
        // FIXME : Implement!

    }
}
