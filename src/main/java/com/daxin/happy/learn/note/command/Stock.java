package com.daxin.happy.learn.note.command;

/**
 * Created by liuguangxin on 2018/3/22.
 * 有时间使用画板的业务实现一下命令行模式
 */
public class Stock {
    public String stockName;

    public void sell() {
        System.out.println(stockName + "   is selling .");
    }

    public void buy() {
        System.out.println(stockName + "   is buying .");
    }

    public void stop() {
        System.out.println(stockName + "   is stopping .");
    }
}
