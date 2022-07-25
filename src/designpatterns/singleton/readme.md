# 单例模式
    “什么是单例模式？为什么要用单例模式？”
日常问题，有人可以回答吗？扪心自问单例模式在日常开发任务中我确实没有用过，没用过就说明这个模式就是鸡肋，就是没用的设计吗？
当然不是，这只能说我现在还是菜鸟，接触的项目太少或者在某些该用单例的地方没有用。下面我们一起学习一下单例模式。

## 什么是单例模式？
    单例模式是最简单的设计模式，他的作用就是实例化一个对象，并且确保这个对象只能被实例化一次。
1. 懒汉模式（线程不安全）
```java
/**
 * @ClassName: LazySingleton
 * @description: 懒汉模式
 * @Author: Chao Xu
 * @Date: 2022/4/22 17:10
 **/
public class LazySingleton {
    // 线程不安全
    private LazySingleton(){}
    private static LazySingleton lazySingleton = null;
    public static LazySingleton getInstance(){
        if(lazySingleton == null){
            return new LazySingleton();
        }
        return lazySingleton;
    }

    // 线程安全
    public synchronized LazySingleton getInstance1(){
        if(this.lazySingleton == null){
            return new LazySingleton();
        }
        return lazySingleton;
    }

    // 双重检验锁
    public static LazySingleton getInstance2(){
        if(lazySingleton == null){
            synchronized (LazySingleton.class){
                if(lazySingleton == null){
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }
}
```

饿汉模式
```java
/**
 * @ClassName: HungrySingleton
 * @description: 饿汉模式
 * @Author: Chao Xu
 * @Date: 2022/4/22 17:15
 **/
public class HungrySingleton {
    private HungrySingleton(){}
    private static HungrySingleton hungrySingleton = new HungrySingleton();
    private static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
```

静态类单例

为什么静态类可以实现全局只实例化一次呢？这就要熟悉jvm存储结构了，静态内部类对象在jvm中只会存在一个在方法区中。
```java
/**
 * @ClassName: StaticSingleton
 * @description: 静态类模式
 * @Author: Chao Xu
 * @Date: 2022/4/23 15:23
 **/
public class StaticSingleton {
    private StaticSingleton(){}
    public static class singleton{
        private static StaticSingleton staticSingleton = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return singleton.staticSingleton;
    }
}
```


枚举单例

原理类似于静态内部类。
```java
/**
 * @Author Chao Xu
 * @Description 枚举单例
 * @Date 15:30 2022/4/23
 * @Param
 * @return
 **/
public enum EnumSingleton {
    SINGLETON;
}
```

## 为什么要用单例模式？

其实在我们平时的生活中有很多场景跟单例模式是非常匹配的，比如：比如我们现在有一个停车场实时车位更新系统，我们如何去设计？
当有多线程的情况去更新车位的话我们该怎么实现？这个停车场就应该设计成一个单例，整个系统中只能对同一个停车厂进行更新车位信息，
不然的话，可能会出现不同的线程获取到的停车位信息是不一致的。

设计模式其实都是源于我们的现实生活，我们平时应该有意识地训练自己的去使用设计模式去优化我们的代码。

