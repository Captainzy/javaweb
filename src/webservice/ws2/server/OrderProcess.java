package webservice.ws2.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface OrderProcess {
	@WebMethod
	public String processOrder(Order order);
}
