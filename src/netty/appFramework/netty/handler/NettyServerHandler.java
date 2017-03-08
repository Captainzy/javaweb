package netty.appFramework.netty.handler;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.alibaba.fastjson.JSON;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import netty.appFramework.action.Test;
import netty.appFramework.common.AppContextFactorySingle;
import netty.appFramework.model.APIResult;
import netty.appFramework.netty.proto.ProtoRequest;
import netty.appFramework.netty.proto.ProtoRequest.Request;
import netty.appFramework.netty.proto.ProtoResponse;

public class NettyServerHandler extends ChannelInboundHandlerAdapter{
	private Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		//断开连接时要将客户端的登录信息清除
		log.info("channelInactive");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ApplicationContext appContext = AppContextFactorySingle.APPCONTEXTFACTORY.getInstantce().getAppContext();
		if(msg instanceof ProtoRequest.Request){
			ProtoRequest.Request request = (Request) msg;
			switch(request.getCommandCase()){
			case TEST:
				APIResult<Map<String,Object>> result = new APIResult<Map<String,Object>>();
				Test testAction = appContext.getBean(Test.class);
				result = testAction.testAction();
				ProtoResponse.Response.Builder responseBuilder = ProtoResponse.Response.newBuilder();
				ProtoResponse.TestBuf.Builder testBuilder = ProtoResponse.TestBuf.newBuilder();
				testBuilder.setData(JSON.toJSONString(result));
				responseBuilder.setTest(testBuilder);
				ctx.writeAndFlush(responseBuilder);
				break;
			}
		}else{
			ctx.writeAndFlush(new String("参数不符合要求!!!"));
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		log.info("exceptionCaught");
		//发生异常时，要将客户端的登录信息清除
		cause.printStackTrace();
		
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object e) throws Exception {
		if(e instanceof IdleStateEvent) {
			switch(((IdleStateEvent)e).state()){
			case READER_IDLE:
				System.out.println("----------------很久没有收到客户端消息了，断开连接------------------");
				break;
			case WRITER_IDLE:
				System.out.println("-----------------呼叫客户端保持连接状态----------------------");
				ProtoResponse.Response Response = ProtoResponse.Response.newBuilder().build();
				ctx.writeAndFlush(Response);
				break;
			case ALL_IDLE:
				break;
			}
		}
	}
	
	
}
