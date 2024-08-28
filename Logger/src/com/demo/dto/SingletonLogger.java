package com.demo.dto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SingletonLogger {

    private static SingletonLogger singletonLogger=null;

    private final String filename="log.txt";
    private PrintWriter pw;

    private SingletonLogger() throws IOException {
        FileWriter fw=new FileWriter(filename);
        pw=new PrintWriter(fw,true);
    }

    public static SingletonLogger getInstance() throws IOException {
        if(singletonLogger==null){
            synchronized (SingletonLogger.class) {
                if (singletonLogger == null) {
                    singletonLogger = new SingletonLogger();
                }
            }
        }
        return singletonLogger;
    }

    public void logWithdraw(String account, Double amount){
        pw.println("Withdrawn from ("+account+"):"+amount);
    }

    public void logDeposit(String account, Double amount){
        pw.println("Deposited to ("+account+"):"+amount);
    }

    public void logTransfer(String sender,String receiver,Double amount){
        pw.println(amount+" is sent by "+sender+" to "+receiver);
    }
}
