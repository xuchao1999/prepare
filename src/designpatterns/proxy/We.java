package designpatterns.proxy;

/**
 * @ClassName: We
 * @description: 我们这些社畜
 * @Author: Chao Xu
 * @Date: 2022/5/1 17:08
 **/
public class We {
    /*public static void main(String[] args) {
        // 1. 找中介
        Proxyer proxyer = new Proxyer();
        // 2. 租房
        proxyer.rentHouse();
    }*/

    public static void main(String[] args) {
        // 1. 上海--找中介
        Landlord shLandlord = new DynamicProxyeer(new SHLandlord());
        // 2. 租房
        shLandlord.rentHouse();

        // 1. 北京--找中介
        Landlord bjLandlord = new DynamicProxyeer(new BJLandlord());
        // 2. 租房
        bjLandlord.rentHouse();
    }
}
