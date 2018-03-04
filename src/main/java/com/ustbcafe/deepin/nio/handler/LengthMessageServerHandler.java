package com.ustbcafe.deepin.nio.handler;

import com.ustbcafe.deepin.nio.ByteMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by Rudy Steiner on 2018/3/4.
 */
public class LengthMessageServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //super.channelRead(ctx, msg);
        if(msg instanceof ByteMessage){
            ByteMessage m=(ByteMessage)msg;
            System.out.println(m.toString());
        }
    }
}
