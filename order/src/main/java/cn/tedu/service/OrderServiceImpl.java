package cn.tedu.service;

import cn.tedu.entity.Order;
import cn.tedu.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Override
    public void create(Order order) {
        // TODO: 从全局唯一id发号器获得id，这里暂时随机产生一个 orderId
        Long orderId  = Long.valueOf(new Random().nextInt(Integer.MAX_VALUE));
        order.setId(orderId);
        orderMapper.create(order);
    }
}
