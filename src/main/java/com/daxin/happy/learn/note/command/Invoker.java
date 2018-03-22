package com.daxin.happy.learn.note.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuguangxin on 2018/3/22.
 */
public class Invoker {
    List<Command> commands = new ArrayList<>();

    public void appendCommand(Command cmd) {
        commands.add(cmd);
    }

    public void invokeCommand() {


        for (Command cmd : commands) {
            cmd.execute();
        }
    }

}
