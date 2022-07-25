package designpatterns.factory.abstractfactory;


/**
 * @ClassName: SimpleFactory
 * @description: 珍珠工厂
 * @Author: Chao Xu
 * @Date: 2022/4/13 10:44
 **/
public interface PearlFactory {
    Pearl getPearl();

    Cake getCake();
}
