package DesignPattern.抽象工厂模式.Factory;

import DesignPattern.抽象工厂模式.Product.IProduct;

/**
 * @author: kangkang.lv
 * @date: 17-2-17 下午3:25
 */
public interface IFactory {

    public IProduct createProduct();

}
