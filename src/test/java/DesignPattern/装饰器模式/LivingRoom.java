package DesignPattern.装饰器模式;

/**
 * @author: kangkang.lv
 * @date: 18-4-2 下午6:52
 */
public class LivingRoom extends RoomDecorator {

    public LivingRoom(Land land) {
        super(land);
    }

    @Override
    public int cost() {
        return this.land.cost()+200;
    }

}
