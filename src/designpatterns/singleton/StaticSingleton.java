package designpatterns.singleton;

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
