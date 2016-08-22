package listenerPractice;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SrListenerTest implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		//System.out.println("ServletRequest destroy");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		//System.out.println("ServletRequest initialize");
	}

}
