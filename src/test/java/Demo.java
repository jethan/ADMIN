package test.java;

import test.java.com.jet.design.HungrySingle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

/**
 * FIXME : Document this class<br>
 *
 * @author hanfajie (jet@xmjr.com)<br>
 * @since 8/23/16 9:41 AM<br>l
 * <p/>
 * Copyright (c) 2016，2116 All Rights Reserved.
 * LICENSE INFORMATION
 */
public class Demo
{
    public static void main(String args[]){

        Map hashtable = new Hashtable();
        Map hashMap = new HashMap();
        Map treeMap = new TreeMap();
        List list = new ArrayList<>();
        Vector vector = new Vector<>();
        HashSet hashSet = new HashSet();
        Set set = new HashSet();
        System.out.println(set.add(1));
        System.out.println(set.add(1));
        Set treeSet = new TreeSet();
        HungrySingle.getInstance();
        Iterator iterator = hashMap.entrySet().iterator();
        Map resultMap = new HashMap();
        String key;
        String value;
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
        }
        System.out.println();
    }
}
