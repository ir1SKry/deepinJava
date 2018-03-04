package com.ustbcafe.deepin.nio;

import com.ustbcafe.deepin.nio.codec.LengthBasedDecoder;
import com.ustbcafe.deepin.nio.handler.DiscardServerHandler;
import com.ustbcafe.deepin.nio.handler.LengthMessageServerHandler;
import com.ustbcafe.deepin.nio.handler.TimeServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * Created by Rudy Steiner on 2017/7/6.
 */
public class NettyServer {

    private int port;
    public NettyServer(int port){
        this.port=port;
    }
    public void run() throws Exception{
        EventLoopGroup bossGroup=new NioEventLoopGroup();
        EventLoopGroup workerGroup= new NioEventLoopGroup();
        try{
            ServerBootstrap b=new ServerBootstrap();
             b.group(bossGroup,workerGroup)
                     .channel(NioServerSocketChannel.class)
                     .childHandler(new ChildLengthMessageChannelHandler())
                     .option(ChannelOption.SO_BACKLOG,128)
                     .childOption(ChannelOption.SO_KEEPALIVE,true);
            ChannelFuture f=b.bind(port).sync();
            f.channel().closeFuture().sync();
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel>{
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(2014));
            socketChannel.pipeline().addLast(new StringDecoder());
            socketChannel.pipeline().addLast(new TimeServerHandler());
        }
    }
    private class ChildLengthMessageChannelHandler extends ChannelInitializer<SocketChannel>{
        private  final int MAX_FRAME_LENGTH=1024^2;
        private  final int LENGTH_FIELD_LENGTH=4;
        private  final int LENGTH_FIELD_OFFSET=1;
        private  final int LENGTH_ADJUSTMENT=0;
        private  final int INITIAL_BYTES_TO_STRIP=0;
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new LengthBasedDecoder(MAX_FRAME_LENGTH,LENGTH_FIELD_OFFSET,LENGTH_FIELD_LENGTH,LENGTH_ADJUSTMENT,INITIAL_BYTES_TO_STRIP,true));
            socketChannel.pipeline().addLast(new LengthMessageServerHandler());
        }
    }
    public static void main(String[] args) throws Exception{
//        String s = "我爱你,亲爱的";
//        byte[] b = s.getBytes("UTF-8");
//        String n = new String(b,"UTF-8");

//        byte[]  m="我爱你".getBytes("GBK");
//        ByteMessage msg=new ByteMessage((byte)1,m.length,m);

        int port;
        if(args.length>0){
            port=Integer.parseInt(args[0]);
        }else{
            port=8080;
        }
        new NettyServer(port).run();
    }
}
