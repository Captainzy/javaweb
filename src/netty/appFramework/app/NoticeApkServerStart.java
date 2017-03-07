package netty.appFramework.app;

import netty.appFramework.common.AppContext;
import netty.appFramework.netty.core.NettyServer;

public class NoticeApkServerStart {
	public static void main(String[] args){
		AppContext.APPLICATIONCONTEXT.getInstantce();
		NettyServer.start();
	}
}
