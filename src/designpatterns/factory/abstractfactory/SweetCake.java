package designpatterns.factory.abstractfactory;

/**
 * @ClassName: SweetCake
 * @description: todo
 * @Author: Chao Xu
 * @Date: 2022/4/14 12:15
 **/
public class SweetCake implements Cake{
    @Override
    public String getCake() {
        return "红薯味饼干";
    }
}
