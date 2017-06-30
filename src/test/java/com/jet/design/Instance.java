package test.java.com.jet.design;

/**
 * 单例模式<br>
 *
 * @author hanfajie (jet@xmjr.com)<br>
 * @since 8/25/16 1:30 PM<br>
 * <p/>
 * Copyright (c) 2016，2116 All Rights Reserved.
 * LICENSE INFORMATION
 */
public class Instance
{
    private Instance(){}
    public static Instance getSelf(){  return new Instance();  }
}

