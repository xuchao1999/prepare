package designpatterns.singleton;

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
