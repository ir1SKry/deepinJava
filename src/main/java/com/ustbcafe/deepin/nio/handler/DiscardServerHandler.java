package com.ustbcafe.deepin.nio.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by Rudy Steiner on 2017/7/6.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //super.channelRead(ctx, msg);
        //((ByteBuf)msg).release();
//        ByteBuf in=(ByteBuf) msg;
//        try{
//            while(in.isReadable()){
//                System.out.print((char)in.readByte());
//                System.out.flush();
//            }
//        }finally {
//            ReferenceCountUtil.release(msg);
//        }
        ctx.write(msg);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
       // super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }
}
