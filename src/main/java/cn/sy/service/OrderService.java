package cn.sy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sy.domain.Order;
import cn.sy.domain.OrderItem;
import cn.sy.domain.OrderWithItem;
import cn.sy.dto.Driver;
import cn.sy.mapper.OrderMapper;
import cn.sy.service.dao.DriverDao;

@Service
public class OrderService {

	@Autowired
	private OrderMapper orderMapper;

	private int order_id=0;
	private int item_id=0;
//	private int user_id=0;
//	private String user_name = null;
//	private String item_name = null;
	
	public List<Order> findAll() {
		List<Order> result = orderMapper.findAll();
		
		return result;
		
	}
	
	public List<Order> findByUser(int user_id) {
		List<Order> result = orderMapper.findByUser(user_id);
		
		return result;
		
	}
	
	public List<OrderWithItem> findOrderWithItem() {
		List<OrderWithItem> result = orderMapper.findOrderWithItem();
		
		return result;
		
	}

	public List<Map<String, String>> findOrderWithPrice() {
		List<Map<String, String>> result = orderMapper.findOrderWithPrice();
		
		return result;
		
	}

	
    public void createOrder(int user) {
    	
    	Order order = null;
    	OrderItem orderItem = null;
    	
    	int ret = 0;
    	
    	System.out.println("OrderService createOrder start. user=" + user);
    	try {
    		
    		order_id++;
    		item_id++;
    		System.out.println("OrderService createOrder order_id=" + order_id + "  item_id=" + item_id);
    		
    		order = new Order();
    		order.setOrder_id(order_id);
    		order.setUser_id(user);
    		order.setUser_name("USER_" + user);
    		
    		orderItem = new OrderItem();
    		orderItem.setItem_id(item_id);
    		orderItem.setItem_name("ITEM_" + item_id);
    		orderItem.setOrder_id(order_id);
    		orderItem.setUser_id(user);
    		
    		ret = orderMapper.insertOrder(order);
    		ret = orderMapper.insertOrderItem(orderItem);

		} catch (Exception e) {
			e.printStackTrace();
		}
    	System.out.println("OrderService createOrder end. return: ");
    }

}
