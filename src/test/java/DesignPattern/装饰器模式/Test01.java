package DesignPattern.装饰器模式;

import org.junit.Test;

/**
 * @author: kangkang.lv
 * @date: 18-4-2 下午6:48
 */
public class Test01 {

    /**
     * 参考https://segmentfault.com/a/1190000011230771
     */
    @Test
    public void test01(){
        Room room = new Room();
        LivingRoom livingRoom = new LivingRoom(room);
        System.out.println("livingRoom cost: "+livingRoom.cost());
        DiningRoom diningRoom = new DiningRoom(room);
        System.out.println("diningRoom cost: "+diningRoom.cost());

        DiningRoom ld = new DiningRoom(livingRoom);
        System.out.println("livingRoom add diningRoom cost: "+ld.cost());

    }
}
