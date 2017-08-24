package com.ustbcafe.deepin.nio;

import com.ustbcafe.deepin.nio.handler.TimeClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by Rudy Steiner on 2017/7/6.
 */
public class NettyClient {

    public static void main(String[] args) throws Exception{
        String host="localhost";
        int port=8080;
        EventLoopGroup workGroup=new NioEventLoopGroup();
        try{
            Bootstrap b=new Bootstrap();
            b.group(workGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE,true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeDecoder(),new TimeClientHandler());
                }
            });
            ChannelFuture f=b.connect(host,port).sync();
            f.channel().closeFuture().sync();
        }finally {
            workGroup.shutdownGracefully();
        }
    }
}
