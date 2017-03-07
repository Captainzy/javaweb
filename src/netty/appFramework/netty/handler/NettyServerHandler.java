package netty.appFramework.netty.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import netty.appFramework.common.AppContext;

public class NettyServerHandler extends ChannelInboundHandlerAdapter{
	private Logger log = LoggerFactory.getLogger(getClass());
	private ApplicationContext appContext = AppContext.APPLICATIONCONTEXT.getInstantce();

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		log.info("-----------channelActive----------------");
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		log.info("-----------channelInactive----------------");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		log.info("-----------channelRead----------------");
	}

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		log.info("-----------channelRegistered----------------");
	}

	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		log.info("-----------channelUnregistered----------------");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		log.info("-----------exceptionCaught----------------");
	}

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
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		log.info("----------------handlerAdded-------------");
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		log.info("------------------handlerRemoved------------------");
	}
	
	
}
