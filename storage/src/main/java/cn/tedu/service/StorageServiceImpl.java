package cn.tedu.service;

import cn.tedu.mapper.StorageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageMapper storageMapper;
    @Override
    public void decrease(Long productId, Integer count) throws Exception {
        storageMapper.decrease(productId,count);
    }
}
