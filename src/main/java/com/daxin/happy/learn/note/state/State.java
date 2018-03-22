package com.daxin.happy.learn.note.state;

/**
 * Created by liuguangxin on 2018/3/21.
 */
public interface State {
	/**
	 *  执行状态的行为并同时更新状态
	 * @param vehicle
	 */
    void doStateAction(Vehicle vehicle);
}

class StartState implements State {

    @Override
    public void doStateAction(Vehicle vehicle) {
        System.out.println("汽车正在启动...");
        vehicle.setState(this);
    }
}

class RunningState implements State {

    @Override
    public void doStateAction(Vehicle vehicle) {
        System.out.println("汽车正在奔跑...");
        vehicle.setState(this);
    }
}

class StopState implements State {

    @Override
    public void doStateAction(Vehicle vehicle) {
        System.out.println("汽车正在停下...");
        vehicle.setState(this);
    }
}