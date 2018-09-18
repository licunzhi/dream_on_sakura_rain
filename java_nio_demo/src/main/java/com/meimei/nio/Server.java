package com.meimei.nio;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author licunzhi
 * @desc 服务段代码
 * @date 2018-09-17
 */
public class Server {
    public static void main(String[] args) {
        BioClient n = new BioClient();
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(n);
            t1.start();
        }
    }
}




class BioClient implements Runnable {

    @Override
    public void run() {

        try {
            Socket socket = new Socket("127.0.0.1", 8082);
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            String str = Thread.currentThread().getName() + "...........sadsadasJava";
            os.write(str.getBytes());
            StringBuffer sb = new StringBuffer();
            byte[] b = new byte[1024];
            int len;
            while ((len = is.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            is.close();
            os.close();
            socket.close();
            System.out.println(Thread.currentThread().getName() + " 写入完毕 " + new String(bos.toByteArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
