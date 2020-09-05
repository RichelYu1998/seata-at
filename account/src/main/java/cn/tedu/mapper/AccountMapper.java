package cn.tedu.mapper;

import cn.tedu.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.math.BigDecimal;

public interface AccountMapper extends BaseMapper<Account> {
    void decrease(Long userId, BigDecimal money);
}
