package com.daxin.happy.learn.note.command;

/**
 * Created by liuguangxin on 2018/3/22.
 */
public abstract class Command {

    abstract void execute();
}


class BuyStock extends Command {

    public Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}

class SellStock extends Command {
    public Stock stock;

    public SellStock(Stock stock) {

        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}


class StopStock extends Command {

    public Stock stock;

    public StopStock(Stock stock) {

        this.stock = stock;
    }

    @Override
    void execute() {

    }
}
