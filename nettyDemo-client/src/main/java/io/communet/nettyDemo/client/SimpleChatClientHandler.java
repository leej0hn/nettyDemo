package io.communet.nettyDemo.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by leejohn on 2017/7/17.
 */
public class SimpleChatClientHandler extends SimpleChannelInboundHandler<String> {

    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {

        System.out.println("---------------channelRead0 have received : " + s + "  ");
    }
}
