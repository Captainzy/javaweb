package webservice.ws2.server;

import javax.jws.WebService;

@WebService(endpointInterface="webservice.ws2.server.OrderProcess")
public class OrderProcessImpl implements OrderProcess {

	@Override
	public String processOrder(Order order) {
		String orderId = validate(order);
		return orderId;
	}
	
	private String validate(Order order){
		String custId = order.getCustomerID();
		String itemId = order.getItemID();
		double price = order.getPrice();
		int qty = order.getQty();
		if(custId!=null && itemId!=null && !"".equals(custId) && !"".equals(itemId) && price>0.0 && qty>0){
			return "od123456";
		}
		return null;
	}
}
