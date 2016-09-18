package com.fh.test.design;

/**
 * FIXME : Document this class<br>
 *
 * @author hanfajie (jet@xmjr.com)<br>
 * @since 8/25/16 2:27 PM<br>
 * <p/>
 * Copyright (c) 2016，2116,北京小马金融服务有限公司 All Rights Reserved.
 * LICENSE INFORMATION
 */ //饿汉式
public class HungrySingle{
    private static Instance _instance = Instance.getSelf();
    private HungrySingle(){}
    public static Instance getInstance(){  return _instance;  }
}
