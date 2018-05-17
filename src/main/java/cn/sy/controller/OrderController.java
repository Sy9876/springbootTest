package cn.sy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.sy.domain.Order;
import cn.sy.domain.OrderWithItem;
import cn.sy.dto.HelloBean;
import cn.sy.service.OrderService;


@RestController
public class OrderController {

	private int[] users = { 1, 2, 3, 4, 5 };
	
	@Autowired
	OrderService orderService;
	
	/*
	 * request:
	 *     curl -i "http://localhost:8083/hello?name=sy"
	 * response:
	 *     hello sy
	 */
    @ResponseBody
    @RequestMapping("/order")
    public String order(int count) {
    	System.out.println("OrderController order. count=" + count);
    	
    	for(int i=0;i<count;i++) {
    		int user = users[i%5];
    		orderService.createOrder(user);
    	}
    	
    	return "OK";
    }


    @ResponseBody
    @RequestMapping("/findAll")
    public List<Order> findAll() {
		List<Order> result = orderService.findAll();
		
		return result;
		
	}
    
    @ResponseBody
    @RequestMapping("/findByUser")
    public List<Order> findByUser(int user_id) {
		List<Order> result = orderService.findByUser(user_id);
		
		return result;
		
	}
    
    @ResponseBody
    @RequestMapping("/findOrderWithItem")
    public List<OrderWithItem> findOrderWithItem() {
		List<OrderWithItem> result = orderService.findOrderWithItem();
		
		return result;
		
	}
    
    
    @ResponseBody
    @RequestMapping("/findOrderWithPrice")
    public List<Map<String, String>> findOrderWithPrice() {
    	List<Map<String, String>> result = orderService.findOrderWithPrice();
		
		return result;
		
	}
    
}
