package com.sevenkey.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author weijianyu
 */
public class IoImServer {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        try {
            // 创建serverSocket
            ServerSocket server = new ServerSocket(8000);

            // 新建线程处理
            new Thread(() -> {
                while (true) {
                    try {
                        // 阻塞接受请求
                        Socket socket = server.accept();

                        // 新建线程处理
                        new Thread(() -> {
                            try {
                                int len;
                                byte[] data = new byte[1024];
                                InputStream input = socket.getInputStream();

                                while ((len = input.read(data)) != -1) {
                                    // 读取输出
                                    System.out.println(new String(data, 0, len));
                                }
                            } catch (IOException e) {
                                System.out.println("InputStream异常");
                            }

                        }).start();
                    } catch (IOException e) {
                        System.out.println("server阻塞接受socket异常");
                    }
                }
            }).start();

        } catch (IOException e) {
            System.out.println("创建serverSocket异常");
        }
    }
}
