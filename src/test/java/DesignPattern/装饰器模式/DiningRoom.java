package DesignPattern.装饰器模式;

/**
 * @author: kangkang.lv
 * @date: 18-4-2 下午7:00
 */
public class DiningRoom extends RoomDecorator {
    public DiningRoom(Land land) {
        super(land);
    }

    @Override
    public int cost() {
        return super.cost()+300;
    }
}
