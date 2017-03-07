package netty.basic;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import netty.basic.Proto.Pc.Endpoint;
import static netty.basic.AttributeKeyConstant.KEY_USERNAME;
public class MyDiscardServerHandler extends DiscardServerHandler<Proto.Pc.Endpoint> {

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.out.println("发生异常，作出反应");
		System.out.println(cause.getMessage());
		ctx.close();
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Endpoint endpoint) throws Exception {
		/**原始ByteBuf*/
//		System.out.println("收到信息，作出反应");
//		ByteBuf bf = (ByteBuf) msg;
//		byte[] b = new byte[bf.readableBytes()];
//		bf.readBytes(b);
//		System.out.println(new String(b,"UTF-8"));
	//	
//		ReferenceCountUtil.release(msg);
	//	
//		String str = "服务端说：你好，我已经收到消息了";
//		byte[] strb = str.getBytes();
//		ByteBuf bbf = Unpooled.buffer(strb.length);
//		bbf.writeBytes(strb);
//		ctx.writeAndFlush(bbf);
		
		/**普通对象*/
//		People p = (People) msg;
//		System.out.println("客户端对象："+p.getName()+"   "+p.getAge());
//		ReferenceCountUtil.release(msg);
	//	
//		People sp = new People();
//		sp.setName("服务端");
//		sp.setAge(132);
//		ctx.writeAndFlush(sp);
		
//		/**google  protobuf*/
//		Auth.AuthRequest res = (AuthRequest) msg;
//		System.out.println("userId = "+res.getUserId()+"\npassword="+res.getPassword());
	//	
//		Auth.AuthResponse.Builder builder = Auth.AuthResponse.newBuilder();
//		builder.setResultCode(123123);
//		builder.setResultMessage("你好，客户端，我是服务端");
//		ctx.writeAndFlush(builder.build());
		System.out.println("收到消息");
		System.out.println(endpoint.getLogin());
		
		Channel channel = ctx.channel();
		/**这里需要注意attr(key),其中key要声明为final避免出现名字重复的异常,经过测试，每个channel都是单独的个体,就像不同的session*/
		channel.attr(KEY_USERNAME).set("zouyang");//类似于session.setAttribute()
		channel.attr(KEY_USERNAME).get();//类似于session.getAttribute()
	}

}
