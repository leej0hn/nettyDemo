package io.communet.nettyDemo.client;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

/**
 * Created by LeeJohn on 2017/7/26.
 */

public class ConnectionListener implements ChannelFutureListener {


    @Override
    public void operationComplete(ChannelFuture channelFuture) throws Exception {
        if (!channelFuture.isSuccess()) {
            System.out.println(" ConnectionListener --- Reconnect");
            NettyRetryClient client = new NettyRetryClient();
            client.start();
        }
    }

}
