package listenerPractice;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class HsListenerTest implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		//System.out.println("HttpSession create");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("HttpSession destroy");
	}

}
