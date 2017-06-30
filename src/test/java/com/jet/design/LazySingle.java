package test.java.com.jet.design;

/**
 * FIXME : Document this class<br>
 *
 * @author hanfajie (jet@xmjr.com)<br>
 * @since 8/25/16 2:27 PM<br>
 * <p/>
 * Copyright (c) 2016，2116,北京小马金融服务有限公司 All Rights Reserved.
 * LICENSE INFORMATION
 */ //懒汉式
public class LazySingle{
    private static  Instance it = null;
    private LazySingle(){}
    public static Instance getInstance(){
        if(it==null){
            synchronized(LazySingle.class){  it = Instance.getSelf();  }
        }
        return it;
    }
}
