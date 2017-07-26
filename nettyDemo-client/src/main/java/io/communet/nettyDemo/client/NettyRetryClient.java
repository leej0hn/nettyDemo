package io.communet.nettyDemo.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by leejohn on 2017/7/17.
 */
public class NettyRetryClient extends Thread {

    public static String HOST = "192.168.0.19";
    public static int PORT = 9999;
    public static Channel channel;


    public void createBootstrap(Bootstrap bootstrap) {
        if (bootstrap != null) {
            try {
                EventLoopGroup eventLoop = new NioEventLoopGroup();
                bootstrap  = new Bootstrap()
                        .group(eventLoop)
                        .channel(NioSocketChannel.class)
                        .handler(new SimpleChatClientInitializer());
                channel = bootstrap.connect(HOST, PORT).sync().addListener(new ConnectionListener()).channel();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void run() {
        createBootstrap(new Bootstrap());
    }

    public static void main(String[] args){
        NettyRetryClient nettyClient = new NettyRetryClient();
        nettyClient.start();
    }
}
