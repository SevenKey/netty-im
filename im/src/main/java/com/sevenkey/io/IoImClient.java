package com.sevenkey.io;

import java.net.Socket;
import java.util.Date;

/**
 * @author weijianyu
 */
public class IoImClient {

    @SuppressWarnings("all")
    public static void main(String[] args) {

        new Thread(()->{
            try {
                Socket socket = new Socket("127.0.0.1", 8000);

                while (true) {
                    socket.getOutputStream().write((new Date() + " : hello world!").getBytes());
                    Thread.sleep(2000);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }
}
