package designpatterns.factory.methods;


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

        PearlFactory sweetPearlFactory = new SweetFactory();

        // 加红薯珍珠
        Pearl sweetPotatoPearl = sweetPearlFactory.getPearl();
        System.out.println("红薯珍珠奶茶制作成功：" + milk + " + " + sweetPotatoPearl.getMaterial());
        
        // 加紫薯珍珠
        PearlFactory purperPearlFactory = new PurperFacotry();
        Pearl purplePotatoPearl = purperPearlFactory.getPearl();
        System.out.println("紫薯珍珠奶茶制作成功：" + milk + " + " + purplePotatoPearl.getMaterial());
    }

    public static void main(String[] args) {
        makeMilTea();
    }
}
