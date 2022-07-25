package designpatterns.factory.abstractfactory;


/**
 * @ClassName: MilkTea
 * @description: 奶茶
 * @Author: Chao Xu
 * @Date: 2022/4/13 11:14
 **/
public class MilkTea {
    /**
     * @Author Chao Xu
     * @Description 制作奶茶
     * @Date 11:15 2022/4/13
     * @Param []
     * @return void
     **/
    public static void makeMilTea(){
        
        
        // 1. 冲泡奶粉
        String milk = "冲泡奶茶";

        PearlFactory sweetFactory = new SweetFactory();

        // 加红薯珍珠
        Pearl sweetPotatoPearl = sweetFactory.getPearl();
        System.out.println("红薯珍珠奶茶制作成功：" + milk + " + " + sweetPotatoPearl.getMaterial());
        // 点一个红薯饼干
        System.out.println(sweetFactory.getCake());
        
        // 加紫薯珍珠
        PearlFactory purperFactory = new PurperFacotry();
        Pearl purplePotatoPearl = purperFactory.getPearl();
        System.out.println("紫薯珍珠奶茶制作成功：" + milk + " + " + purplePotatoPearl.getMaterial());
        // 点一个紫薯饼干
        System.out.println(purperFactory.getCake());

    }

    public static void main(String[] args) {
        makeMilTea();
    }
}
