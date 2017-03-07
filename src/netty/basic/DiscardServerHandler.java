package netty.basic;


import com.google.protobuf.MessageOrBuilder;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
public abstract class DiscardServerHandler<I extends MessageOrBuilder> extends SimpleChannelInboundHandler<I>{
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object e) throws Exception {
		if(e instanceof IdleStateEvent) {
			switch(((IdleStateEvent)e).state()){
			case READER_IDLE:
				System.out.println("----------------很久没有收到客户端消息了，断开连接------------------");
				ctx.close();
				break;
			case WRITER_IDLE:
				System.out.println("-----------------写超时，断开连接----------------------");
				ctx.close();
				break;
			case ALL_IDLE:
				break;
			}
		}
	}

	@Override
	protected void channelRead0(ChannelHandlerContext arg0, I arg1) throws Exception {
		super.channelRead(arg0, arg1);
	}



}
