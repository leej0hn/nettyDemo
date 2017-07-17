package io.communet.nettyDemo.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by leejohn on 2017/7/17.
 */
public class TcpClient extends Thread {

    public static String HOST = "127.0.0.1";
    public static int PORT = 9999;

    @Override
    public void run() {
        super.run();

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap  = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new SimpleChatClientInitializer());
            Channel channel = bootstrap.connect(HOST, PORT).sync().channel();
            while(true){
                channel.writeAndFlush("this msg  test come from client" + "\r\n");
                Thread.currentThread();
                Thread.sleep(10000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception{
        //Netty 线程
        TcpClient client = new TcpClient();
        client.start();
    }
}
