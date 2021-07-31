package com.sdut.case02;

public class Test02 {
    public static void main(String[] args) {
        Account account = new Account(100,"不义之财");

        WithdrawMoney withdrawMoney =
                new WithdrawMoney(account,50,"自己");
        WithdrawMoney withdrawMoney1 =
                new WithdrawMoney(account,100,"同伙");

        new Thread(withdrawMoney).start();
        new Thread(withdrawMoney1).start();
    }
}
