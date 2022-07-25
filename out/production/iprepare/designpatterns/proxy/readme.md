# 代理模式
    “什么时代理模式？我为什么要用代理模式？”
## 什么时代理模式？
    “为其他对象提供一种代理以控制对这个对象的访问”
 从定义出发好像还是很模糊，举个例子：社畜们进入社会第一步就是租房子（说不是的拉出去枪毙19次），我们大部分人租房子找的都是中介，
 因为房东不想直接跟租户直接对线，太繁琐，所以就出点中介费，让中介代理自己把房子出租出去。我们就可以跟中介进行n轮讨价还价了（一般都以我们缴械投降告一段落）。
 “中介”就是房东的”代理“，房东的职责很明确，就是把房子租出去，中介的功能除了把房子租给我们，还有一个功能就是应对我们的讨价还价。
 因此可以说”中介“代理了”房东“，并扩展了功能。
 所以代理模式就是：为一个对象提供一个代理对象，并且代理对象可以扩展被代理对象的功能。
 
 代理模式分三种：
 1. 静态代理：代理与某一个确定的接口
 
 2. 动态代理：通过反射代理一类接口
 
 3. cglib代理：通过反射代理一类对象
 
 ### 静态代理
 
 
 房东接口
```java
/**
 * @Author Chao Xu
 * @Description 房东接口
 * @Date 17:00 2022/5/1
 **/
public interface Landlord {
    void rentHouse();
}
```


上海房东对象
```java
/**
 * @ClassName: SHLandLord
 * @description: 上海房东
 * @Author: Chao Xu
 * @Date: 2022/5/1 17:02
 **/
public class SHLandlord implements Landlord {

    @Override
    public void rentHouse() {
        System.out.println("房子已出租-收钱");
    }
}
```


中介对象
```java
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
```
我们怎么租房呢？
```java
/**
 * @ClassName: We
 * @description: 我们这些社畜
 * @Author: Chao Xu
 * @Date: 2022/5/1 17:08
 **/
public class We {
    public static void main(String[] args) {
        // 1. 找中介
        Proxyer proxyer = new Proxyer();
        // 2. 租房
        proxyer.rentHouse();
    }
}
```

 上面就是简单的静态代理的实现逻辑。
 
 ### 动态代理
 我什么要用动态代理？其实从静态代理的实现逻辑会发现有一个问题，每一个中介只能代理一个房东，当房东越来越多，代理的中介也会越来越多，
 但是中介干实现的功能都是相似的，所以一个中介代理多个房东这是非常正常的情况。因此动态代理就解决了这个问题。
 
 新增加一个北京房东
 ```java
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
```

动态代理类--高级中介（可以出租全国各地的房子）
```java
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
```

我们在上海或者北京的同学都可以找这个中介租房了
```java
/**
 * @ClassName: We
 * @description: 我们这些社畜
 * @Author: Chao Xu
 * @Date: 2022/5/1 17:08
 **/
public class We {
    
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
```
 