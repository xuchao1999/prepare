package designpatterns.proxy;

/**
 * @ClassName: BJLandlord
 * @description: 北京房东
 * @Author: Chao Xu
 * @Date: 2022/5/1 17:27
 **/
public class BJLandlord implements Landlord {
    @Override
    public void rentHouse() {
        System.out.println("北京房子已出租-收钱");
    }
}
