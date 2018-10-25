package com.test.examples;

import com.test.examples.utils.Reciver;
import com.test.examples.utils.Sender;

public class App {

    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        sender.createTask();
        Thread.sleep(3000);
        Reciver reciver = new Reciver();
        reciver.createRecieveTask();
    }
}
