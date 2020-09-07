package cn.tedu.mapper;

import cn.tedu.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface OrderMapper extends BaseMapper<Order> {
    void create(Order order);
}
