package designpatterns.proxy;

/**
 * @ClassName: SHLandLord
 * @description: 上海房东
 * @Author: Chao Xu
 * @Date: 2022/5/1 17:02
 **/
public class SHLandlord implements Landlord {

    @Override
    public void rentHouse() {
        System.out.println("上海房子已出租-收钱");
    }
}
