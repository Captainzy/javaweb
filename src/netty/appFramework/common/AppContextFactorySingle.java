package netty.appFramework.common;

public enum AppContextFactorySingle {
	APPCONTEXTFACTORY;
	private AppContextFactory appContextFactory;
	private AppContextFactorySingle(){
		appContextFactory = new AppContextFactory();
	}
	
	public AppContextFactory getInstantce(){
		return appContextFactory;
	}
}
