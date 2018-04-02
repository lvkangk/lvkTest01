package DesignPattern.装饰器模式;

/**
 * @author: kangkang.lv
 * @date: 18-4-2 下午6:49
 */
public class RoomDecorator implements Land{

    Land land;

    public RoomDecorator(Land land) {
        this.land = land;
    }

    @Override
    public int cost() {
        return land.cost();
    }
}
