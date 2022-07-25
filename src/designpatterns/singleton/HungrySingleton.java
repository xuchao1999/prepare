package designpatterns.singleton;

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
