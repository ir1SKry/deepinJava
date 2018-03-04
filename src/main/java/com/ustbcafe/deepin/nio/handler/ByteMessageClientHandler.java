package com.ustbcafe.deepin.nio.handler;

import com.ustbcafe.deepin.nio.ByteMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

/**
 * Created by Rudy Steiner on 2018/3/4.
 */
public class ByteMessageClientHandler extends ChannelInboundHandlerAdapter{
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
            byte[]  m="我爱你".getBytes("GBK");
        ByteMessage msg=new ByteMessage((byte)1,m.length,m);
        ctx.writeAndFlush(msg);
    }
}
