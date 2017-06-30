package test.java.com.jet.thread;

/**
 * 继承Thread类与实现Runnable接口<br>
 *
 * @author hanfajie (jet@xmjr.com)<br>
 * @since 8/23/16 12:33 PM<br>
 * <p/>
 * Copyright (c) 2016，2116 All Rights Reserved.
 * LICENSE INFORMATION
 */
public class Thread1 extends Thread
{
    boolean flag = true;//用这种方式结束线程很不错，用一个变量控制run方法什么时候不再执行，不会出现run方法没有执行完毕就结束
    public Thread1(String name){
        super(name);
    }
    @Override
    public void run()//run方法一结束，整个线程就终止了
    {
        while(flag){
                System.out.println("I am "
                    + getName()+", that extends from Thread---------->>");
            try{
                sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
