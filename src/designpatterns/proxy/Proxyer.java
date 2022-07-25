package designpatterns.proxy;

/**
 * @ClassName: Proxyer
 * @description: 中介
 * @Author: Chao Xu
 * @Date: 2022/5/1 17:04
 **/
public class Proxyer implements Landlord {

    private SHLandlord shLandlord = new SHLandlord();

    @Override
    public void rentHouse() {
        System.out.println("发布出租信息");
        System.out.println("带客户看房子");
        System.out.println("讨价还价");
        System.out.println("签合同");
        shLandlord.rentHouse();
    }
}
