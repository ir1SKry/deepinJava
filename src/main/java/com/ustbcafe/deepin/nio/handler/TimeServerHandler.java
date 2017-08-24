package com.ustbcafe.deepin.nio.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by Rudy Steiner on 2017/7/6.
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
       // super.channelRead(ctx, msg);
//        final ByteBuf time=ctx.alloc().buffer();
//        time.writeInt((int) System.currentTimeMillis());
//         final ChannelFuture f=ctx.writeAndFlush(time);
//          f.addListener(new ChannelFutureListener() {
//              @Override
//              public void operationComplete(ChannelFuture future) throws Exception {
//                    assert  f==future;
//                    ctx.close();
//              }
//          });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }
}
