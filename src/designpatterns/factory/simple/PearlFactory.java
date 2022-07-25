package designpatterns.factory.simple;

/**
 * @ClassName: SimpleFactory
 * @description: 珍珠工厂
 * @Author: Chao Xu
 * @Date: 2022/4/13 10:44
 **/
public class PearlFactory {
    public static Pearl getPearl(String type){
        if(type.equals("sweet")){
            return new SweetPotatoPearl();
        }else if(type.equals("purple")){
            return new PurplePotatoPearl();
        }
        return null;
    }
}
