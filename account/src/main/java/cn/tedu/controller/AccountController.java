package cn.tedu.controller;

import cn.tedu.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
@Slf4j
public class AccountController {
    @Resource
    private AccountService accountService;
    @GetMapping("/decrease")
    public String decrease(Long userId, BigDecimal money){
        log.info("用户ID为"+userId+";扣款金额为"+money);
        accountService.decrease(userId, money);
        return "用户账户扣减金额成功";
    }
}
