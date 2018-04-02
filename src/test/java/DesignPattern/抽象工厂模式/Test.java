package DesignPattern.抽象工厂模式;

import DesignPattern.抽象工厂模式.Factory.FactoryA;
import DesignPattern.抽象工厂模式.Product.IProduct;

/**
 * @author: kangkang.lv
 * @date: 17-2-17 下午3:29
 */
public class Test {
    @org.junit.Test
    public void test01(){
        IProduct product = new FactoryA().createProduct();
        product.sale();
    }
}
