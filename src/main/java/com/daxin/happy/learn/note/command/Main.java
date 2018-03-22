package com.daxin.happy.learn.note.command;

/**
 * Created by liuguangxin on 2018/3/22.
 */
public class Main {

    public static void main(String[] args) {

        Stock stock = new Stock();
        stock.stockName = "apple";
        Invoker invoker = new Invoker();
        //TODO 命令
        BuyStock buy = new BuyStock(stock);
        //TODO 命令
        SellStock sell = new SellStock(stock);
        //TODO 追加命令
        invoker.appendCommand(buy);
        invoker.appendCommand(sell);
        //TODO 执行命令
        invoker.invokeCommand();

    }
}
