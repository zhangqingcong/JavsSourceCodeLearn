package com.itheima.d2_stream;

public class TopPerformer {
    private String name;
    private double money;

    public TopPerformer(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public TopPerformer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "TopPerformer{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
