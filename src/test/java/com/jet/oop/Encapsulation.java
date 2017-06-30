package test.java.com.jet.oop;

/**
 *  封装属性：
 *  1.把属性设置为私有
 *  2.对外用标准的set/get方法修改读取属性的值<br>
 *
 * @author hanfajie (jet@xmjr.com)<br>
 * @since 9/2/16 9:55 AM<br>
 * <p/>
 * Copyright (c) 2016，2116 All Rights Reserved.
 * LICENSE INFORMATION
 */
public class Encapsulation
{
    public static void main(String args[]){
        //对象的多态性
        Person woman = new Woman();
        Person man = new Man(29,"david",(Woman) woman);
        System.out.println(man.getAge()+man.getName());
    }
}

class Person{
    //private是修饰符表示私有化，这就是封装了类的属性，封装后外部不能直接使用该属性
    private int age;
    private String name;

    //外部通过此方法访问name属性
    public String getName()
    {
        return name;
    }

    //该方法使外部赋值私有属性name变为可能
    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}

class Man extends Person{
    //private是修饰符表示私有化，这就是封装了类的属性，封装后外部不能直接使用该属性
    private int age;
    private String name;

    private Woman wife;

    Man(int age,String name,Woman wife){
        this.age = age;
        this.name = name;
        this.wife = wife;
    }

    //外部通过此方法访问name属性
    public String getName()
    {
        return name;
    }

    //该方法使外部赋值私有属性name变为可能
    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setWife(Woman wife)
    {
        this.wife = wife;
    }
}

class Woman extends Person{
    //private是修饰符表示私有化，这就是封装了类的属性，封装后外部不能直接使用该属性
    private int age;
    private String name;

    private Man husband;

    //外部通过此方法访问name属性
    public String getName()
    {
        return name;
    }

    //该方法使外部赋值私有属性name变为可能
    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Man getHusband()
    {
        return husband;
    }

    public void setHusband(Man husband)
    {
        this.husband = husband;
    }
}