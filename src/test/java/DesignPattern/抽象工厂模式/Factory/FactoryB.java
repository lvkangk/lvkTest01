package DesignPattern.抽象工厂模式.Factory;

import DesignPattern.抽象工厂模式.Product.IProduct;
import DesignPattern.抽象工厂模式.Product.ProductB;

/**
 * @author: kangkang.lv
 * @date: 17-2-17 下午3:29
 */
public class FactoryB implements IFactory {
    @Override
    public IProduct createProduct() {
        return new ProductB();
    }
}
