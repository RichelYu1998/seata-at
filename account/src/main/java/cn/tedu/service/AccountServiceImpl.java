package cn.tedu.service;

import cn.tedu.mapper.AccountMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        accountMapper.decrease(userId, money);
    }
}
