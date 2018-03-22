package com.daxin.happy.learn.note.state;

/**
 * Created by liuguangxin on 2018/3/21.
 * 激动车类
 */
public abstract class Vehicle {

    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

/**
 * 大众汽车
 */
class Volkswagen extends Vehicle {

}