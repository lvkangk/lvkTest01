package Model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author: kangkang.lv
 * @date: 17-11-2 下午4:11
 */
public class LvKang implements Serializable{

    public int age;
    public int height;
    public int weight;

    public LvKang(int age, int height, int weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "LvKang{" +
                "age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

}
