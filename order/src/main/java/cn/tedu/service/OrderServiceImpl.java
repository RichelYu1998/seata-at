package cn.tedu.service;

import cn.tedu.entity.Order;
import cn.tedu.feign.AccountClient;
import cn.tedu.feign.EasyIdGeneratorClient;
import cn.tedu.feign.StorageClient;
import cn.tedu.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    EasyIdGeneratorClient easyIdGeneratorClient;
    @Resource
    private AccountClient accountClient;
    @Resource
    private StorageClient storageClient;

    @Override
    public void create(Order order) {
        // 从全局唯一id发号器获得id
        Long orderId = easyIdGeneratorClient.nextId("order_business");
        order.setId(orderId);

        orderMapper.create(order);

        // 修改库存
        storageClient.decrease(order.getProductId(), order.getCount());

        // 修改账户余额
        accountClient.decrease(order.getUserId(), order.getMoney());
    }
}