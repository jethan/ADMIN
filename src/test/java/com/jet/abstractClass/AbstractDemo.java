package test.java.com.jet.abstractClass;

/**
 * 抽象方法、抽象类和接口
 * 1.抽象类(类前有关键字stract)不一定含有抽象方法，但是含有抽象方法的类肯定是抽象类
 * 2.抽象类就是为了继承而存在的：
 * 对于一个父类，如果它的某个方法在父类中实现出来没有任何意义，必须根据子类的实际需求来进行不同的实现，
 * 那么就可以将这个方法声明为abstract方法，此时这个类也就成为abstract类了。
 * 1）抽象方法必须为public或者protected（因为如果为private，则不能被子类继承，子类便无法实现该方法），缺省情况下默认为public。
 * 2）抽象类不能用来创建对象；
 * 3）如果一个类继承于一个抽象类，则子类必须实现父类的抽象方法。如果子类没有实现父类的抽象方法，则必须将子类也定义为为abstract类。<br>
 *
 * @author hanfajie (jet@xmjr.com)<br>
 * @since 9/2/16 2:03 PM<br>
 * <p/>
 * Copyright (c) 2016，2116 All Rights Reserved.
 * LICENSE INFORMATION
 */
public class AbstractDemo
{

}

