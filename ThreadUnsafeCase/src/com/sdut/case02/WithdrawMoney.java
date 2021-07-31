package com.sdut.case02;

//模拟银行
public class WithdrawMoney extends Thread {
    Account account;
    //取了多少钱
    int drawmoney;
    //手里有多少钱
    int nowmoney;

    @Override
    public void run() {

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

    public WithdrawMoney (Account account, int drawmoney,String name){
        super(name);
        this.account = account;
        this.drawmoney = drawmoney;
    }
}
