package DesignPattern.抽象工厂模式.Product;

/**
 * @author: kangkang.lv
 * @date: 17-2-17 下午3:23
 */
public class ProductA implements IProduct {
    @Override
    public void sale() {
        System.out.println("ProductA 正在促销!");
    }
}
