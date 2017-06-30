package test.java.com.jet.thread;

/**
 * 继承Thread类与实现Runnable接口<br>
 *
 * @author hanfajie (jet@xmjr.com)<br>
 * @since 8/23/16 12:18 PM<br>
 * <p/>
 * Copyright (c) 2016，2116 All Rights Reserved.
 * LICENSE INFORMATION
 */
public class ThreadTest
{
    public static void main(String args[]){
       _test3();
    }

    private static void _test1(){
        //②继承java.lang.Thread类，重写run()方法。
        Thread1 thread1 = new Thread1("thread1");
        thread1.start();
        try{
            Thread.sleep(2000);//主线程睡眠1秒钟,thread1仍然在执行，2秒后执行再顺序往下执行
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        //主线程睡眠10秒钟后结束thread1线程
        //t.interrupt(); //这种结束方式比较粗暴，如果thread1线程打开了某个资源还没来得及关闭也就是run方法还没有执行完就强制结束线程，会导致资源无法关闭
        //t.stop();也是结束某个线程，这种方式比interrupt()更粗暴
        //主线程睡眠10秒钟后结束thread1线程
        thread1.flag = false;
    }

    private static void _test2(){
        //①实现java.lang.Runnable接口，重写run()方法，启动：new Thread(this).start()。
        //最好使用实现接口方式，java中时单继承、多实现。
        Runnable1 runnable1 = new Runnable1();
        Thread thread = new Thread(runnable1);
        //开启线程,并不是一启动线程（调用start()方法）就执行这个线程，而是进入就绪状态，什么时候运行要看CPU。
        thread.start();
    }

    private static void _test3(){
        Thread1 thread3 = new Thread1("thread3");
        thread3.start();
        for (int i = 0; i < 2; i++) {
            System.out.println("我是main线程");
            if(i==10){
                try {
                    thread3.join();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        thread3.flag= false;
    }
}
