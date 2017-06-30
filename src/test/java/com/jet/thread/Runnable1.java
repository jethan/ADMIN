package test.java.com.jet.thread;

/**
 * 继承Thread类与实现Runnable接口 class<br>
 *
 * @author hanfajie (jet@xmjr.com)<br>
 * @since 8/23/16 12:17 PM<br>
 * <p/>
 * Copyright (c) 2016，2116 All Rights Reserved.
 * LICENSE INFORMATION
 */
public class Runnable1 implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("Runnable1实现了Runnable接口---------->>");
    }
}