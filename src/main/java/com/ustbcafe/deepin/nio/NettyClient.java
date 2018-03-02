package com.ustbcafe.deepin.nio;

import com.ustbcafe.deepin.nio.handler.TimeClientHandler;
import com.ustbcafe.deepin.nio.handler.TimeServerHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * Created by Rudy Steiner on 2017/7/6.
 */
public class NettyClient {

    public static void main(String[] args) throws Exception{
        new NettyClient().run();
    }
    public void run() throws  Exception{
        String host="localhost";
        int port=8080;
        EventLoopGroup workGroup=new NioEventLoopGroup();
        try{
            Bootstrap b=new Bootstrap();
            b.group(workGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE,true);
            b.handler(new ChildChannelHandler());
            ChannelFuture f=b.connect(host,port).sync();
            f.channel().closeFuture().sync();
        }finally {
            workGroup.shutdownGracefully();
        }
    }
    private class ChildChannelHandler extends ChannelInitializer<SocketChannel>{
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(2014));
            socketChannel.pipeline().addLast(new StringDecoder());
            socketChannel.pipeline().addLast(new TimeClientHandler());
        }
    }
}
