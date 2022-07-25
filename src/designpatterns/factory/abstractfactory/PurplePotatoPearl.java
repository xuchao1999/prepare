package designpatterns.factory.abstractfactory;

/**
 * @ClassName: PurplePotatoPearl
 * @description: 紫薯珍珠
 * @Author: Chao Xu
 * @Date: 2022/4/13 10:56
 **/
public class PurplePotatoPearl implements Pearl {
    @Override
    public String getMaterial() {
        return "紫薯珍珠";
    }
}
