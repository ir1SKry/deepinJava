package com.ustbcafe.deepin.nio.codec;

import com.ustbcafe.deepin.nio.ByteMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by Rudy Steiner on 2018/3/4.
 */
public class LengthBasedEncoder extends MessageToByteEncoder<ByteMessage> {
    @Override
    protected void encode(ChannelHandlerContext ctx, ByteMessage msg, ByteBuf out) throws Exception {
          if(msg== null)
               throw new Exception("null message");
           out.writeByte(msg.getType());
           out.writeInt(msg.getLength());
           out.writeBytes(msg.getBody());
    }
}
