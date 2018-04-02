package DesignPattern.抽象工厂模式.Product;

/**
 * @author: kangkang.lv
 * @date: 17-2-17 下午3:24
 */
public class ProductB implements IProduct {
    @Override
    public void sale() {
        System.out.println("ProductB 正在促销!");
    }
}
