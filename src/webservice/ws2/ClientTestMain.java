package webservice.ws2;

import java.util.List;
import webservice.ws2.client.GetOrderMapResponse.Return;
import webservice.ws2.client.GetOrderMapResponse.Return.Entry;
import webservice.ws2.client.Order;
import webservice.ws2.client.OrderProcess;
import webservice.ws2.client.OrderProcessImplService;

public class ClientTestMain {

	public static void main(String[] args) {
		OrderProcessImplService factory = new OrderProcessImplService();
		OrderProcess op = factory.getOrderProcessImplPort();
		Order order = new Order();
		order.setCustomerID("123");
		order.setItemID("1");
		order.setPrice(2.2);
		order.setQty(1);
		String result = op.processOrder(order);
		List<Order> list = op.getOrderList();
		Return r = op.getOrderMap();
		List<Entry> listEntry = r.getEntry();
	    System.out.println(result);
	    System.out.println("---------------------------------");
	    for(Order or:list){
	    	System.out.println(or.getCustomerID()+" "+or.getItemID()+" "+or.getPrice() + " " + or.getQty());
	    }
	    System.out.println("---------------------------------");
	    for(Entry entry:listEntry){
	    	Order or = entry.getValue();
	    	System.out.println(or.getCustomerID()+" "+or.getItemID()+" "+or.getPrice() + " " + or.getQty());
	    }
	}

}
