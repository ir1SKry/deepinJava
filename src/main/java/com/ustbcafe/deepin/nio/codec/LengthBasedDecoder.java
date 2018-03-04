package com.ustbcafe.deepin.nio.codec;

import com.ustbcafe.deepin.nio.ByteMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * Created by Rudy Steiner on 2018/3/4.
 */
public class LengthBasedDecoder extends LengthFieldBasedFrameDecoder{
     private static final  int HEADER_SIZE=5;
     private byte type;
     private int length;
     private String  body;
     /**
      * @param  maxFrameLength
      * @param  lengthFieldOffset
      * @param lengthFieldLength
      * @param lengthAdjustment
      * @param initialBytesToStrip
      * @param  failFast
      **/
      public LengthBasedDecoder(int maxFrameLength,int lengthFieldOffset,int lengthFieldLength,
                                int lengthAdjustment,int initialBytesToStrip,boolean failFast){
          super(maxFrameLength,lengthFieldOffset,lengthFieldLength,lengthAdjustment,initialBytesToStrip,failFast);

      }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        if(in==null){
            return null;
        }
        if(in.readableBytes()<HEADER_SIZE){
            throw new Exception("错误消息");
        }
        type=in.readByte();
        length=in.readInt();
        if(in.readableBytes()<length){
            throw new Exception("消息体和消息长度不匹配");
        }
        ByteBuf buf=in.readBytes(length);
        byte[] b=new byte[buf.readableBytes()];
        buf.readBytes(b);
        ByteMessage msg=new ByteMessage(type,length,b);
        return msg;
    }
}
