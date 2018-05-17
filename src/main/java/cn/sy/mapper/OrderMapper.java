package cn.sy.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.sy.domain.Order;
import cn.sy.domain.OrderItem;
import cn.sy.domain.OrderWithItem;

@Mapper
public interface OrderMapper {

    int insertOrder(Order record);

    int insertOrderItem(OrderItem record);

    List<Order> findAll();
    
    List<Order> findByUser(@Param("user_id") int user_id);
    
    List<OrderWithItem> findOrderWithItem();
    
    List<Map<String, String>> findOrderWithPrice();
}
