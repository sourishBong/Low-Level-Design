package com.demo;

import com.demo.dto.SingletonLogger;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        SingletonLogger singletonLogger=SingletonLogger.getInstance();

        singletonLogger.logDeposit("A1",84.00);
        singletonLogger.logDeposit("A2",60.00);
        singletonLogger.logDeposit("A1",50.00);
        singletonLogger.logWithdraw("A2",30.00);
        singletonLogger.logTransfer("A3","A1",20.00);
        singletonLogger.logWithdraw("A1",30.00);
        singletonLogger.logTransfer("A1","A2",10.00);
    }
}
