package com.ustbcafe.deepin.nio.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * Created by Rudy Steiner on 2017/7/6.
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter{


    private int counter=0;
    private byte[] req;
    public TimeClientHandler(){
       this.req=("Query time order"+System.getProperty("line.separator")).getBytes();
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println("client channel is active");
        ByteBuf msg;
        for(int i=0;i<100;i++){
            msg=   Unpooled.buffer(req.length);
            msg.writeBytes(req);
            ctx.writeAndFlush(msg);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //super.channelRead(ctx, msg);
//        ByteBuf m = (ByteBuf) msg; // (1)
//        try {
//            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
//            System.out.println(new Date(currentTimeMillis));
//            ctx.close();
//        } finally {
//            m.release();
//        }
        String body=(String)msg;
        System.out.println("client receive:"+body+" the counter is:"+ ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }
}
