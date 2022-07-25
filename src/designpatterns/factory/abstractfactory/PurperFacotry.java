package designpatterns.factory.abstractfactory;


/**
 * @ClassName: PurperFacotry
 * @description: todo
 * @Author: Chao Xu
 * @Date: 2022/4/14 11:15
 **/
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
