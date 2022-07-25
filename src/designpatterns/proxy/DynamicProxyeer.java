package designpatterns.proxy;

/**
 * @ClassName: DynamicProxyeer
 * @description: 动态代理（高级中介）
 * @Author: Chao Xu
 * @Date: 2022/5/1 17:23
 **/
public class DynamicProxyeer implements Landlord {
    private Landlord landlord;

    public DynamicProxyeer(Landlord landlord){
        this.landlord = landlord;
    }

    @Override
    public void rentHouse() {
        System.out.println("发布出租信息");
        System.out.println("带客户看房子");
        System.out.println("讨价还价");
        System.out.println("签合同");
        this.landlord.rentHouse();
    }
}
