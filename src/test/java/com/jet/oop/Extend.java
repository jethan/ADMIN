package test.java.com.jet.oop;

/**
 * 1. super关键字和this的用法相同
 * 2. this代表本类引用， super代表父类引用
 * 3. 当子类和父类出现同名成员的时候， 可以用super 和 this进行区分
 * 4. 子类重写父类的方法的访问权限要大于或者等于父类中被重写的方法
 * 5. 当子类中出现与父类一模一样的方法（返回值， 函数名， 形参）时， 会出现重写(Override)操作.
 * 6. 在对父类方法进行重写(Override)操作的时候，子类不允许出现与父类同名同参但是不同返回类型的方法.<br>
 *
 * @author hanfajie (jet@xmjr.com)<br>
 * @since 9/1/16 6:07 PM<br>
 * <p/>
 * Copyright (c) 2016，2116,北京小马金融服务有限公司 All Rights Reserved.
 * LICENSE INFORMATION
 */
public class Extend
{
    public static void main(String args[]){
        SubClass sc = new SubClass();
        //this代表本类引用， super代表父类引用
        sc.showMessage();
        // 当子类中出现与父类一模一样的方法（返回值， 函数名， 形参）时， 会出现重写(Override)操作1，2.
        //1.Override重写父类方法
        sc.speak();
        //2.重写覆盖父类方法
        sc.write();
        //子类复用父类方法
        sc.read();
    }
}

class SuperClass
{
    int i = 10;
    public void speak() {
        System.out.println("SuperClass： I am good~");
    }

    public void write() {
        System.out.println("SuperClass： I am writing~~~");
    }

    public void read() {
        System.out.println("SuperClass： I am reading~~~");
    }
}

class SubClass extends SuperClass
{
    int i = 20;

    public void showMessage() {
        System.out.printf("super.i = %d, this.i = %d\n", super.i, this.i);
    }

    //@Override表示下面出现的方法会出现重写操作，由编译器检查，如果达不到重写的条件，就会报错。一定程度上增加了代码的安全性和健壮性
    @Override
    public void speak() {
        super.speak();
        System.out.println("SubClass： I am excellent~~~");
    }

    public void write() {
        System.out.println("SubClass： I am writing~~~");
    }

}

