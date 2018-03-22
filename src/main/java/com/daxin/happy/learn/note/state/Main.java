package com.daxin.happy.learn.note.state;

/**
 * Created by liuguangxin on 2018/3/21.
 */
public class Main {

	public static void main(String[] args) {

		Volkswagen volkswagen = new Volkswagen();

		StartState startState = new StartState();
		startState.doStateAction(volkswagen);
		RunningState runningState = new RunningState();
		runningState.doStateAction(volkswagen);
		StopState stopState = new StopState();
		stopState.doStateAction(volkswagen);
	}

}
