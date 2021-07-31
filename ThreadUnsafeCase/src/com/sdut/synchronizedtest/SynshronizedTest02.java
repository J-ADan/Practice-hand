package com.sdut.synchronizedtest;

public class SynshronizedTest02 extends Thread{
    Account account;
    //取了多少钱
    int drawmoney;
    //手里有多少钱
    int nowmoney;

    @Override
    public void run() {

        //synchronized 代码块，
        synchronized (account){
            if (account.getMoney() - drawmoney < 0){
                System.out.println("超出余额" + this.getName());
                //this.getName() == Thread.currentThread().getName()
                return;
            }

            try {
                //模拟延迟，放大问题的发生性
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.setMoney(account.getMoney() - drawmoney);
            nowmoney = nowmoney + drawmoney;

            System.out.println(this.getName() + "手里的钱为：" + nowmoney);
            System.out.println(account.getName() + "余额为：" + account.getMoney());
        }

    }

    public SynshronizedTest02 (Account account, int drawmoney,String name){
        super(name);
        this.account = account;
        this.drawmoney = drawmoney;
    }
}

class Test02 {
    public static void main(String[] args) {
        Account account = new Account(100,"不义之财");

        SynshronizedTest02 withdrawMoney =
                new SynshronizedTest02(account,50,"自己");
        SynshronizedTest02 withdrawMoney1 =
                new SynshronizedTest02(account,100,"同伙");

        new Thread(withdrawMoney).start();
        new Thread(withdrawMoney1).start();
    }
}

class Account {
    private int money;
    private String name;

    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }
}
