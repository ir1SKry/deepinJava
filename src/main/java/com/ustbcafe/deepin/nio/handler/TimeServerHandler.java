package com.ustbcafe.deepin.nio.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * Created by Rudy Steiner on 2017/7/6.
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    private  int counter=0;
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
//       final ByteBuf time= ctx.alloc().buffer();
//                     time.writeInt((int) System.currentTimeMillis());
//                     ctx.writeAndFlush(time);
        System.out.println("server channel is active");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        String body=(String)msg;
        System.out.println("server receive:" + body + " the counter is:" + ++counter);
        String resp="Query time order".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():" bad order";
        resp+=resp+System.getProperty("line.separator");
        ByteBuf respByteBuf= Unpooled.copiedBuffer(resp.getBytes());
                ctx.writeAndFlush(respByteBuf);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }
}
