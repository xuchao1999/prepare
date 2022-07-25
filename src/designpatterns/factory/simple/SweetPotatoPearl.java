package designpatterns.factory.simple;

/**
 * @ClassName: SweetPotatoPearl
 * @description: 红薯珍珠
 * @Author: Chao Xu
 * @Date: 2022/4/13 10:54
 **/
public class SweetPotatoPearl implements Pearl {
    @Override
    public String getMaterial() {
        return "红薯珍珠";
    }
}
