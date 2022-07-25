# 工厂模式
    “什么是工厂模式？我为什么要用？用了工厂模式对我有什么提升？”

灵魂三问，如果能回答这三个问题，直接关闭走人（最好可以点个赞再走 手动狗头）。下面让我们围绕这三个问题对工厂模式进行学习

## 1. 什么是工厂模式？
工厂模式是创建型模式中的一种，从字面意义理解，工厂就是生产产品的地方，我们消费者只要知道自己要买什么产品就行了，并不会去了解
他们的生产过程。相对应于我们的代码，工厂就是实例化对象的地方，我们在使用对象的时候并不需要知道对象的实例化过程。
所以非常好理解，工厂的主要作用是**将对象的创建和使用进行解耦**。

工厂模式有三种模式(以珍珠工厂为例)：
### 1.1 简单工厂模式
简单工厂顾名思义，这个工厂非常简单，他会根据客户端提供的类名来实例化对应的对象。

定义一个珍珠接口：
```java
public interface Pearl {
    String getMaterial();
}
```
红薯珍珠类：
```java
public class SweetPotatoPearl implements Pearl {
    @Override
    public String getMaterial() {
            return "红薯珍珠";
        }
}
```
紫薯珍珠类：
```java
public class PurplePotatoPearl implements Pearl {
    @Override
    public String getMaterial() {
            return "紫薯珍珠";
        }
}
```
珍珠工厂：
```java
public class PearlFactory {
    public static Pearl getPearl(String type){
        if(type.equals("sweet")){
            return new SweetPotatoPearl();
        }else if(type.equals("purple")){
            return new PurplePotatoPearl();
        }
        return null;
    }
}
```
做奶茶：
```java
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
        
        // 加红薯珍珠
        Pearl sweetPotatoPearl = PearlFactory.getPearl("sweet");
        System.out.println("红薯珍珠奶茶制作成功：" + milk + " + " + sweetPotatoPearl.getMaterial());
        
        // 加紫薯珍珠
        Pearl purplePotatoPearl = PearlFactory.getPearl("purple");
        System.out.println("紫薯珍珠奶茶制作成功：" + milk + " + " + purplePotatoPearl.getMaterial());
    }

    public static void main(String[] args) {
        makeMilTea();
    }
}
```
上面的代码我们在makeMilTea方法里把实例化珍珠的过程给隐藏了，起到了对象的创建和使用分离的目的。但是各位大神也注意到了
简单工厂是通过对象的名字来匹配到对应的对象，这样的话，如果我要增加一个土豆珍珠该怎么办呢？是不是得在工厂方法里面加一个
if-else了，这明显就不符合软件设计的**开闭原则**，那怎么办呢？看下面的工厂方法模式。
2. 工厂方法模式
工厂方法模式是为了解决简单工厂模式不符合的开闭原则。

怎么让工厂模式符合开闭原则呢？

我也不知道听谁说的，“任何问题都可以通过在外面包一成来解决，不行的话就包两层”。我们可以为每一种产品都有一个对应的工厂，
这样新增产品的时候就不用修改原来的工厂了，只需要添加一个新的工厂就行了。

Pearl接口、SweepPotatoPearl对象、PurperPotatoPearl对象与简单工厂一直

PearFactory
```java
public interface PearlFactory {
    Pearl getPearl();
}
```
SweetFactory
```java
public class SweetFactory implements PearlFactory {
    @Override
    public Pearl getPearl() {
        return new SweetPotatoPearl();
    }
}
```
PurperFacotry
```java
public class PurperFacotry implements PearlFactory {
    @Override
    public Pearl getPearl() {
        return new PurplePotatoPearl();
    }
}
```

MilkTea
```java
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
```
工厂方法模式的本质就是利用**依赖倒置原则**，将实例化产品的具体行为放置到了对应的工厂中，比如我们要新增一个B类型的珍珠的时候
并不需要去修改现有的工厂，只需要创建一个BFacotry就行，这就完美符合了开闭原则。

3. 抽象工厂模式
我们思考一下，一个工厂只生产一种产品是不是不太合适，红薯工厂就只能生产红薯珍珠？就不能生产红薯饼干？当然可以，我可以生产任何
跟红薯相关的东西，因为它的主要原材料是一样的，可以在同一个工厂生产，这样也不至于工厂越开越多了。这对应于我们代码可以理解为，当
需要实例化的类越来越多，用工厂方法来创建的化工厂也会同步增加，这加大了系统的复杂程度，也不利于系统的维护。抽象工厂就行将具有共性
的对象放在同一个工厂进行实例化。

比如现在有一个新的品类饼干，并且有红薯味饼干和紫薯味饼干，代码实现如下：

Cake:
```java
public interface Cake {
    String getCake();
}
```
SweetCake: 
```java
public class SweetCake implements Cake{
    @Override
    public String getCake() {
        return "红薯味饼干";
    }
}
```
PurperCake:
```java
public class PurperCake implements Cake{
    @Override
    public String getCake() {
        return "紫薯味饼干";
    }
}
```
PearFactory
```java
public interface PearlFactory {
    Pearl getPearl();
    Cake getCake();

}
```
SweetFactory
```java
public class SweetFactory implements PearlFactory {
    @Override
    public Pearl getPearl() {
        return new SweetPotatoPearl();
    }

    @Override
    public Cake getCake() {
        return new SweetCake();
    }            

}
```
PurperFacotry
```java
public class PurperFacotry implements PearlFactory {
    @Override
    public Pearl getPearl() {
        return new PurplePotatoPearl();
    }
    @Override
    public Cake getCake() {
        return new PurperCake();
    }
}
```

MilkTea
```java
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
```
抽象工厂就是将有共性的对象进行组合，形成一个产品簇。说已经题外话，DDD领域驱动设计中
聚合根的实例话就可以用到抽象工厂模式。如有不同意见欢迎一起交流。

# 我为什么要用工厂模式？
我在哪里用到哪个类就在哪里new出来喽，用什么工厂模式呢？


有这么一个场景，一个奶茶店他们奶茶用的珍珠是红薯做的，如下伪代码
```
public void makeMIlkTea(){
    // 1. 冲泡浓缩液
    // 2. 加红薯粉
    SweetPotato sp = new SweetPotato();
    // 3. ......
    最后奶茶完成
}
```
这个制作奶茶的过程不是很专业（是不是很像某飘飘的冲泡过程，原谅贫穷的我只能想到这种奶茶了）。当某一天一个专家
出来说吃红薯不健康，糖分太高容易变胖（可能不是只是红薯的问题），建议大家改吃紫薯。奶茶店只能紧急下架红薯珍珠，改为紫薯珍珠。那上面的代码要
怎么该呢？很简单嘛，把SweetPotato sp = new SweetPotato(); 改成PurplePotato不就行了，不错这确实是一个简单的思路。
搜先这个修改的方法不符合**开闭原则**（当然也不是一定要符合的，视情况而定，不能太教条主义）；其次，如果有成千上万的方法里面
用到了SweetPotato sp = new SweetPotato()这个语句，你就要修改成千上万个地方（可能又是一个不眠之夜了）。

万恶之源就是new SweetPotato()这行代码，如何把这行代码干掉呢？看上面的简单工厂模式就知道了，
我们把代码改成这样Pearl sweetPotatoPearl = PearlFactory.getPearl("sweet");行不行？眼尖的同学可能会喷我了，你这么该不还是要
需改入参吗？这不也不符合**开闭原则**吗？

我承认，这也不符合**开闭原则**，那要这么该才能符合呢？这里我们项目中的配置文件就可以发挥作用了，我们可以将PearlFactory.getPearl("sweet")中的
**“sweet”配置到配置文件不就行了，这样我们只要把配置文件中的 **sweet** 改成 **purper** 完美解决。

接下来是最后一个问题
# 用了工厂模式对我有什么提升？
1. 代码层面：让代码更清晰，功能更内聚，方便后期的扩展和维护
2. 个人层面：让自己写代码之前有更多的思考，对功能变化有一个提前的布局，提升自己的全局能力。