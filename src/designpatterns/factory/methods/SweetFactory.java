package designpatterns.factory.methods;

/**
 * @ClassName: SweetFactory
 * @description: todo
 * @Author: Chao Xu
 * @Date: 2022/4/14 11:16
 **/
public class SweetFactory implements PearlFactory {
    @Override
    public Pearl getPearl() {
        return new SweetPotatoPearl();
    }
}
